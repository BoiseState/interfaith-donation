<template>
  <div class="jumbotron">
    <div class="container">
      <router-link class="btn btn-default" to="/user/register">Add User&raquo;</router-link>
      <!-- TODO: Add form for searching through users -->
      <b-row>
        <b-col md="6" class="my-1">
          <b-form-group horizontal label="Filter" class="mb-0">
            <b-input-group>
              <b-form-input v-model="filter" placeholder="Type to Search" />
              <b-input-group-append>
                <b-btn :disabled="!filter" @click="filter = ''">Clear</b-btn>
              </b-input-group-append>
            </b-input-group>
          </b-form-group>
        </b-col>
      </b-row>

      <h3>Users</h3>
      <b-table outlined hover :fields="fields" :filter="filter" :items="users">
        <template slot="active" slot-scope="row">
          <b-form-checkbox checked="row.item.active"  unchecked-value="false" v-model="row.item.active"></b-form-checkbox>
        </template>
        <template slot="edit" slot-scope="row">
          <a href="#" class="btn btn-info btn-lg">
            <router-link :to="{ name: 'user', params: { id: row.item.id }}" style="color: white" class="glyphicon glyphicon-edit" role="button">Edit</router-link>
          </a>
        </template>
      </b-table>
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
        { key: 'permissions', sortable: true },
        { key: 'email', sortable: true },
        { key: 'active', sortable: true },
        { key: 'edit', sortable: false }
      ],
      filter: null
    };
  },
  created() {
    getAllUsers().then(users => {
      this.users = users;
      console.log(users);
    });
  }
};
</script>

<style scoped>

</style>
