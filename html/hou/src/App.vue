<template>
  
  <HelloWorld msg="Welcome to Your Vue.js App"/>
  <div>
    <!-- <router-view></router-view> -->
    <!-- <div id='nav'>
      <router-link to='/'> Home</router-link>
      <router-link to='/helloworld'>Contact </router-link>
    </div>
    <router-view /> -->
  </div>  
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'

export default {
  name: 'App',
  components: {
    HelloWorld
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
