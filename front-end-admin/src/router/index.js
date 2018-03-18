import Vue from 'vue';
import Router from 'vue-router';
import Home from '@/components/pages/Home';
import DonorInfo from '@/components/donor/DonorInfo';
import DonorList from '@/components/donor/DonorList';
import RegisterDonor from '@/components/donor/RegisterDonor';
import CalloutInfo from '@/components/callout/CalloutInfo';
import CalloutList from '@/components/callout/CalloutList';
import RegisterCallout from '@/components/callout/RegisterCallout';
import UserInfo from '@/components/user/UserInfo';
import UserList from '@/components/user/UserList';
import About from '@/components/pages/About';
import RegisterUser from '@/components/user/RegisterUser';
import NeedInfo from '@/components/need/NeedInfo';
import NeedList from '@/components/need/NeedList';
import NeedSelect from '@/components/need/NeedSelect';

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/',
      component: Home
    },
    {
      path: '/donor/:id',
      name: 'donorInfo',
      component: DonorInfo
    },
    {
      path: '/donors',
      component: DonorList
    },
    {
      path: '/register-donor',
      name: 'register donor',
      component: RegisterDonor
    },
    {
      path: '/callout/register',
      component: RegisterCallout
    },
    {
      path: '/callout/:id',
      name: 'callout',
      component: CalloutInfo
    },
    {
      path: '/callouts',
      component: CalloutList
    },
    {
      path: '/user/:id',
      component: UserInfo
    },
    {
      path: '/users',
      component: UserList
    },
    {
      path: '/about',
      component: About
    },
    {
      path: '/register-user',
      component: RegisterUser
    },
    {
      path: '/need/:id',
      name: 'need information',
      component: NeedInfo
    },
    {
      path: '/needs',
      name: 'list of needs',
      component: NeedList
    },
    {
      path: '/select-need',
      name: 'list of needs to select from',
      component: NeedSelect
    }
  ]
});
