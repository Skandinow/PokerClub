<script>

import Home from "@/components/middle/Home.vue";
import Register from "@/components/middle/Register.vue";
import Enter from "@/components/middle/Enter.vue";

export default {
  name: "Middle",
  data: function () {
    return {
      page: "Home"
    }
  },
  components: {
    Enter,
    Home,
    Register
  },
  beforeCreate() {
    this.$root.$on("onChangePage", (page) => this.page = page)
  }
}

</script>

<template>
  <div id="mid">
    <main>
      <Home v-if="page === 'Home'"/>
      <Enter v-if="page === 'Enter'"/>
      <Register v-if="page === 'Register'"/>
    </main>
  </div>
</template>

<style>
</style>