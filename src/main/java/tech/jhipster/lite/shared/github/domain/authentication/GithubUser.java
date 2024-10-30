package tech.jhipster.lite.shared.github.domain.authentication;

import tech.jhipster.lite.shared.error.domain.Assert;

public record GithubUser(String id, String login, String name, String email) {
  public GithubUser {
    Assert.notBlank("id", id);
    Assert.notBlank("login", login);
    // name and email can be null
  }
}
