<template>
  <b-jumbotron>
    <div class="container">
      <b-card title="Edit Callout">
        <b-form @submit="onFormSubmit" class="form-horizontal">

          <b-card>
            <input type="hidden" name="callout_id" v-model="callout.id">
            <h5>Callout Name: </h5>
            <b-form-input v-model="callout.name"
                          required
                          placeholder="Enter name.."
                          name="name">
            </b-form-input>
            <h5>Description: </h5>
            <b-form-textarea v-model="callout.descriptionMessage"
                             required
                             placeholder="Enter description.."
                             :rows="3"
                             name="Amazon URL"
                             :max-rows="3">
            </b-form-textarea>
            <h5>Set End Date: </h5>
            <dropdown>
              <div style="width: 300px" class="input-group">
                <b-form-input v-model="callout.endDate"
                              placeholder="Enter EndDate.."
                              name="endDate">
                </b-form-input>
                <div class="input-group-btn">
                  <b-button class="dropdown-toggle"><i class="glyphicon glyphicon-calendar"></i></b-button>
                </div>
              </div>
              <template slot="dropdown">
                <li>
                  <date-picker v-model="callout.endDate"/>
                </li>
              </template>
            </dropdown>
            <br>
          </b-card>
          <b-card>
            <div v-if="calloutNeeds.length > 0">
              <h3>Needs</h3>
              <b-table outlined hover :fields="fields" :filter="filter" :items="callout.calloutNeeds">
                <template slot="name" slot-scope="row">
                  {{row.item.need.name}}
                </template>
                <template slot="url" slot-scope="row">
                  <div v-if="row.item.need.url">
                    <div v-on:click="openUrl(row.item.url)">
                      <b-button><i class="fab fa-amazon"></i></b-button>
                    </div>
                  </div>
                </template>
                <template slot="description" slot-scope="row">
                  {{row.item.need.description}}
                </template>
                <template slot="unitOfMeasurement" slot-scope="row">
                  {{row.item.need.unitOfMeasurement}}
                </template>
                <template slot="progress" slot-scope="row">
                  <div>
                    <b-progress :value="row.item.donationSum" :max="row.item.quantity" show-value
                                class="mb-3"></b-progress>
                  </div>
                </template>
                <template slot="edit" slot-scope="row">
                  <router-link :to="{ name: 'need', params: { id: row.item.need.id }}"><b-button><i class="far fa-edit"></i></b-button></router-link>
                </template>
              </b-table>
            </div>
            <div>
              <b-btn v-b-modal.modal>Add Need</b-btn>
            </div>
            <div>
              <!-- Modal Component -->
              <b-modal id="modal" size="lg" ok-variant="success" @ok="handleOk" centered title="Add Needs">
                <NeedSelect></NeedSelect>
              </b-modal>
            </div>
          </b-card>
          <br>
          <b-button type="submit" variant="success">Submit</b-button>
        </b-form>

      </b-card>
    </div>
  </b-jumbotron>
</template>

<script>
import { getCalloutById, updateCallout } from '../../services/callout-service';
import { updateCalloutNeed } from '../../services/calloutneed-service';
import NeedSelect from '../need/NeedSelect';
import Moment from 'moment';

export default {
  name: 'callout-info',
  components: {
    NeedSelect
  },
  data() {
    return {
      callout: {
        title: 'Loading...',
        body: '',
        url: '',
        createDate: '',
        endDate: '',
        active: '',
        pinned: ''
      },
      calloutNeeds: [],
      fields: [
        { key: 'name', sortable: true },
        { key: 'url', sortable: false },
        { key: 'description', sortable: true },
        { key: 'unitOfMeasurement', sortable: true },
        { key: 'quantity', sortable: true },
        { key: 'progress', sortable: false },
        { key: 'edit', sortable: false }
      ],
      filter: null,
      show: true,
      date: ''
    };
  },
  created() {
    getCalloutById(this.$route.params.id).then(callout => {
      callout.id = this.$route.params.id;
      this.callout = callout;
      this.calloutNeeds = callout.calloutNeeds;

      this.callout.calloutNeeds.forEach(calloutNeed => {
        calloutNeed.donationSum = 0;
        calloutNeed.donations.forEach(donation => {
          calloutNeed.donationSum += donation.quantity;
        });
      });
    });
  },
  methods: {
    onFormSubmit(evt) {
      evt.preventDefault();
      this.callout.calloutNeeds.forEach(calloutNeed => {
        updateCalloutNeed(calloutNeed);
      });
      updateCallout(this.callout);
    },
    handleOk(bvEvt) {
      // Prevent modal from closing
      bvEvt.preventDefault();
      if (!this.name) {
        alert('Please enter your name');
      } else {
        this.handleSubmit();
      }
    },
    handleSubmit() {
      this.calloutNeeds.push(this.newCalloutNeed);
      this.clearCalloutNeed();
    },
    clearCalloutNeed() {
      this.newCalloutNeed = {};
    },
    dateToday() {
      return Moment.moment();
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
