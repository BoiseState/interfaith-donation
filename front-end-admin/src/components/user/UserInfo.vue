<template>
  <div class="userInfoPage">
    <div class="jumbotron">
      <div class="container">
      <b-card :title="user.email">
        <b-form @submit="onFormSubmit" class="form-horizontal" >
          <input type="hidden" name="user_id" v-model="user.id">
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
          <h5>Set Permissions: </h5>
          <b-dropdown id="ddown-divider" v-model="user.permissions" :text="getPermissionText()" class="m-2">
            <b-dropdown-item-button v-on:click="updatePermissions(0)">No Permissions</b-dropdown-item-button>
            <b-dropdown-item-button v-on:click="updatePermissions(1)">Admin Permissions</b-dropdown-item-button>
            <b-dropdown-divider></b-dropdown-divider>
            <b-dropdown-item-button v-on:click="updatePermissions(2)">Super Admin/Jody Permissions</b-dropdown-item-button>
          </b-dropdown>
          <b-form-group label="Active:"
                        label-for="register-need-active"
          >
            <b-form-checkbox id="register-need-active"
                             v-model="user.active"
            >
            </b-form-checkbox>
          </b-form-group>
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
import { getUserById, updateUser } from '../../services/user-service';
import Helper from '../helpers/Helper.vue';

export default {
  name: 'user-info',
  data() {
    return {
      user: {
        id: null,
        userName: 'Loading...',
        permissions: null,
        active: true,
        email: 'Template New User',
        password: ''
      }
    };
  },
  created() {
    getUserById(this.$route.params.id).then(user => {
      this.user = user;
    });
  },
  methods: {
    onFormSubmit(evt) {
      evt.preventDefault();
      // createUser(this.user);
      updateUser(this.user);
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
