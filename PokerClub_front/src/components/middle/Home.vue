<script>
export default {
  name: 'Home'
}
</script>

<template>
  <main>
    <div class="button" id="button-1">
      <div id="circle"></div>
      <a href="#">Create game!</a>
    </div>
    <div class="button" id="button-2">
      <div id="circle"></div>
      <a href="#">Continue your game!</a>
    </div>
    <div class="button" id="button-3">
      <div id="circle"></div>
      <a href="#">Create character!</a>
    </div>
  </main>
</template>

<style>

.button {
  border-radius: 10px;
  display: inline-flex;
  height: 80px;
  width: 250px;
  border: 3px solid #781417;
  margin: 40px 40px 40px 40px;
  color: #823131;
  text-transform: uppercase;
  text-decoration: none;
  font-size: 1em;
  letter-spacing: 2px;
  align-items: center;
  justify-content: center;
  overflow: hidden;
  background: rgba(191, 192, 192, 0.66);
}

a {
  align-items: center;
  color: black;
  text-decoration: none;
  letter-spacing: 1px;
}

#button-1 {
  margin-top: 3em;
  position: absolute;
  top: 50%;
  left: 40%;
  overflow: hidden;
  cursor: pointer;
}

#button-2 {
  margin-top: 3em;
  position: absolute;
  top: 60%;
  left: 40%;
  overflow: hidden;
  cursor: pointer;
}


#button-3 {
  margin-top: 3em;
  position: absolute;
  top: 70%;
  left: 40%;
  overflow: hidden;
  cursor: pointer;
}



a {
  position: relative;
  transition: all .45s ease-Out;
}


#circle {
  width: 0;
  height: 0;
  opacity: 0;
  line-height: 40px;
  border-radius: 50%;
  background: #7c7c7c;
  position: absolute;
  transition: all .5s ease-Out;
  top: 20px;
  left: 70px;
}

#button-1:hover #circle{
  width: 200%;
  height: 500%;
  opacity: 1;
  top: -70px;
  left: -70px;
}

#button-1:hover a {
  color: #2D3142;
}

#button-2:hover #circle {
  width: 200%;
  height: 500%;
  opacity: 1;
  top: -70px;
  left: -70px;
}

#button-2:hover a {
  color: #2D3142;
}

#button-3:hover #circle {
  width: 200%;
  height: 500%;
  opacity: 1;
  top: -70px;
  left: -70px;
}

#button-3:hover a {
  color: #2D3142;
}
</style>