package tech.jhipster.lite.shared.github.domain.oauth;

public enum GithubScope {
  USER_EMAIL("user:email"),
  READ_USER("read:user");

  private final String scope;

  GithubScope(String scope) {
    this.scope = scope;
  }

  public String get() {
    return scope;
  }
}
