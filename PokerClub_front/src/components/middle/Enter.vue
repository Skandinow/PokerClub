<script>

export default {
  name: "Enter",
  data: function () {
    return {
      login: "",
      password: "",
      error: ""
    }
  },
  methods: {
    onEnter: function () {
      this.$root.$emit("onEnter", this.login, this.password);
    }
  },
  beforeCreate() {
    this.$root.$on("onEnterValidationError", (error) => this.error = error);
  }
}
</script>

<template>
  <form class="form-3">
    <p class="clearfix">
      <input type="text" name="login" id="login" placeholder="Username">
    </p>
    <p class="clearfix">
      <input type="password" name="password" id="password" placeholder="Password">
    </p>
    <p class="clearfix">
      <input type="submit" name="submit" value="Sign in">
    </p>
  </form>


</template>

<style scoped>


.form-3 {
  font-family: 'Ubuntu', 'Lato', sans-serif;
  font-weight: 400;
  /* Size and position */
  width: 300px;
  position: absolute;
  top: 40%;
  left: 41%;
  margin: 60px auto 30px;
  padding: 10px;
  overflow: hidden;

  /* Styles */
  background: rgba(44, 1, 1, 0.92);
  border-radius: 0.4em;
  border: 1px solid #191919;
  box-shadow:
      inset 0 0 2px 1px rgba(255,255,255,0.08),
      0 16px 10px -8px rgba(0, 0, 0, 0.6);
}

.form-3 label {
  /* Size and position */
  width: 100%;
  float: left;
  padding-top: 9px;

  /* Styles */
  color: #ddd;
  font-size: 13px;
  text-transform: uppercase;
  letter-spacing: 1px;
  text-shadow: 0 1px 0 #000;
  text-indent: 10px;
  font-weight: 700;
  cursor: pointer;
}

.form-3 input[type=text],
.form-3 input[type=password] {
  /* Size and position */
  width: 90%;
  padding: 8px 5px;
  font-size: 12px;

  /* Styles */
  background: linear-gradient(#1f2124, #27292c);
  border: 1px solid #000;
  box-shadow:
      0 1px 0 rgba(255,255,255,0.1);
  border-radius: 3px;

  /* Font styles */
  font-family: 'Ubuntu', 'Lato', sans-serif;
  color: #fff;

}

.form-3 input[type=text]:hover,
.form-3 input[type=password]:hover,
.form-3 label:hover ~ input[type=text],
.form-3 label:hover ~ input[type=password] {
  background: #27292c;
}

.form-3 input[type=text]:focus,
.form-3 input[type=password]:focus {
  box-shadow: inset 0 0 2px #000;
  background: #494d54;
  border-color: #51cbee;
  outline: none; /* Remove Chrome outline */
}

.form-3 p:nth-child(3),
.form-3 p:nth-child(4) {
  float: left;
  width: 50%;
}

.form-3 label[for=remember] {
  width: auto;
  float: none;
  display: inline-block;
  text-transform: capitalize;
  font-size: 11px;
  font-weight: 400;
  letter-spacing: 0;
  text-indent: 2px;
}


.form-3 input[type=submit] {
  /* Width and position */
  width: 200%;
  padding: 8px 5px;
  position: relative;



  /* Styles */
  border: 1px solid #0273dd; /* Fallback */
  box-shadow:
      inset 0 1px 0 rgba(255,255,255,0.3),
      inset 0 10px 10px rgba(255,255,255,0.1);
  border-radius: 3px;
  background: #38a6f0;
  cursor:pointer;

  /* Font styles */
  font-family: 'Ubuntu', 'Lato', sans-serif;
  color: white;
  font-weight: 700;
  font-size: 15px;
  text-shadow: 0 -1px 0 rgba(0,0,0,0.8);
}

.form-3 input[type=submit]:hover {
  box-shadow: inset 0 1px 0 rgba(255,255,255,0.6);
}

.form-3 input[type=submit]:active {
  background: #287db5;
  box-shadow: inset 0 0 3px rgba(0,0,0,0.6);
  border-color: #000; /* Fallback */
  border-color: rgba(0,0,0,0.9);
}

.no-boxshadow .form-3 input[type=submit]:hover {
  background: #2a92d8;
}

/* Gradient line */
.form-3:after {
  /* Size and position */
  content: "";
  height: 1px;
  width: 33%;
  position: absolute;
  left: 50%;
  top: 0;

  /* Styles */
  background: linear-gradient(left, transparent, #444, #8c0505, #444, transparent);
}


.no-pointerevents .form-3 p:nth-child(1):before {
  display: none;
}


</style>