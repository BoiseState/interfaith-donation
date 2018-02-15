import Vue from 'vue';
import Router from 'vue-router';
import Home from '@/components/pages/Home';
import DonorInfo from '@/components/donor/DonorInfo';
import DonorList from '@/components/donor/DonorList';
import CalloutInfo from '@/components/callout/CalloutInfo';
import CalloutList from '@/components/callout/CalloutList';
import RegisterCallout from '@/components/callout/RegisterCallout';
import UserInfo from '@/components/user/UserInfo';
import UserList from '@/components/user/UserList';

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
    },
    {
      path: '/callout/register',
      name: 'register callout',
      component: RegisterCallout
    },
    {
      path: '/callout/:id',
      name: 'callout information',
      component: CalloutInfo
    },
    {
      path: '/callouts',
      name: 'list of callouts',
      component: CalloutList
    },
    {
      path: '/user/:id',
      name: 'user information',
      component: UserInfo
    },
    {
      path: '/users',
      name: 'list of users',
      component: UserList
    }

  ]
});
