<template>
  <div class="jumbotron">
    <div class="container">
      <b-card>
        <router-link to="/callout/register">
          <b-button>Add Callout&raquo;</b-button>
        </router-link>
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

        <h3>Callouts</h3>
        <b-table outlined hover :fields="fields" :filter="filter" :items="callouts">
          <template slot="active" slot-scope="row">
            <template v-if="row.item.active">
              <a><i class="far fa-check-circle"></i></a>
            </template>
          </template>
          <template slot="calloutNeeds" slot-scope="row">
            <a>
              <b-btn @click.stop="row.toggleDetails"><i class="fas fa-list-alt"></i></b-btn>
            </a>
          </template>
          <template slot="row-details" slot-scope="row">
            <b-card v-for="calloutNeed in row.item.calloutNeeds" :key="calloutNeed.id">
              <b-row class="mb-2">
                <b-col sm="3" class="text-sm-right"><b>Name:</b></b-col>
                <b-col>{{calloutNeed.need.name}}</b-col>
              </b-row>
              <b-row class="mb-2">
                <b-col sm="3" class="text-sm-right"><b>Description:</b></b-col>
                <b-col>{{calloutNeed.need.description}}</b-col>
              </b-row>
              <b-row class="mb-2">
                <b-col sm="3" class="text-sm-right"><b>Quantity:</b></b-col>
                <b-col>{{calloutNeed.quantity}}</b-col>
              </b-row>
              <b-button size="sm" @click="row.toggleDetails">Hide Details</b-button>
            </b-card>
          </template>
          <template slot="edit" slot-scope="row">
            <router-link :to="{ name: 'callout', params: { id: row.item.id }}"><b-button><i class="far fa-edit"></i></b-button></router-link>
          </template>
        </b-table>
      </b-card>
    </div>
  </div>
</template>

<script>
import { getAllCallouts } from '../../services/callout-service';
import router from '../../router/index';
import Helper from '../helpers/Helper.vue';

export default {
  name: 'callout-info',
  data() {
    return {
      callouts: [],
      fields: [
        { key: 'name', sortable: true },
        { key: 'descriptionMessage', sortable: true },
        { key: 'active', sortable: true, class: 'text-center' },
        { key: 'formattedCreatedDate', sortable: true, label: 'Created' },
        { key: 'formattedEndDate', sortable: true, label: 'Ends' },
        {
          key: 'calloutNeeds',
          sortable: false,
          label: 'Needs',
          class: 'text-center'
        },
        { key: 'edit', sortable: false, class: 'text-center' }
      ],
      filter: null
    };
  },
  created() {
    getAllCallouts().then(callouts => {
      this.callouts = callouts;
      this.callouts.forEach(callout => {
        callout.formattedCreatedDate = Helper.methods.formatDate(
          callout.createdDate
        );
        callout.formattedEndDate = Helper.methods.formatDate(
          callout.effectiveDate
        );
      });
    });
  },
  methods: {
    editNeed(NeedId) {
      router.push({
        name: 'NeedInfo',
        params: { id: Number.parseInt(NeedId) }
      });
    }
  }
};
</script>

<style scoped>

</style>
