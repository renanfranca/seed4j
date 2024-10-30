package tech.jhipster.lite.shared.github.application;

import org.springframework.stereotype.Service;
import tech.jhipster.lite.shared.github.domain.GithubRepository;
import tech.jhipster.lite.shared.github.domain.authentication.GithubAuthenticationCode;
import tech.jhipster.lite.shared.github.domain.authentication.GithubToken;
import tech.jhipster.lite.shared.github.domain.authentication.GithubUser;

@Service
public class GithubApplicationService {

  private final GithubRepository github;

  public GithubApplicationService(GithubRepository github) {
    this.github = github;
  }

  public String getAuthorizationUrl() {
    return github.buildAuthorizationUrl();
  }

  public GithubUser authenticate(String code) {
    GithubToken token = github.authenticate(new GithubAuthenticationCode(code));
    return github.getUser(token);
  }
}
