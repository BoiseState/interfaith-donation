import Vue from 'vue';
import Router from 'vue-router';
import Home from '@/components/pages/Home';
import DonorInfo from '@/components/donor/DonorInfo';
import DonorList from '@/components/donor/DonorList';

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Interfaith Sanctuary',
      component: Home
    },
    {
      path: '/donor/:id',
      name: 'donor information',
      component: DonorInfo
    },
    {
      path: '/donors',
      name: 'list of donors',
      component: DonorList
    }
  ]
});
