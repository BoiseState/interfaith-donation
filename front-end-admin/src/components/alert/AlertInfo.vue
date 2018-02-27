<template>
  <div class="jumbotron">
    <div class="container">
      <h2>{{alert.title}}</h2>
      <h3>Add Need</h3>
      <!-- TODO: Add a register callout form for a specific alert -->
      <!-- TODO: List out associated needs with a specific callout -->
      <h2>Update Alert Information</h2>
      <form v-on:submit.prevent="onFormSubmit">
        <div class="form-group">
          <label class="control-label col-sm-2">Title:</label>
          <input v-model="alert.title" type="text" width="50" required>
        </div>
        <div class="form-group">
          <label class="control-label col-sm-2">Body:</label>
          <textarea v-model="alert.body"></textarea>
        </div>
        <div class="form-group">
          <label class="control-label col-sm-4>">Push Date: </label>
          <input type="date" v-model="alert.pushDate">Active?<br>
        </div>
        <div class="form-group">
          <label class="control-label col-sm-4>">Created Date: </label>
          <input type="date" v-model="alert.createDate">Pinned?<br>
        </div>
        <br>
        <button type="submit">Update Alert</button>
      </form>
    </div>
  </div>
</template>

<script>
import {getAlertById, updateAlert} from '../../services/alert-service';

export default {
  name: 'alert-info',
  data () {
    return {
      alert: {
        title: 'Loading...',
        body: '',
        createDate: '',
        lastPushed: ''
        // calloutId: '',
        // needId: ''
      }
    };
  },
  created () {
    getAlertById(this.$route.params.id).then(alert => {
      alert.id = this.$route.params.id;
      this.alert = alert;
    });
  },
  methods: {
    onFormSubmit () {
      updateAlert(this.alert);
    }
  }
};
</script>

<style scoped>

</style>
