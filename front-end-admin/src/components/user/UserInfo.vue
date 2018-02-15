<template>
  <div class="userInfoPage">
    <div class="jumbotron">
      <h2>user info page for {{user.name}}</h2>
      <form v-on:submit.prevent="onFormSubmit" class="form-horizontal">
        <button type="submit">Update user</button>
        <div class="form-group">
          <label class="control-label col-sm-2">Full Name:</label>
          <input v-model="user.name" name="name" type="text" width="50" required>
        </div>
        <div class="form-group">
          <label class="control-label col-sm-2">Email Address:</label>
          <input v-model="user.email" name="email" type="email" width="50" required>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import {getUserById, createUser} from '../../services/user-service';

export default {
  name: 'user-info',
  data () {
    return {
      user: {
        name: 'Loading...',
        email: ''
      }
    };
  },
  created () {
    getUserById(this.$route.params.id).then(user => {
      this.user = user;
    });
  },
  methods: {
    onFormSubmit () {
      createUser(this.user);
    }
  }
};
</script>

<style scoped>

</style>
