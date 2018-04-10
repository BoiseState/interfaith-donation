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
            <div style="width: 200px" class="input-group">
              <b-form-input v-model="callout.endDate"
                            placeholder="Enter EndDate.."
                            name="endDate">
              </b-form-input>
            </div>
            <b-dropdown><i class="fas fa-calendar-alt"></i>
              <b-dropdown-header><i class="fas fa-calendar-alt"></i></b-dropdown-header>
              <li>
                <date-picker v-model="callout.endDate"/>
              </li>
            </b-dropdown>
            <br>
          </b-card>
          <b-card>
            <div v-if="calloutNeeds.length > 0">
              <h3>Needs</h3>
            </div>
            <div>
              <b-btn v-b-modal.modal>Add Need</b-btn>
            </div>
            <div>
              <!-- Modal Component -->
              <b-modal id="modal" size="lg" ref="modal" ok-variant="success" @ok="handleOk" centered title="Add Needs">
                <template>
                  <div style="max-height: 500px; overflow-y: scroll;">
                    <div class="container">
                      <div>&nbsp;</div>
                      <router-link to="/register-need">
                        <b-button>Create New Need&raquo;</b-button>
                      </router-link>
                      <b-row>
                        <b-col md="6" class="my-1">
                          <b-input-group>
                            <b-form-input v-model="needFilter" placeholder="Type to Search"/>
                            <b-input-group-append>
                              <b-btn :disabled="!needFilter" @click="Filter = ''">Clear</b-btn>
                            </b-input-group-append>
                          </b-input-group>
                        </b-col>
                      </b-row>

                      <h3>Needs</h3>
                      <b-table outlined hover :fields="needFields" :filter="needFilter" :items="needs">
                        <template slot="url" slot-scope="row">
                          <a>
                            <b-btn v-on:click="openUrl(row.item.url)"><i class="fab fa-amazon"></i></b-btn>
                          </a>
                        </template>
                        <template slot="add" slot-scope="row">
                          <b-form-checkbox v-model="row.item.added" @change="updateNeeds(row.item)"></b-form-checkbox>
                        </template>
                      </b-table>
                    </div>
                  </div>
                </template>
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
import { updateCallout } from '../../services/callout-service';
import { updateCalloutNeed } from '../../services/calloutneed-service';
import Moment from 'moment';

export default {
  name: 'callout-info',
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
      show: true,
      date: '',
      needs: [],
      needFields: [
        { key: 'name', sortable: true },
        { key: 'url', sortable: false, class: 'text-center' },
        { key: 'description', sortable: true },
        { key: 'unitOfMeasurement', sortable: true },
        { key: 'formattedDate', sortable: true, label: 'Created Date' },
        { key: 'add', sortable: false, class: 'text-center' }
      ],
      needFilter: null,
      added: []
    };
  },
  methods: {
    onFormSubmit(evt) {
      evt.preventDefault();
      this.calloutNeeds.forEach(calloutNeed => {
        updateCalloutNeed(calloutNeed);
      });
      updateCallout(this.callout);
    },
    handleOk(bvEvt) {
      // Prevent modal from closing
      bvEvt.preventDefault();
      this.handleSubmit();
    },
    handleSubmit() {
      this.added.forEach(need => {
        this.calloutNeeds.push(this.needToCalloutNeed(need));
      });
      this.clearCalloutNeed();
      this.$refs.modal.hide();
    },
    clearCalloutNeed() {
      this.added = [];
    },
    dateToday() {
      return Moment.moment();
    },
    updateNeeds(needId) {
      if (this.added.includes(needId)) {
        this.added.splice(needId);
      } else {
        this.added.push(needId);
      }
    },
    needToCalloutNeed(need) {
      console.log(need);
      var calloutNeed = {};
      calloutNeed.quantity = 0;
      calloutNeed.need = need;
      return calloutNeed;
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
