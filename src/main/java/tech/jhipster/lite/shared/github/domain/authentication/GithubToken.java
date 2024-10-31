package tech.jhipster.lite.shared.github.domain.authentication;

import tech.jhipster.lite.shared.error.domain.Assert;

public record GithubToken(String accessToken, String tokenType) {
  public GithubToken {
    Assert.notBlank("accessToken", accessToken);
    Assert.notBlank("tokenType", tokenType);
  }

  public String authorizationHeader() {
    return tokenType + " " + accessToken;
  }
}
