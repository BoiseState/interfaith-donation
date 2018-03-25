<template>
  <div class="jumbotron">
    <div class="container">
      <b-card>
        <router-link class="btn btn-default; greyButton" to="/register-user">Add User&raquo;</router-link>
      <b-row>
        <b-col md="6" class="my-1">
            <b-input-group>
              <b-form-input v-model="filter" placeholder="Type to Search" />
              <b-input-group-append>
                <b-btn :disabled="!filter" @click="filter = ''">Clear</b-btn>
              </b-input-group-append>
            </b-input-group>
        </b-col>
      </b-row>

      <h3>Users</h3>
      <b-table outlined hover :fields="fields" :filter="filter" :items="users">
        <template slot="permissions" slot-scope="row">
          <b-badge>{{row.item.stringPermissions}}</b-badge>
        </template>
        <template slot="active" slot-scope="row">
          <template v-if="row.item.active">
            <a class="glyphicon glyphicon-ok" style="color: grey"></a>
          </template>
        </template>
        <template slot="edit" slot-scope="row">
          <router-link :to="{ name: 'user', params: { id: row.item.id }}"  class="glyphicon glyphicon-pencil" style="color: grey;" role="button"></router-link>
        </template>
      </b-table>
      </b-card>
    </div>
  </div>
</template>

<script>
import { getAllUsers } from '../../services/user-service';

export default {
  name: 'user-list',
  data() {
    return {
      users: [],
      sortBy: 'age',
      sortDesc: false,
      fields: [
        { key: 'userName', sortable: true },
        { key: 'permissions', sortable: true, class: 'text-center' },
        { key: 'email', sortable: true },
        { key: 'active', sortable: true, class: 'text-center' },
        { key: 'edit', sortable: false, class: 'text-center' }
      ],
      filter: null
    };
  },
  created() {
    let self = this;
    getAllUsers().then(users => {
      this.users = users;
      this.users.forEach(user => {
        user.stringPermissions = self.getPermissions(user);
      });
    });
  },
  methods: {
    getPermissions(user) {
      if (user.permissions === null || user.permissions === 0) {
        return 'No Permissions';
      } else if (user.permissions === 1) {
        return 'Admin';
      } else if (user.permissions === 2) {
        return 'Jody/SuperAdmin';
      }
      return 'Invalid Permissions';
    }
  }
};
</script>

<style>
.greyButton {
  color: white;
  background-color: grey;
}
</style>
