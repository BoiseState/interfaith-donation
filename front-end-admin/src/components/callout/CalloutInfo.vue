<template>
  <div class="jumbotron">
    <div class="container">
      <h2>{{callout.title}}</h2>
      <h3>Add Need</h3>
      <!-- TODO: Add a register need form for a specific callout -->
      <!-- TODO: List out associated needs with a specific callout -->
      <h2>Update Callout Information</h2>
      <form v-on:submit.prevent="onFormSubmit">
        <div class="form-group">
          <label class="control-label col-sm-2">Title:</label>
          <input v-model="callout.title" type="text" width="50" required>
        </div>
        <div class="form-group">
          <label class="control-label col-sm-2">URL: <i>(optional)</i></label>
          <input v-model="callout.url" type="text" width="50">
        </div>
        <div class="form-group">
          <label class="control-label col-sm-2">Body:</label>
          <textarea v-model="callout.body"></textarea>
        </div>
        <div class="form-group">
          <label class="control-label col-sm-4>">Status: </label>
          <input type="checkbox" v-model="callout.active">Active?<br>
        </div>
        <div class="form-group">
          <label class="control-label col-sm-4>">Status: </label>
          <input type="checkbox" v-model="callout.pinned">Pinned?<br>
        </div>
        <br>
        <button type="submit">Update Callout</button>
      </form>
    </div>
  </div>
</template>

<script>
import {getCalloutById, updateCallout} from '../../services/callout-service';

export default {
  name: 'callout-info',
  data () {
    return {
      callout: {
        title: 'Loading...',
        body: '',
        url: '',
        createDate: '',
        updateDate: '',
        active: '',
        pinned: ''
      }
    };
  },
  created () {
    getCalloutById(this.$route.params.id).then(callout => {
      callout.id = this.$route.params.id;
      this.callout = callout;
    });
  },
  methods: {
    onFormSubmit () {
      updateCallout(this.callout);
    }
  }
};
</script>

<style scoped>

</style>
