<template>
  <div class="jumbotron">
    <div class="container">
      <div>&nbsp;</div>
      <router-link class="btn btn-default" to="/register-donor">Add Donor&raquo;</router-link>
      <!-- TODO: Add form for searching through donors -->
      <div class="form-group">
        <input type="text" v-model="searchTerm" placeholder="Search..." v-on:keyup.enter="searchTitle"/>
        <button v-on:click="searchTitle" class="btn btn-secondary">Search</button>
      </div>
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
        <tr v-for="donor in donors" :key="donor.id">
          <td>{{donor.name}}</td>
          <td>{{donor.email}}</td>
          <td>{{formatDate(donor.joinDate)}}</td>
          <td><router-link :to="{ name: 'donorInfo', params: { id: donor.id }}" class="btn btn-primary" role="button">Edit</router-link></td>
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
      donors: [],
      searchTerm: ''
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
    },
    searchTitle() {
      if (
        this.searchTerm === 'undefined' ||
        this.searchTerm.trim().length < 1
      ) {
        this.newDependent = '';
        return;
      }
      console.log('search for: ' + this.searchTerm);
    }
  }
};
</script>

<style scoped>

</style>
