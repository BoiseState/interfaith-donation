<template>
  <b-jumbotron>
    <div class="container">
      <b-card>
        <router-link to="/register-donor"><b-button>Add Donor&raquo;</b-button></router-link>
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

        <h3>Donors</h3>
        <b-table outlined hover :fields="fields" :filter="filter" :items="donors">
          <template slot="donations" slot-scope="row">
            <a>
              <b-btn @click.stop="row.toggleDetails"><i class="fas fa-piggy-bank"></i></b-btn>
            </a>
          </template>
          <template slot="row-details" slot-scope="row">
            <b-card>
              <b-row class="mb-2">
                <b-col sm="3" class="text-sm-right"><b>Donations:</b></b-col>
                <b-col>{{row.item.donations.length}}</b-col>
              </b-row>
              <b-button size="sm" @click="row.toggleDetails">Hide Details</b-button>
            </b-card>
          </template>
          <template slot="edit" slot-scope="row">
            <router-link :to="{ name: 'donor', params: { id: row.item.id }}"><b-button><i class="far fa-edit"></i></b-button></router-link>
          </template>
        </b-table>
      </b-card>
    </div>
  </b-jumbotron>
</template>

<script>
import { getAllDonors } from '../../services/donor-service';
import Helper from '../helpers/Helper.vue';
import router from '../../router/index';

export default {
  name: 'donor-list',
  data() {
    return {
      donors: [],
      fields: [
        { key: 'name', sortable: true },
        { key: 'email', sortable: true },
        { key: 'address', sortable: true },
        { key: 'city', sortable: true },
        { key: 'state', sortable: true },
        { key: 'zip', sortable: true },
        { key: 'formattedDate', sortable: true, label: 'Join Date' },
        { key: 'donations', sortable: false, class: 'text-center' },
        { key: 'edit', sortable: false, class: 'text-center' }
      ],
      filter: null
    };
  },
  created() {
    getAllDonors().then(donors => {
      this.donors = donors;
      this.donors.forEach(donor => {
        donor.formattedDate = Helper.methods.formatDate(donor.joinDate);
        // getCalloutNeedByCalloutId(callout.id).then(calloutNeeds => {
        //   console.log(calloutNeeds);
        //   callout.calloutNeeds = calloutNeeds;
        // });
      });
    });
  },
  methods: {
    editDonor(donId) {
      router.push({
        name: 'donorInfo',
        params: { id: Number.parseInt(donId) }
      });
    }
  }
};
</script>

<style scoped>

</style>
