<template>
  <div class="addUserPage">
    <div class="jumbotron">
      <div class="container">
      <b-card :title="titleText">
        <b-form @submit="onFormSubmit" class="form-horizontal" >
          <h5>User Name: </h5>
          <b-form-input    v-model="user.userName"
                           required
                           placeholder="Enter name.."
                           name="name">
          </b-form-input>

          <h5>Email: </h5>
          <b-form-input    v-model="user.email"
                           required
                           placeholder="Enter email addresss.."
                           name="email">
          </b-form-input>

          <h5>Password: </h5>
          <b-form-input    v-model="user.password"
                           required
                           placeholder="Enter a password.."
                           name="password">
          </b-form-input>

          <h5>Set Permissions: </h5>
          <b-dropdown id="ddown-divider" v-model="user.permissions" :text="getPermissionText()" class="m-2">
            <b-dropdown-item-button v-on:click="updatePermissions(0)">No Permissions</b-dropdown-item-button>
            <b-dropdown-item-button v-on:click="updatePermissions(1)">Admin Permissions</b-dropdown-item-button>
            <b-dropdown-divider></b-dropdown-divider>
            <b-dropdown-item-button v-on:click="updatePermissions(2)">Super Admin/Jody Permissions</b-dropdown-item-button>
          </b-dropdown>
          <br>
          <br>
          <b-button type="submit" variant="success">Submit</b-button>
        </b-form>
      </b-card>
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
        permissions: 'BASIC_USER',
        active: false,
        password: '',
        email: ''
      },
      titleText: 'Register a New Adminitrator'
    };
  },
  methods: {
    onFormSubmit(evt) {
      evt.preventDefault();
      createUser(this.user);
    },
    updatePermissions(permissionLevel) {
      if (permissionLevel === 1) {
        this.user.permissions = 'ADMINISTRATOR';
      } else if (permissionLevel === 2) {
        this.user.permissions = 'SUPERADMIN';
      } else {
        this.user.permissions = 'BASIC_USER';
      }
    },
    getPermissionText() {
      if (this.user.permissions === 'BASIC_USER') {
        return 'No Permissions';
      } else if (this.user.permissions === 'ADMINISTRATOR') {
        return 'Admin';
      } else if (this.user.permissions === 'SUPERADMIN') {
        return 'Super Admin/Jody';
      }
      this.user.permissions = 'BASIC_USER';
      return 'No Permissions';
    }
  }
};
</script>

<style scoped>

</style>
