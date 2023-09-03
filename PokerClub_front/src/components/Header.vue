<script>
export default {
  name: "Header",
  props: ["user"],
  methods: {
    changePage: function (page) {
      this.$root.$emit("onChangePage", page);
    },
    onLogout: function () {
      this.$root.$emit("onLogout");
      this.changePage("Home");
    }
  }
}
</script>

<template>
  <header>
    <div class="poker">
      <a href="#" @click.prevent="changePage('Home')" id="home">Poker Club</a>
    </div>
    <div class="enter-or-register-box">
      <template v-if="user">
        {{ user.name }}
        |
        <a href="#" @click.prevent="onLogout" id="logout">Logout</a>
      </template>
      <template v-else>
        <a href="#" @click.prevent="changePage('Enter')" id="enter">Enter</a>
        |
        <a href="#" @click.prevent="changePage('Register')" id="register">Register</a>
      </template>
    </div>
  </header>

</template>

<style scoped>
.enter-or-register-box {
  color: white;
}

.enter-or-register-box a {
  color: #bec7c7;
}

#logout {
  position: absolute;
  top: 5%;
  right: 12%;
}

#register {
  position: absolute;
  top: 5%;
  right: 5%;
}

#enter {
  position: absolute;
  top: 5%;
  right: 9%;
}





</style>