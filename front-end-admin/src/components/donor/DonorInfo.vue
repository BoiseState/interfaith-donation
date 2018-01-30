<template>
  <div class="donorInfoPage">
    <div class="jumbotron">
      <h2>{{donor.name}}</h2>
    </div>
  </div>
</template>

<script>
import {getDonorById} from '../../services/donors-service';

export default {
  name: 'donor-info',
  data () {
    return {
      donor: {
        name: 'Loading...'
      }
    };
  },
  created () {
    getDonorById(this.$route.params.id).then(donor => {
      this.donor = donor;
    });
  }
};
</script>

<style scoped>

</style>
