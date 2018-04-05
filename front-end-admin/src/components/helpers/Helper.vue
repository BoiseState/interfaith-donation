<template>
  <div></div>
</template>

<script>
export default {
  name: 'Helper',
  methods: {
    formatDate(dateString) {
      let date = new Date(dateString);
      return date.toLocaleDateString();
    },
    getPermissionsLevel(permissionLevel) {
      if (permissionLevel === 1) {
        return 'ADMINISTRATOR';
      } else if (permissionLevel === 2) {
        return 'SUPERADMIN';
      } else {
        return 'BASIC_USER';
      }
    },
    getPermissionText(user) {
      if (user.permissions === 'BASIC_USER') {
        return 'No Permissions';
      } else if (user.permissions === 'ADMINISTRATOR') {
        return 'Admin';
      } else if (user.permissions === 'SUPERADMIN') {
        return 'Super Admin/Jody';
      }
      // user.permissions = 'BASIC_USER';
      return 'Invalid Permissions';
    },
    calculateProgress(calloutNeed) {
      calloutNeed.donations.forEach(donation => {
        calloutNeed.donationSum += donation.quantity;
      });
    }
  }
};
</script>

<style scoped>

</style>
