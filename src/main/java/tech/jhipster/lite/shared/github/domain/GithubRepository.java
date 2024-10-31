package tech.jhipster.lite.shared.github.domain;

import tech.jhipster.lite.shared.github.domain.authentication.GithubAuthenticationCode;
import tech.jhipster.lite.shared.github.domain.authentication.GithubAuthorizationUrl;
import tech.jhipster.lite.shared.github.domain.authentication.GithubToken;

public interface GithubRepository {
  GithubAuthorizationUrl buildAuthorizationUrl();
  GithubToken authenticate(GithubAuthenticationCode code);
}
