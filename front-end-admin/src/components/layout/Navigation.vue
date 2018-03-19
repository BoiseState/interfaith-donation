<template>
  <nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                aria-expanded="false" aria-controls="navbar">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <router-link class="navbar-brand" to="/">Interfaith Sanctuary Administrator Tool</router-link>
      </div>
      <div id="navbar" class="navbar-collapse collapse">
        <slot />
      </div>
      <div>
        <router-link class="navbar-brand" to="/donors">Donors</router-link>
        <router-link class="navbar-brand" to="/users">Users</router-link>
        <router-link class="navbar-brand" to="/callouts">Callouts</router-link>
        <router-link class="navbar-brand" to="/needs">Needs</router-link>
      </div>
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
