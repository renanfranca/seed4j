package tech.jhipster.lite.shared.github.infrastructure.primary;

import tech.jhipster.lite.shared.error.domain.Assert;
import tech.jhipster.lite.shared.github.domain.authentication.GithubAuthorizationUrl;

public record RestGithubAuthorizationUrl(String url) {
  public RestGithubAuthorizationUrl {
    Assert.notBlank("url", url);
  }

  public static RestGithubAuthorizationUrl from(GithubAuthorizationUrl authorizationUrl) {
    return new RestGithubAuthorizationUrl(authorizationUrl.url());
  }
}
