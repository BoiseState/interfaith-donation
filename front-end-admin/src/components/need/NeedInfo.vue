<template>
  <div class="needInfoPage">
    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
       <div class="container">
        <h2>Need Info Page for {{ need.name }}</h2>
        <form class="form-horizontal" action="/updateneed" method="POST" id="needform">
          <button type="submit">Update Need</button>
          <input type="hidden" name="need_id" v-model="need.id">
          <div class="form-group">
            <label class="control-label col-sm-2">Full Name:</label>
            <input name="need_name" type="text" width="100" v-model="need.name">
          </div>
          <div class="form-group">
            <label class="control-label col-sm-2">Description:</label>
            <textarea rows="4" cols="50" v-model="need.description" form="needform">need_description</textarea>
          </div>
          <div class="form-group">
            <label class="control-label col-sm-2">Need URL:</label>
            <input name="need_url" type="text" width="50" v-model="need.url">
          </div>
          <!-- <div class="form-group">
            <label class="control-label col-sm-2">Quantity:</label>
            <input id="need_quantity" name="need_quantity" type="number" min="1" step="1" v-model="need_quantity"/>
          </div> -->
          <div class="form-group">
            <label class="control-label col-sm-2">Units:</label>
            <input name="need_unit" type="text" width="50" v-model="need.unit">
          </div>
          <!-- <div class="form-group">
            <label class="control-label col-sm-4>">Status: </label>
            <input type="checkbox" name="active" checked="{{active}}">Active?
          </div> -->
            <!-- <button type="submit">Update Need</button> -->
          <!-- </div> -->
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import { getNeedById, updateNeed } from '../../services/need-service';

export default {
  name: 'need-info',
  data() {
    return {
      need: {
        id: '',
        name: 'Loading...',
        unitOfMeasurement: '',
        description: '',
        url: ''
      }
    };
  },
  created() {
    getNeedById(this.$route.params.id).then(need => {
      this.need = need;
      console.log(need);
    });
  },
  methods: {
    onFormSubmit() {
      updateNeed(this.need);
    }
  }
};
</script>

<style scoped>

</style>
