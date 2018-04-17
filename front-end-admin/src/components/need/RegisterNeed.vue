<template>
  <div>
    <div class="container">
      <b-alert variant="success"
               dismissible
               :show="showSuccessAlert"
               @dismissed="showSuccessAlert=false"
      >
        The need was created!
      </b-alert>
      <b-alert variant="danger"
               dismissible
               :show="showFailureAlert"
               @dismissed="showFailureAlert=false"
      >
        The need could not be created!
      </b-alert>
      <b-card title="Create Need">
        <b-form @submit.prevent="onFormSubmit" class="form-horizontal" >
          <b-form-group label="Name:"
                        label-for="register-need-name"
          >
            <b-form-input id="register-need-name"
                          type="text"
                          v-model="name"
                          required
                          placeholder="Enter need name...">
            </b-form-input>
          </b-form-group>
          <b-form-group label="Description:"
                        label-for="register-need-description"
          >
            <b-form-textarea id="register-need-description"
                             v-model="description"
                             placeholder="Enter need description..."
                             :rows="3"
                             :max-rows="6"
            >
            </b-form-textarea>
          </b-form-group>
          <b-form-group label="Amazon URL:"
                        label-for="register-need-amazon-url"
          >
            <b-form-input id="register-need-amazon-url"
                          type="text"
                          v-model="url"
                          placeholder="Enter the Amazon URL for the need if it has one...">
            </b-form-input>
          </b-form-group>
          <b-form-group label="Unit of Measurement:"
                        label-for="register-need-unit"
          >
            <b-form-input id="register-need-unit"
                          type="text"
                          v-model="unitOfMeasurement"
                          placeholder="Enter the units the need is measured in...">
            </b-form-input>
          </b-form-group>
          <b-form-group label="Active:"
                        label-for="register-need-active"
          >
            <b-form-checkbox id="register-need-active"
                             v-model="active"
            >
            </b-form-checkbox>
          </b-form-group>
          <b-button type="submit" variant="success">Submit</b-button>
        </b-form>
      </b-card>
    </div>
  </div>
</template>

<script>
import { createNeed } from '../../services/need-service';
export default {
  name: 'register-need',
  data() {
    return {
      name: '',
      url: '',
      description: '',
      unitOfMeasurement: '',
      active: '',
      showSuccessAlert: false,
      showFailureAlert: false
    };
  },
  methods: {
    onFormSubmit() {
      const needToCreate = {
        id: 0,
        name: this.name,
        url: this.url,
        description: this.description,
        unitOfMeasurement: this.unitOfMeasurement,
        active: this.active
      };
      createNeed(needToCreate)
        .then(res => {
          if (res) {
            this.showSuccessAlert = true;
          }
        })
        .catch(err => {
          console.error(err);
          this.showErrorAlert = true;
        });
    }
  }
};
</script>

<style scoped>

</style>
