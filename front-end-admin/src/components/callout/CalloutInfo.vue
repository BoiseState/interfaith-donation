<template>
  <div class="jumbotron">
    <div class="container">
      <h2>{{callout.title}}</h2>
      <!-- TODO: List out associated needs with a specific callout -->
      <h2>Update Callout Information</h2>
      <form v-on:submit.prevent="onFormSubmit">
        <div class="form-group">
          <label class="control-label col-sm-2">Title:</label>
          <input v-model="callout.name" type="text" width="50" required>
        </div>
        <div class="form-group">
          <label class="control-label col-sm-2">Description:</label>
          <textarea rows="4" cols="50" v-model="callout.descriptionMessage"></textarea>
        </div>
        <div class="form-group">
          <label class="control-label col-sm-4>">Status: </label>
          <input type="checkbox" v-model="callout.active">Active?<br>
        </div>
        <table class="calloutNeedTable">
          <thead>
          <tr>
            <th>Name</th>
            <th>Quantity</th>
            <th>Active</th>
            <th></th>
          </tr>
          </thead>
          <tbody id="calloutNeedTBody">
          <tr v-for="calloutNeed in calloutNeeds" :key="calloutNeed.id">
            <td>{{calloutNeed.need.name}}</td>
            <td><input type="text" v-model="calloutNeed.quantity"></td>
            <td><input type="checkbox" v-model="calloutNeed.active"><br></td>
          </tr>
          </tbody>
        </table>
        <button v-on:click="addNeed()" type="button">Add New Need</button>
        <br>
        <br>
        <br>
        <button type="submit">Update Callout</button>
      </form>
    </div>
  </div>
</template>

<script>
import { getCalloutById, updateCallout } from '../../services/callout-service';

export default {
  name: 'callout-info',
  data() {
    return {
      callout: {
        title: 'Loading...',
        body: '',
        url: '',
        createDate: '',
        updateDate: '',
        active: '',
        pinned: ''
      },
      calloutNeeds: []
    };
  },
  created() {
    getCalloutById(this.$route.params.id).then(callout => {
      callout.id = this.$route.params.id;
      this.callout = callout;
      this.calloutNeeds = callout.calloutNeeds;
    });
  },
  methods: {
    onFormSubmit() {
      updateCallout(this.callout);
    },
    addNeed() {
      window.open('https://www.w3schools.com');
    }
  }
};
</script>

<style scoped>
table td {
  padding: 0px 10px 0px 10px; /* top right bottom left */
}
table th {
  padding: 0px 10px 0px 10px; /* top right bottom left */
}
</style>
