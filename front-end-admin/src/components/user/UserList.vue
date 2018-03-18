<template>
  <div class="jumbotron">
    <div class="container">
      <router-link class="btn btn-default" to="/user/register">Add User&raquo;</router-link>
      <!-- TODO: Add form for searching through users -->
      <h3>Users</h3>
      <table class="table">
        <thead>
        <tr>
          <th>User Email</th>
          <th>Is Admin</th>
          <th>Is Active</th>
        </tr>
        </thead>
        <tbody id="fulluserTBody">
        <tr v-for="user in users" :key="user.id">
          <td>{{user.email}}</td>
          <td>{{user.permissions}}</td>
          <td>{{user.active}}</td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import { getAllUsers } from '../../services/user-service';

export default {
  name: 'user-list',
  data() {
    return {
      users: []
    };
  },
  created() {
    getAllUsers().then(users => {
      this.users = users;
    });
  }
};
</script>

<style scoped>

</style>
