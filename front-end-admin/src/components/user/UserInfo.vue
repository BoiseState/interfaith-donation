<template>
  <div class="userInfoPage">
    <div class="jumbotron">
      <b-card :title="user.email">
        <b-form @submit="onFormSubmit" class="form-horizontal" >
          <input type="hidden" name="user_id" v-model="user.id">
          <h5>Full Name: </h5>
          <b-form-textarea v-model="user.name"
                           required
                           placeholder="Enter name.."
                           :rows="1"
                           no-resize=true
                           name="name"
                           :max-rows="1">
          </b-form-textarea>
          <h5>Email: </h5>
          <b-form-textarea v-model="user.email"
                           placeholder="Enter email addresss.."
                           :rows="1"
                           no-resize=true
                           name="email"
                           :max-rows="1">
          </b-form-textarea>
          <br>
          <b-dropdown id="ddown-divider" v-model="user.permissions" :text="getPermissionText()" class="m-2">
            <b-dropdown-item-button v-on:click="updatePermissions(0)">No Permissions</b-dropdown-item-button>
            <b-dropdown-item-button v-on:click="updatePermissions(1)">Admin Permissions</b-dropdown-item-button>
            <b-dropdown-divider></b-dropdown-divider>
            <b-dropdown-item-button v-on:click="updatePermissions(2)">Super Admin/Jody Permissions</b-dropdown-item-button>
          </b-dropdown>
          <b-button type="submit" variant="primary">Submit</b-button>
        </b-form>
      </b-card>
    </div>
  </div>
</template>

<script>
import { getUserById, createUser } from '../../services/user-service';

export default {
  name: 'user-info',
  data() {
    return {
      user: {
        name: 'Loading...',
        email: ''
      }
    };
  },
  created() {
    getUserById(this.$route.params.id).then(user => {
      this.user = user;
    });
  },
  methods: {
    onFormSubmit() {
      createUser(this.user);
    },
    updatePermissions(permissionLevel) {
      this.user.permissions = permissionLevel;
      console.log(this.user.permissions);
    },
    getPermissionText() {
      console.log(this.user.permissions);
      if (this.user.permissions === 0) {
        return 'No Permissions';
      } else if (this.user.permissions === 1) {
        return 'Admin';
      } else if (this.user.permissions === 2) {
        return 'Super Admin/Jody';
      }
      return 'Invalid Permissions';
    }
  }
};
</script>

<style scoped>

</style>
