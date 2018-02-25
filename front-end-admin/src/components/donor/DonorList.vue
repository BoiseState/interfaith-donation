<template>
  <div class="jumbotron">
    <div class="container">
      <router-link class="btn btn-default" to="/donor/register">Add Donor&raquo;</router-link>
      <!-- TODO: Add form for searching through donors -->
      <h3>Donors</h3>
      <table class="table">
        <thead>
        <tr>
          <th>Donor Name</th>
          <th>Email</th>
          <th>Joined On</th>
        </tr>
        </thead>
        <tbody id="fullDonorTBody">
        <tr v-for="donor in donors" :key="donor.donorId">
          <td>{{donor.name}}</td>
          <td>{{donor.email}}</td>
          <td>{{donor.joinDate}}</td>
          <td><router-link class="btn btn-default" :to="{ path: '/donor/id:', params: { id: donor.donorId } }">Edit Donor</router-link></td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import {getAllDonors} from '../../services/donor-service';

export default {
  name: 'donor-list',
  data () {
    return {
      donors: []
    };
  },
  created () {
    getAllDonors().then(donors => {
      this.donors = donors;
    });
  }
};
</script>

<style scoped>

</style>
