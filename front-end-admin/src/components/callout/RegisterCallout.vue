<template>
  <div class="jumbotron">
    <div class="container">
      <h2>Register Callout</h2>
      <form v-on:submit.prevent="onFormSubmit" class="form-horizontal" id ="createCalloutForm">
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
          <textarea v-model="callout.body" rows="4" cols="50"></textarea>
        </div>
        <div class="form-group">
          <label id = "callout-active-label" class="control-label col-sm-2>">Status: </label>
          <input type="checkbox" v-model="callout.active">Active?<br>
        </div>
        <div class="form-group">
          <label id = "callout-pinned-label" class="control-label col-sm-2>">Status: </label>
          <input type="checkbox" v-model="callout.pinned">Pinned?<br>
        </div>
        <button type="submit">Create Callout</button>
      </form>
    </div>
  </div>
</template>

<script>
import { createCallout } from '../../services/callout-service';

export default {
  name: 'register-callout',
  data() {
    return {
      callout: {}
    };
  },
  methods: {
    onFormSubmit() {
      this.callout.createDate = new Date();
      this.callout.updateDate = new Date();
      createCallout(this.callout);
    }
  }
};
</script>

<style scoped>

</style>
