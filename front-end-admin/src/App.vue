<template>
  <div>
    <navigation>
      <login />
    </navigation>
    <router-view/>
  </div>
</template>

<script>
import Navigation from '@/components/layout/Navigation';
import Login from '@/components/user/Login';
import Logout from '@/components/user/Logout';

export default {
  name: 'App',
  components: {
    Navigation,
    Login,
    Logout
  }
};
</script>

<style>
  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
  }
</style>
