package tech.jhipster.lite.shared.github.infrastructure.secondary;

import tech.jhipster.lite.shared.github.domain.GithubUser;

record RestGithubUserResponse(String login) {
  public GithubUser toDomain() {
    return new GithubUser(login);
  }
}
