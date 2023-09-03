<template>
  <div id="app" >`
    <img src="./assets/img/background1.jpg" class="background" alt="meow"/>
    <Header :user="user"/>
    <CentralMenu/>
    <Footer/>
  </div>
</template>


<script >
import CentralMenu from "@/components/Middle.vue";
import Header from "@/components/Header.vue";
import Footer from "@/components/Footer.vue";
import axios from "axios";


export default {
  name : 'App',
  components: {
    Header,
    CentralMenu,
    Footer,
  },
  data: function () {
    return {
      user : null,
      rooms : null,
      characters : null
    }
  },beforeMount() {
    axios.get("api/1/rooms").then(response => {
          this.rooms = response.data;
        }
    );
  },

}
</script>

<style>
img.background {
  min-height: 100%;
  min-width: 640px;
  width: 100%;
  height: auto;
  position: fixed;
  top: 0;
  //left: 200px;


}



</style>