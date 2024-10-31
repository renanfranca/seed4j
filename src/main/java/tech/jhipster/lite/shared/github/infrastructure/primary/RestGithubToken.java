package tech.jhipster.lite.shared.github.infrastructure.primary;

import com.fasterxml.jackson.annotation.JsonProperty;
import tech.jhipster.lite.shared.github.domain.authentication.GithubToken;

public record RestGithubToken(@JsonProperty("access_token") String accessToken, @JsonProperty("token_type") String tokenType) {
  public GithubToken toDomain() {
    return new GithubToken(accessToken, tokenType);
  }

  public static RestGithubToken from(GithubToken token) {
    return new RestGithubToken(token.accessToken(), token.tokenType());
  }
}
