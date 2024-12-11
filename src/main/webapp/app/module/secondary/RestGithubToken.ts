import { GithubToken } from '@/module/domain/GithubToken';
import { AxiosResponse } from 'axios';

export interface RestGithubToken {
  accessToken: string;
  tokenType: string;
}

export const mapToGithubToken = (response: AxiosResponse<RestGithubToken>): GithubToken => {
  const data = response.data;
  return {
    accessToken: data.accessToken,
    tokenType: data.tokenType,
  };
};
