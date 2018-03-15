<template>
  <div class="jumbotron">
    <div class="container">
      <router-link class="btn btn-default" to="/callout/register">Add Callout&raquo;</router-link>
      <div class="form-group">
        <input type="text" v-model="search" placeholder="Search title.."/>
      </div>
      <h3>Callouts</h3>
      <table class="table">
        <thead>
        <tr>
          <th>Title</th>
          <th>URL</th>
          <th>Last Updated</th>
          <th>Active Status</th>
          <th>Pinned Status</th>
          <th></th>
        </tr>
        </thead>
        <tbody id="calloutTBody">
        <tr v-for="callout in callouts" :key="callout.id">
          <td>{{callout.title}}</td>
          <td><a v-bind:href="callout.url">{{callout.url}}</a></td>
          <td>{{formatDate(callout.updateDate)}}</td>
          <td>{{callout.active}}</td>
          <td>{{callout.pinned}}</td>
          <td><router-link :to="{ name: 'callout', params: { id: callout.calloutId }}" class="btn btn-primary" role="button">Edit</router-link></td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import {getAllCallouts} from '../../services/callout-service';

export default {
  name: 'callout-info',
  data () {
    return {
      callouts: []
    };
  },
  created () {
    getAllCallouts().then(callouts => {
      this.callouts = callouts;
    });
  },
  methods: {
    formatDate: dateString => {
      let date = new Date(dateString);
      return date.toLocaleString();
    }
  }
};
</script>

<style scoped>

</style>
