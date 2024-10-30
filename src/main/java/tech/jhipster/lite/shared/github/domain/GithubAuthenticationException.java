package tech.jhipster.lite.shared.github.domain;

import tech.jhipster.lite.shared.error.domain.GeneratorException;

public class GithubAuthenticationException extends GeneratorException {

  public GithubAuthenticationException(String message) {
    super(badRequest(GithubErrorKey.INVALID_AUTHENTICATION).message(message));
  }

  public GithubAuthenticationException(String message, Throwable cause) {
    super(badRequest(GithubErrorKey.INVALID_AUTHENTICATION).message(message).cause(cause));
  }
}
