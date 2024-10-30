package tech.jhipster.lite.shared.github.domain.authentication;

import tech.jhipster.lite.shared.error.domain.Assert;

public record GithubAuthenticationCode(String code) {
  public GithubAuthenticationCode {
    Assert.notBlank("code", code);
  }
}
