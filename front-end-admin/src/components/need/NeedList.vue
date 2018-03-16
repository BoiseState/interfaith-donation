<template>
  <div class="jumbotron">
    <div class="container">
      <router-link class="btn btn-default" to="/register-need">Add Needs&raquo;</router-link>
      <!-- TODO: Add form for searching through needs -->
      <h3>Needs</h3>
      <table class="table">
        <thead>
        <tr>
          <th>Need Name</th>
          <th>Amazon Link</th>
          <th>Description</th>
          <th>Units</th>
        </tr>
        </thead>
        <tbody id="fullNeedTBody">
        <tr v-for="need in needs" :key="need.id">
          <td>{{need.name}}</td>
          <td>{{need.url}}</td>
          <td>{{need.description}}</td>
          <td>{{need.unitOfMeasurement}}</td>
          <!-- <td><router-link class="btn btn-default" :to="{ path: '/donor/:id', params: { id: donor.donorId } }">Edit Donor</router-link></td> -->
          <td><router-link :to="{ name: 'needInfo', params: { id: need.id }}">edit</router-link></td>
          <!-- <td><button v-on:click="editDonor(donor.donorId)">test</button></td> -->
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import { getAllNeeds } from '../../services/need-service';

import router from '../../router/index';

export default {
  name: 'need-list',
  data() {
    return {
      needs: []
    };
  },
  created() {
    getAllNeeds().then(needs => {
      this.needs = needs;
    });
  },
  methods: {
    editNeed(needId) {
      router.push({
        name: 'needInfo',
        params: { id: Number.parseInt(needId) }
      });
    }
  }
};
</script>

<style scoped>

</style>
