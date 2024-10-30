package tech.jhipster.lite.shared.github.domain;

import tech.jhipster.lite.shared.error.domain.ErrorKey;

enum GithubErrorKey implements ErrorKey {
  INVALID_AUTHENTICATION("invalid-github-authentication"),
  INVALID_TOKEN("invalid-github-token");

  private final String key;

  GithubErrorKey(String key) {
    this.key = key;
  }

  @Override
  public String get() {
    return key;
  }
}
