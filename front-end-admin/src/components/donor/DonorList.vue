<template>
  <div class="jumbotron">
    <div class="container">
      <div>&nbsp;</div>
      <router-link class="btn btn-default" to="/register-donor">Add Donor&raquo;</router-link>
      <!-- TODO: Add form for searching through donors -->
      <h3>Donors</h3>
      <table class="table">
        <thead>
        <tr>
          <th>Donor Name</th>
          <th>Email</th>
          <th>Joined On</th>
          <th>JSON</th>
        </tr>
        </thead>
        <tbody id="fullDonorTBody">
        <tr v-for="donor in donors" :key="donor.id">
          <td>{{donor.name}}</td>
          <td>{{donor.email}}</td>
          <td>{{formatDate(donor.joinDate)}}</td>
          <td>{{donor}}</td>
           <td><router-link class="btn btn-default" :to="{ path: '/donor/:id', params: { id: donor.donorId } }">Edit Donor</router-link></td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import { getAllDonors } from '../../services/donor-service';

import router from '../../router/index';

export default {
  name: 'donor-list',
  data() {
    return {
      donors: []
    };
  },
  created() {
    getAllDonors().then(donors => {
      this.donors = donors;
    });
  },
  methods: {
    editDonor(donId) {
      router.push({
        name: 'donorInfo',
        params: { id: Number.parseInt(donId) }
      });
    },
    formatDate: dateString => {
      let date = new Date(dateString);
      return date.toLocaleDateString();
    }
  }
};
</script>

<style scoped>

</style>
