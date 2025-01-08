package tech.jhipster.lite.shared.github.domain;

import tech.jhipster.lite.shared.error.domain.Assert;

public record GithubRepositoryInfo(String name) {
  public GithubRepositoryInfo {
    Assert.notBlank("name", name);
  }
}
