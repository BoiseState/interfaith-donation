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
import Helper from '../helpers/Helper.vue';

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
      titleText: 'Register a New Administrator'
    };
  },
  methods: {
    onFormSubmit(evt) {
      evt.preventDefault();
      createUser(this.user);
    },
    updatePermissions(permissionLevel) {
      this.user.permissions = Helper.methods.getPermissionsLevel(
        permissionLevel
      );
    },
    getPermissionText() {
      return Helper.methods.getPermissionText(this.user);
    }
  }
};
</script>

<style scoped>

</style>
