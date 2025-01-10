import type { GithubAuthorizationUrl } from '@/module/domain/GithubAuthorizationUrl';
import type { GithubOrganization } from '@/module/domain/GithubOrganization';
import type { GithubToken } from '@/module/domain/GithubToken';
import type { GithubRepositoryInfo } from './GithubRepositoryInfo';

export interface GithubRepository {
  getAuthorizationUrl(): Promise<GithubAuthorizationUrl>;
  authenticate(code: string): Promise<GithubToken>;
  listOrganizations(token: GithubToken): Promise<GithubOrganization[]>;
  authenticated(): boolean;
  listRepositories(token: GithubToken, organization: string): Promise<GithubRepositoryInfo[]>;
}
