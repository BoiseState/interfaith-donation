<template>
  <!-- <div class="needs"> -->
    <div class="jumbotron">
      <div class="container">
        <div>&nbsp;</div>
        <!-- <p><a class="btn btn-default" href="${pageContext.request.contextPath}/registerneed.jsp" role="button">Add Need&raquo;</a></p> -->
        <router-link class="btn btn-default" to="/register-need">Add Need&raquo;</router-link>
        <div class="form-group">
          <input type="text" v-model="searchTerm" placeholder="Search..." v-on:keyup.enter="searchTitle"/>
          <button v-on:click="searchTitle" class="btn btn-secondary">Search</button>
        </div>
        <br>
        <h3>Needs</h3>
        <table class="table">
          <thead>
            <tr>
              <th>Need</th>
              <th>Description</th>
              <th>Unit of Measure</th>
              <!-- <th>URL</th> -->
              <!-- <th>Created Date</th> -->
            </tr>
          </thead>
          <tbody id ="fullNeedTBody">
            <tr v-for="need in needs" :key="need.id">
              <td>{{need.name}}</td>
              <td>{{need.description}}</td>
              <td>{{need.unitOfMeasurement}}</td>
              <!-- <td>{{need.url}}</td> -->
              <!-- <td>{{need.createdDate}}</td> -->
              <td><router-link :to="{ name: 'need information', params: { id: need.id }}" class="btn btn-primary" role="button">edit</router-link></td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  <!-- </div> -->
</template>

<script>
import { getAllNeeds } from '../../services/need-service';

import router from '../../router/index';

export default {
  name: 'need-list',
  data() {
    return {
      needs: [],
      searchTerm: ''
    };
  },
  created() {
    getAllNeeds().then(needs => {
      this.needs = needs;
    });
  },
  methods: {
    editNeed(NeedId) {
      router.push({
        name: 'NeedInfo',
        params: { id: Number.parseInt(NeedId) }
      });
    },
    formatDate(dateString) {
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
