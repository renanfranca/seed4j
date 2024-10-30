package tech.jhipster.lite.shared.github.infrastructure.primary;

import io.swagger.v3.oas.annotations.media.Schema;
import tech.jhipster.lite.shared.github.domain.authentication.GithubUser;

@Schema(name = "GithubUser", description = "Information about a GitHub user")
public record RestGithubUser(
  @Schema(description = "GitHub user ID") String id,
  @Schema(description = "GitHub username") String login,
  @Schema(description = "GitHub user's full name") String name,
  @Schema(description = "GitHub user's email") String email
) {
  public GithubUser toDomain() {
    return new GithubUser(id, login, name, email);
  }

  public static RestGithubUser from(GithubUser user) {
    return new RestGithubUser(user.id(), user.login(), user.name(), user.email());
  }
}
