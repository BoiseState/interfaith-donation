<template>
  <div class="needInfoPage">
    <div class="jumbotron">
      <div class="container">
        <br>
        <br>
        <b-card :title="need.name">
          <b-form @submit="onFormSubmit" class="form-horizontal">
            <input type="hidden" name="need_id" v-model="need.id">
            <h5>Need Name: </h5>
            <b-form-input v-model="need.name"
                          required
                          placeholder="Enter name.."
                          name="name">
            </b-form-input>
            <h5>Description: </h5>
            <b-form-textarea v-model="need.description"
                             required
                             placeholder="Enter description.."
                             :rows="3"
                             name="description"
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
            <b-form-input v-model="need.unitOfMeasurement"
                          placeholder="Enter units the product is measured in.."
                          :rows="1"
                          name="units">
            </b-form-input>
            <br>
            <b-button type="submit" variant="success">Submit</b-button>
          </b-form>
        </b-card>
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
    });
  },
  methods: {
    onFormSubmit(evt) {
      evt.preventDefault();
      updateNeed(this.need);
    }
  }
};
</script>

<style scoped>

</style>
