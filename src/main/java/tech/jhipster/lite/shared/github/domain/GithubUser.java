package tech.jhipster.lite.shared.github.domain;

import tech.jhipster.lite.shared.error.domain.Assert;

public record GithubUser(String login) {
  public GithubUser {
    Assert.notBlank("login", login);
  }
}
