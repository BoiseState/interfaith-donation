<template>
  <div class="addcallout">
    <div class="jumbotron">
      <div class="container">
        <h2>Manually Add Donation</h2>
        <!--CODE GOES HERE TO LIST GIFTS!!!! -->
        <form class="form-horizontal" action="/createdonation" method="POST">
          <!-- Quantity needed, not sure if correct  -->
          <input type="hidden" value="{{need_id}}" name="need_id" />
          <div class="form-group">
            <label class="control-label col-sm-2>">Choose a Donor:</label>
            <select name = donor_id>
              <option value="{{donor.donor_id}}">{{ donor.donor_name }}</option>
            </select></div>
          <div class="form-group">
            <label class="control-label col-sm-2">Quantity:</label>
            <input id="gift_quantity" name="gift_quantity" type="number" min="1" max="{{max_gift_quantity}}" step="1" value="1"/>
            <label class="control-label col-sm-2">{{need_unit}}</label>
          </div>
          <button type="submit">Create Donation</button>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "donate-to-need"
  }
</script>

<style scoped>

</style>
