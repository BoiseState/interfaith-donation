<template>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
      <div class="navbar-header">
        <div style="display:block">
          <router-link class="navbar-brand" to="/">Interfaith Sanctuary Administrator Tool</router-link>
        </div>
      </div>
      <div>
        <router-link class="navbar-brand" to="/donors">Donors</router-link>
        <router-link class="navbar-brand" to="/users">Users</router-link>
        <router-link class="navbar-brand" to="/callouts">Callouts</router-link>
        <router-link class="navbar-brand" to="/needs">Needs</router-link>
      </div>
    </div>
    <div style="display:block">
    <b-collapse id="collapse1" class="mt-2" style="margin-left: 120px">
      <b-card>
        <p class="card-text">Login/Logout Placeholder</p>
      </b-card>
    </b-collapse>
    </div>
  </nav>
</template>

<script>
export default {
  name: 'navigation'
};
</script>

<style scoped>

</style>
