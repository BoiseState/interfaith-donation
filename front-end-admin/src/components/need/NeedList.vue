<template>
  <div class="container">
    <b-card>
      <router-link to="/register-need"><b-button>Add Need &raquo;</b-button></router-link>
      <b-row class="needs-searchbar">
        <b-col md="6" class="my-1">
          <b-input-group>
            <b-form-input v-model="filter" placeholder="Type to Search"/>
            <b-input-group-append>
              <b-btn :disabled="!filter" @click="filter = ''">Clear</b-btn>
            </b-input-group-append>
          </b-input-group>
        </b-col>
      </b-row>
      <h3>Needs</h3>
      <b-table outlined hover :fields="fields" :filter="filter" :items="needs">
        <template slot="url" slot-scope="row">
          <div v-if="row.item.url">
            <div v-on:click="openUrl(row.item.url)">
              <b-button><i class="fab fa-amazon"></i></b-button>
            </div>
          </div>
        </template>
        <template slot="edit" slot-scope="row">
          <router-link :to="{ name: 'need', params: { id: row.item.id }}"><b-button><i class="far fa-edit"></i></b-button></router-link>
        </template>
      </b-table>
    </b-card>
  </div>
</template>

<script>
import { getAllNeeds } from '../../services/need-service';
import Helper from '../helpers/Helper.vue';
import router from '../../router/index';

export default {
  name: 'need-list',
  data() {
    return {
      needs: [],
      fields: [
        { key: 'name', sortable: true },
        { key: 'url', sortable: false, class: 'text-center' },
        { key: 'description', sortable: true },
        { key: 'unitOfMeasurement', sortable: true },
        { key: 'formattedDate', sortable: true, label: 'Created Date' },
        { key: 'edit', sortable: false, class: 'text-center' }
      ],
      filter: null
    };
  },
  mounted() {
    getAllNeeds().then(needs => {
      this.needs = needs;
      this.needs.forEach(need => {
        need.formattedDate = Helper.methods.formatDate(need.createdDate);
      });
    });
  },
  methods: {
    editNeed(NeedId) {
      router.push({
        name: 'NeedInfo',
        params: { id: Number.parseInt(NeedId) }
      });
    },
    openUrl(url) {
      console.log(url);
      window.open(url);
    }
  }
};
</script>

<style scoped>
.needs-searchbar {
  margin-bottom: 20px;
}
</style>
