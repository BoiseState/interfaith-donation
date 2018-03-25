<template>
  <div class="needs">
    <div class="jumbotron">
      <div class="container">
        <b-card>
          <router-link class="btn btn-default, greyButton" to="/register-need">Add Need&raquo;</router-link>
          <b-row>
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
              <a>
                <b-btn class="glyphicon glyphicon-search" style="color: white"
                       v-on:click="openUrl(row.item.url)"></b-btn>
              </a>
            </template>
            <template slot="edit" slot-scope="row">
              <router-link :to="{ name: 'need', params: { id: row.item.id }}" class="glyphicon glyphicon-pencil"
                           style="color: grey; " role="button"></router-link>
            </template>
          </b-table>
        </b-card>
      </div>
    </div>
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
  created() {
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
      window.open(url);
    }
  }
};
</script>

<style scoped>

</style>
