<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<style>
body {
  margin: 0px;
}

.route {
  background-color: #5FAFFF;
  padding:40px;
  min-height: 100vh;
  box-sizing: border-box;
}


#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  /* color: #2c3e50; */
  color: white;
  width: 100vw;
  height: 100vh;
}
</style>
