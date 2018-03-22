<template>
  <div style="max-height: 600px; overflow-y: scroll;">
    <div class="needs">
      <div class="jumbotron">
        <div class="container">
          <form class="form-horizontal" action="/searchneed" method="GET">
          </form>
          <br>
          <h3>Needs</h3>
          <div class="form-group">
            <label class="control-label col-sm-2">Search:</label>
            <input name="searchterm" type="text" width="50">
            <button type="submit">Search</button>
          </div>
          <table class="table">
            <thead>
            <tr>
              <th>Need</th>
              <!--<th>Description</th>-->
              <th>Unit of Measure</th>
            </tr>
            </thead>
            <tbody id="fullNeedTBody">
            <tr v-for="need in needs" :key="need.id">
              <td>{{need.name}}</td>
              <!--<td>{{need.description}}</td>-->
              <td>{{need.unitOfMeasurement}}</td>
              <td>
              <td>
                <b-button variant="primary" v-on:click="closeWindow(need)">select</b-button>
              </td>
            </tr>
            </tbody>
          </table>
          <router-link class="btn btn-secondary" to="/register-need">Create New Need&raquo;</router-link>
          <td>
            <b-button variant="primary">Next</b-button>
          </td>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { getAllNeeds } from '../../services/need-service';

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
      this.needs.splice(10);
    });
  },
  methods: {
    closeWindow(need) {
      console.log(need);
      window.opener.addNeed(need);
      window.close();
    }
  }
};
</script>

<style scoped>

</style>
