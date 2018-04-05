<template>
  <div class="jumbotron">
    <div class="container">
      <br>
      <br>
      <b-card title="Edit Callout">
        <b-form @submit.prevent="onFormSubmit" class="form-horizontal">

          <b-card :title="callout.name">
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
                  <btn class="dropdown-toggle"><i class="glyphicon glyphicon-calendar"></i></btn>
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
                  <a>
                    <b-btn class="glyphicon glyphicon-search" style="color: white"
                           v-on:click="openUrl(row.item.need.url)"></b-btn>
                  </a>
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
                  <router-link :to="{ name: 'need', params: { id: row.item.need.id }}"
                               class="glyphicon glyphicon-pencil" style="color: grey; " role="button"></router-link>
                </template>
              </b-table>
            </div>
            <div>
              <b-btn v-b-modal.modal>Add Need</b-btn>
            </div>
            <div>
              <!-- Modal Component -->
              <b-modal id="modal" size="lg" @ok="handleOk" centered title="Bootstrap-Vue">
                <NeedSelect></NeedSelect>
              </b-modal>
            </div>
          </b-card>
          <br>
          <b-button type="submit" variant="success">Submit</b-button>
        </b-form>

      </b-card>
    </div>
  </div>
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
    onFormSubmit() {
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
