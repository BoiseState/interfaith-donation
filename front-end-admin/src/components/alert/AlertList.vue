<template>
  <div class="jumbotron">
    <div class="container">
      <router-link class="btn btn-default" to="/alert/register">Add Alert&raquo;</router-link>
      <!-- TODO: Add form for searching through Alerts -->
      <h3>Alerts</h3>
      <table class="table">
        <thead>
        <tr>
          <th>Alert Title</th>
          <th>Alert Description</th>
          <th>Date Created</th>
          <th>Last Requested Date</th>x`
        </tr>
        </thead>
        <tbody id="fullAlertTBody">
        <tr v-for="alert in alerts" :key="alert.id">
          <td>{{alert.alert_title}}</td>
          <td>{{alert.alertBody}}</td>
          <td>{{alert.createDate}}</td>
          <td>{{alert.lastPushedDate}}</td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import {getAllAlerts} from '../../services/alert-service';

export default {
  name: 'alert-list',
  data () {
    return {
      alerts: []
    };
  },
  created () {
    getAllAlerts().then(alerts => {
      console.log(alerts);
      this.alerts = alerts;
    });
  }
};
</script>

<style scoped>

</style>
