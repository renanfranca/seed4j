package tech.jhipster.lite.shared.github.domain.authentication;

import tech.jhipster.lite.shared.error.domain.Assert;

public record GithubAuthorizationUrl(String url) {
  public GithubAuthorizationUrl {
    Assert.notBlank("url", url);
  }

  public static GithubAuthorizationUrl from(String url) {
    return new GithubAuthorizationUrl(url);
  }
}
