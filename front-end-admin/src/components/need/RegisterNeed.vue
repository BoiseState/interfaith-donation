<template>
  <div class="needInfoPage">
    <!-- Main jumbotron for a primary marketing message or call to action -->
    <b-jumbotron>
      <div class="container">
        <br>
        <br>
        <b-card :title="need.name">
          <b-form @submit="onFormSubmit" class="form-horizontal" >
            <input type="hidden" name="need_id" v-model="need.id">
            <h5>Need Name: </h5>
            <b-form-textarea v-model="need.name"
                             required
                             placeholder="Enter name.."
                             :rows="1"
                             no-resize
                             name="name"
                             :max-rows="1">
            </b-form-textarea>
            <h5>Description: </h5>
            <b-form-textarea v-model="need.description"
                             required
                             placeholder="Enter description.."
                             :rows="3"
                             name="Amazon URL"
                             :max-rows="3">
            </b-form-textarea>
            <h5>Amazon URL: </h5>
            <b-form-textarea v-model="need.url"
                             placeholder="Enter amazon url.."
                             :rows="3"
                             name="Amazon URL"
                             :max-rows="3">
            </b-form-textarea>
            <h5>Units: </h5>
            <b-form-textarea v-model="need.unitOfMeasurement"
                             placeholder="Enter units the product is measured in.."
                             :rows="1"
                             no-resize
                             name="units"
                             :max-rows="1">
            </b-form-textarea>
            <br>
            <b-button type="submit" variant="primary">Submit</b-button>
          </b-form>
        </b-card>
      </div>
    </b-jumbotron>
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
        name: 'New Need Template',
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
