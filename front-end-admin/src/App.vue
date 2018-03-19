<template>
  <div>
    <navigation>
      <div v-if="!loggedIn">
        <login />
      </div>
      <div v-else>
        <logout />
      </div>
    </navigation>
    <br><br><br>
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
  },
  data: () => {
    return {
      loggedIn: false
    };
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
