package tech.jhipster.lite.shared.github.infrastructure.secondary;

import com.fasterxml.jackson.annotation.JsonProperty;

record RestGithubTokenRequest(
  @JsonProperty("client_id") String clientId,
  @JsonProperty("client_secret") String clientSecret,
  String code
) {}
