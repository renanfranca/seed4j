package tech.jhipster.lite.shared.github.domain;

import tech.jhipster.lite.shared.github.domain.authentication.GithubAuthenticationCode;
import tech.jhipster.lite.shared.github.domain.authentication.GithubToken;
import tech.jhipster.lite.shared.github.domain.authentication.GithubUser;

public interface GithubRepository {
  String buildAuthorizationUrl();
  GithubToken authenticate(GithubAuthenticationCode code);
  GithubUser getUser(GithubToken token);
}
