<template>
  <div style="max-height: 600px; overflow-y: scroll;">
    <div class="container">
      <div>&nbsp;</div>
      <!-- <p><a class="btn btn-default" href="${pageContext.request.contextPath}/registerneed.jsp" role="button">Add Need&raquo;</a></p> -->
      <router-link class="btn btn-default" to="/register-need">Add Need&raquo;</router-link>
      <b-row>
        <b-col md="6" class="my-1">
          <b-form-group horizontal label="Filter" class="mb-0">
            <b-input-group>
              <b-form-input v-model="filter" placeholder="Type to Search" />
              <b-input-group-append>
                <b-btn :disabled="!filter" @click="filter = ''">Clear</b-btn>
              </b-input-group-append>
            </b-input-group>
          </b-form-group>
        </b-col>
      </b-row>

      <h3>Needs</h3>
      <b-table outlined hover :fields="fields" :filter="filter" :items="needs">
        <template slot="url" slot-scope="row">
          <a><b-btn class="glyphicon glyphicon-search" style="color: white" v-on:click="openUrl(row.item.url)"></b-btn></a>
        </template>
        <template slot="add" slot-scope="row">
          <b-form-checkbox v-model="row.item.added" @change="updateNeeds(row.item)"></b-form-checkbox>
        </template>
      </b-table>
    </div>
  </div>
</template>

<script>
import { getAllNeeds } from '../../services/need-service';
import Helper from '../helpers/Helper.vue';

export default {
  name: 'need-list',
  data() {
    return {
      needs: [],
      fields: [
        { key: 'name', sortable: true },
        { key: 'url', sortable: false },
        { key: 'description', sortable: true },
        { key: 'unitOfMeasurement', sortable: true },
        { key: 'formattedDate', sortable: true, label: 'Created Date' },
        { key: 'add', sortable: false }
      ],
      filter: null,
      added: []
    };
  },
  created() {
    getAllNeeds().then(needs => {
      this.needs = needs;
      this.needs.splice(10);
      this.needs.forEach(need => {
        need.formattedDate = Helper.methods.formatDate(need.createdDate);
        need.added = false;
      });
    });
  },
  methods: {
    updateNeeds(need) {
      if (this.added.includes(need)) {
        this.added.splice(need);
      } else {
        this.added.push(need);
      }
    }
  }
};
</script>

<style scoped>

</style>
