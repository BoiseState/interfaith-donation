<template>
  <div>
    <div class="container">
      <b-alert variant="success"
               dismissible
               :show="showSuccessAlert"
               @dismissed="showSuccessAlert=false"
      >
        The need was updated!
      </b-alert>
      <b-alert variant="danger"
               dismissible
               :show="showFailureAlert"
               @dismissed="showFailureAlert=false"
      >
        The need could not be updated!
      </b-alert>
      <b-card title="Update Need">
        <b-form @submit.prevent="onFormSubmit" class="form-horizontal" >
          <b-form-group label="Name:"
                        label-for="register-need-name"
          >
            <b-form-input id="register-need-name"
                          type="text"
                          v-model="need.name"
                          required
            >
            </b-form-input>
          </b-form-group>
          <b-form-group label="Description:"
                        label-for="register-need-description"
          >
            <b-form-textarea id="register-need-description"
                             v-model="need.description"
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
                          v-model="need.url"
            >
            </b-form-input>
          </b-form-group>
          <b-form-group label="Unit of Measurement:"
                        label-for="register-need-unit"
          >
            <b-form-input id="register-need-unit"
                          type="text"
                          v-model="need.unitOfMeasurement"
            >
            </b-form-input>
          </b-form-group>
          <b-form-group label="Active:"
                        label-for="register-need-active"
          >
            <b-form-checkbox id="register-need-active"
                             v-model="need.active"
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
import { getNeedById, updateNeed } from '../../services/need-service';
export default {
  name: 'need-info',
  data() {
    return {
      need: {
        id: '',
        name: '',
        unitOfMeasurement: '',
        description: '',
        url: '',
        active: ''
      },
      showSuccessAlert: false,
      showFailureAlert: false
    };
  },
  created() {
    getNeedById(this.$route.params.id).then(need => {
      this.need = need;
    });
  },
  methods: {
    onFormSubmit() {
      updateNeed(this.need)
        .then(res => {
          if (res) {
            this.showSuccessAlert = true;
          }
        })
        .catch(err => {
          console.error(err);
          this.showFailureAlert = true;
        });
    }
  }
};
</script>

<style scoped>

</style>
