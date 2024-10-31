package tech.jhipster.lite.shared.github.infrastructure.secondary;

import com.fasterxml.jackson.annotation.JsonProperty;
import tech.jhipster.lite.shared.github.domain.authentication.GithubToken;

record RestGithubTokenResponse(@JsonProperty("access_token") String accessToken, @JsonProperty("token_type") String tokenType) {
  public GithubToken toDomain() {
    return new GithubToken(accessToken, tokenType);
  }
}
