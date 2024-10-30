package tech.jhipster.lite.shared.github.infrastructure.secondary;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import tech.jhipster.lite.shared.github.domain.GithubRepository;
import tech.jhipster.lite.shared.github.domain.authentication.GithubAuthenticationCode;
import tech.jhipster.lite.shared.github.domain.authentication.GithubToken;
import tech.jhipster.lite.shared.github.domain.authentication.GithubUser;
import tech.jhipster.lite.shared.github.domain.oauth.GithubOauth2Configuration;
import tech.jhipster.lite.shared.github.infrastructure.primary.RestGithubToken;
import tech.jhipster.lite.shared.github.infrastructure.primary.RestGithubUser;

@SuppressWarnings("java:S6212")
@Repository
public class HttpGithubRepository implements GithubRepository {

  private static final String GITHUB_TOKEN_URL = "https://github.com/login/oauth/access_token";
  private static final String GITHUB_USER_URL = "https://api.github.com/user";

  private final RestTemplate restTemplate;
  private final GithubOauth2Configuration configuration;

  public HttpGithubRepository(RestTemplate restTemplate, GithubOauth2Configuration configuration) {
    this.restTemplate = restTemplate;
    this.configuration = configuration;
  }

  @Override
  public String buildAuthorizationUrl() {
    return configuration.buildAuthorizationUrl();
  }

  @Override
  public GithubToken authenticate(GithubAuthenticationCode code) {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.setAccept(java.util.List.of(MediaType.APPLICATION_JSON));

    var body = new RestGithubTokenRequest(configuration.clientId(), configuration.clientSecret(), code.code());

    var request = new HttpEntity<>(body, headers);
    var response = restTemplate.postForEntity(GITHUB_TOKEN_URL, request, RestGithubToken.class);

    return response.getBody().toDomain();
  }

  @Override
  public GithubUser getUser(GithubToken token) {
    HttpHeaders headers = new HttpHeaders();
    headers.setBearerAuth(token.accessToken());
    headers.setAccept(java.util.List.of(MediaType.APPLICATION_JSON));

    var request = new HttpEntity<>(headers);
    var response = restTemplate.exchange(GITHUB_USER_URL, HttpMethod.GET, request, RestGithubUser.class);

    return response.getBody().toDomain();
  }
}
