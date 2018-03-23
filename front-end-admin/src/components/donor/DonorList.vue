<template>
  <div class="jumbotron">
    <div class="container">
      <div>&nbsp;</div>
      <router-link class="btn btn-default" to="/register-donor">Add Donor&raquo;</router-link>
      <!-- TODO: Add form for searching through donors -->
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

      <h3>Donors</h3>
      <b-table outlined hover :fields="fields" :filter="filter" :items="donors">
        <template slot="donations" slot-scope="row">
          <a><b-btn class="glyphicon glyphicon-piggy-bank" style="color: pink" @click.stop="row.toggleDetails"></b-btn></a>
        </template>
        <!--NEW STUFF-->
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
          <router-link :to="{ name: 'user', params: { id: row.item.id }}"  class="glyphicon glyphicon-pencil" style="color: grey; " role="button"></router-link>
        </template>
      </b-table>
    </div>
  </div>
</template>

<script>
import { getAllDonors } from '../../services/donor-service';
import Helper from '../need/NeedList.vue';
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
        { key: 'donations', sortable: false },
        { key: 'edit', sortable: false }
      ],
      filter: null
    };
  },
  created() {
    getAllDonors().then(donors => {
      this.donors = donors;
      this.donors.forEach(donor => {
        donor.formattedDate = Helper.methods.formatDate(donor.joinDate);
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
