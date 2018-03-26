<template>
  <div class="addadmin">
    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <div class="container"><!--action="ws/user/createAdmin" method="POST" goes in form class -->
      <h2>Register as a New Administrator</h2>
        <!-- <form class="form-horizontal" id ="createAdminForm" > -->
          <form v-on:submit.prevent="onFormSubmit" class="form-horizontal">
          <div class="form-group">
            <label class="control-label col-sm-2">User Name:</label>
            <input v-model="user.userName" name="userName" type="text" width="50" required>
          </div>

          <!-- <div class="form-group">
            <label class="control-label col-sm-2">Username:</label>
            <input id = "user-name-label" name="userName" type="text" width="50" required></div> -->
          <div class="form-group">
            <label class="control-label col-sm-2">Email:</label>
            <input v-model="user.email" name="emailAddress" type="text" width="50" required></div>
          <div class="form-group">
            <label class="control-label col-sm-2">Password:</label>
            <input v-model="user.password" name="password" type="password" width="50" required></div>
          <div class="form-group">
            <label class="control-label col-sm-2">Confirm Password:</label>
            <input id="password2-label" name="confirm" type="password" width="50" required></div>
          <!-- <button type="submit" id="createAdminSubmit">Create Account</button> -->
          <button class="btn btn-default, greyButton, col-sm-2" type="submit">Create Account</button>

        </form>
      </div>
    </div>
  </div>
</template>

<script>
import { createUser } from '../../services/user-service';

export default {
  name: 'register-user',
  data() {
    return {
      user: {
        id: '',
        userName: '',
        permissions: 0,
        active: false,
        password: '',
        email: ''
      },
      errors: []
    };
  },
  methods: {
    onFormSubmit() {
      createUser(this.user);
    }
  }
};
</script>

<style scoped>

</style>
