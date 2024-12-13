import { inject } from '@/injections';
import { GITHUB_REPOSITORY } from '@/module/application/ModuleProvider';
import type { GithubOrganization } from '@/module/domain/GithubOrganization';
import type { GithubToken } from '@/module/domain/GithubToken';
import router from '@/router';
import { IconVue } from '@/shared/icon/infrastructure/primary';
import { defineComponent, onMounted, ref } from 'vue';

export default defineComponent({
  name: 'GithubRepositoryVue',
  components: { IconVue },
  setup() {
    const githubRepository = inject(GITHUB_REPOSITORY);
    const isAuthenticated = ref(false);
    const organizations = ref<GithubOrganization[]>([]);
    const selectedOrganization = ref<GithubOrganization | null>(null);

    const loadOrganizations = (token: GithubToken) => {
      githubRepository
        .listOrganizations(token)
        .then(orgs => {
          organizations.value = orgs;
        })
        .catch(error => console.error('Error loading organizations:', error));
    };

    onMounted(() => {
      isAuthenticated.value = githubRepository.authenticated();

      if (isAuthenticated.value) {
        const token: GithubToken = JSON.parse(localStorage.getItem('github-token') as string);
        loadOrganizations(token);
      }
    });

    const connectToGithub = () => {
      githubRepository
        .getAuthorizationUrl()
        .then(githubAuthorizationUrl => {
          const currentPath = router.currentRoute.value.fullPath;
          const githubAuthUrlWithState = `${githubAuthorizationUrl}&state=${encodeURIComponent(currentPath)}`;
          window.location.assign(githubAuthUrlWithState);
        })
        .catch(error => console.error('Error getting authorization URL:', error));
    };

    const goToConfiguration = () => {
      router.push('/github-configuration');
    };

    return {
      isAuthenticated,
      organizations,
      selectedOrganization,
      connectToGithub,
      goToConfiguration,
    };
  },
});
