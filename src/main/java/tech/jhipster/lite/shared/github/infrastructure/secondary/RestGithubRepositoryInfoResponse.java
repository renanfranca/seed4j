package tech.jhipster.lite.shared.github.infrastructure.secondary;

import tech.jhipster.lite.shared.github.domain.GithubRepositoryInfo;

record RestGithubRepositoryInfoResponse(String name) {
  public GithubRepositoryInfo toDomain() {
    return new GithubRepositoryInfo(name);
  }
}
