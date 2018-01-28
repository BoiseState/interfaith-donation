import Vue from 'vue';
import Router from 'vue-router';
import Home from '@/components/pages/Home';

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Interfaith Sanctuary',
      component: Home
    }
  ]
});
