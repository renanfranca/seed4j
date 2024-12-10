import { inject } from '@/injections';
import { GITHUB_REPOSITORY } from '@/module/application/ModuleProvider';
import type { GithubToken } from '@/module/domain/GithubToken';
import router from '@/router';
import { IconVue } from '@/shared/icon/infrastructure/primary';
import { defineComponent, onMounted, ref } from 'vue';
import { useRoute } from 'vue-router';

export default defineComponent({
  name: 'GithubConfigurationVue',
  components: { IconVue },
  setup() {
    const githubRepository = inject(GITHUB_REPOSITORY);
    const route = useRoute();
    const githubToken = ref<GithubToken | null>(null);

    onMounted(() => {
      const code = route.query.code as string;
      if (code) {
        githubRepository
          .authenticate(code)
          .then(token => {
            githubToken.value = token;
          })
          .catch(error => console.error('Authentication error:', error));
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

    return {
      connectToGithub,
      githubToken,
    };
  },
});
