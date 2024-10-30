package tech.jhipster.lite.shared.github.domain.oauth;

import tech.jhipster.lite.shared.error.domain.Assert;

public record GithubOauth2Url(String url) {
  public GithubOauth2Url {
    Assert.notBlank("url", url);
  }
}
