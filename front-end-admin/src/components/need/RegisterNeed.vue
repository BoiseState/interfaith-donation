<template>
  <div class="addneed">
    <div class="jumbotron">
      <div class="container">
        <h2>Register Need</h2>
        <!-- <form class="form-horizontal" action="/createneed" method="POST"> -->
        <!-- <form class="form-horizontal" action="createNeeds" method="POST"> -->
          <form v-on:submit.prevent="onFormSubmit" class="form-horizontal">
          <!-- <td><router-link :to="{ name: 'need information', params: { id: need.id }}" class="btn btn-primary" role="button">edit</router-link></td> -->
          <div class="form-group">
            <label class="control-label col-sm-2">Need Name:</label>
            <!-- <input name="need_name" type="text" width="50"> -->
            <input v-model="need.name" name="name" type="text" width="50" required>
          </div>
          <!-- <div class="form-group">
            <label class="control-label col-sm-2">Quantity:</label>
            <input id="need_quantity" name="need_quantity" type="number" min="1" step="1" value ="1"/>
          </div> -->
          <div class="form-group">
            <label class="control-label col-sm-2">Unit Type: <i>(optional)</i></label>
            <input v-model="need.unitOfMeasurement" type="text" width="50">
          </div>
          <div class="form-group">
            <label class="control-label col-sm-2">Need URL: <i>(optional)</i></label>
            <input v-model="need.url" type="text" width="50">
          </div>
          <div class="form-group">
            <label class="control-label col-sm-2">Need Description: </label>
            <input v-model="need.description" type="text" width="50">
          </div>
          <!-- <div class="form-group">
            <label class="control-label col-sm-2>">Associated Callout (optional)</label>
            <select name="callout_id">
              <option value="{{callout.callout_id}}">{{ callout.callout_title }} - {{callout.update_date}}</option>
            </select>
            </div> -->
          <!-- <div class="form-group">
            <label class="control-label col-sm-2>">Status: </label>
            <input type="checkbox" name="active" value="active">Active?<br></div>
          <br> -->
          <button type="submit">Create Need</button>
        </form>
        <br>
      </div>
    </div>
  </div>
</template>

<script>
import { createNeed } from '../../services/need-service';

export default {
  name: 'register-need',
  data() {
    return {
      need: {
        id: '',
        name: '',
        url: '',
        description: '',
        unitOfMeasurement: ''
      },
      errors: []
    };
  },
  methods: {
    onFormSubmit() {
      createNeed(this.need);
    }
  }
};
</script>

<style scoped>

</style>
