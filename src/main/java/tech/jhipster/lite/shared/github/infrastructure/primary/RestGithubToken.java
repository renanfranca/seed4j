package tech.jhipster.lite.shared.github.infrastructure.primary;

import tech.jhipster.lite.shared.github.domain.authentication.GithubToken;

public record RestGithubToken(String accessToken, String tokenType) {
  public static RestGithubToken from(GithubToken token) {
    return new RestGithubToken(token.accessToken(), token.tokenType());
  }
}
