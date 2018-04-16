<template>
  <b-jumbotron>
    <div class="container">
      <b-card title="Create New Callout">
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
              <b-table outlined hover :fields="fields" :items="calloutNeeds">
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
                <template slot="quantity" slot-scope="row">
                  <b-form-input v-model="row.item.quantity"
                                required
                                placeholder="Enter the quantity you need"
                                name="quantity">
                  </b-form-input>
                </template>
                <template slot="progress" slot-scope="row">
                  <div>
                    <b-progress :value="row.item.donationSum" :max="guaranteeNumber(row.item.quantity)" show-value
                                class="mb-3"></b-progress>
                  </div>
                </template>
                <template slot="edit" slot-scope="row">
                  <!--<router-link :to="{ name: 'need', params: { id: row.item.need.id }}"><b-button><i class="far fa-edit"></i></b-button></router-link>-->
                </template>
              </b-table>
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
import { createCallout } from '../../services/callout-service';
import { createCalloutNeed } from '../../services/calloutneed-service';
import { getAllNeeds } from '../../services/need-service';
import Helper from '../helpers/Helper.vue';
import Moment from 'moment';

export default {
  name: 'callout-info',
  data() {
    return {
      callout: {
        name: '',
        descriptionMessage: '',
        url: '',
        createDate: Moment.now(),
        endDate: '',
        active: true
      },
      fields: [
        { key: 'name', sortable: true },
        { key: 'url', sortable: false },
        { key: 'description', sortable: true },
        { key: 'unitOfMeasurement', sortable: true },
        { key: 'quantity', sortable: true },
        { key: 'progress', sortable: false },
        { key: 'edit', sortable: false }
      ],
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
  created() {
    getAllNeeds().then(needs => {
      this.needs = needs;
      this.needs.forEach(need => {
        need.formattedDate = Helper.methods.formatDate(need.createdDate);
        need.added = false;
      });
    });
  },
  methods: {
    onFormSubmit(evt) {
      evt.preventDefault();
      console.log(this.callout);
      this.calloutNeeds.forEach(calloutNeed => {
        createCalloutNeed(calloutNeed);
      });
      createCallout(this.callout);
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
      console.log(this.calloutNeeds);
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
    },
    guaranteeNumber(quantity) {
      if (quantity > 0) {
        return 0;
      }
      return quantity;
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
