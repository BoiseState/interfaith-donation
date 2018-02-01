<template>
  <div class="jumbotron">
    <div class="container">
      <h3>Donors</h3>
      <table class="table">
        <thead>
        <tr>
          <th>Donor Name</th>
          <th>Email</th>
          <th>Display Name</th>
          <th>Joined On</th>
        </tr>
        </thead>
        <tbody id="fullDonorTBody">
        <tr v-for="donor in donors" :key="donor.userId">
          <td>{{donor.name}}</td>
          <td>{{donor.email}}</td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import {getAllDonors} from '../../services/donors-service';

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
