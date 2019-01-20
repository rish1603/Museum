<template>
  <div id="home">
    <h1>The indiana jones experience</h1>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <input type="text" placeholder="Enter your team name..." v-model="teamName"/>
    <br/>
    <a @click="submitTeam" class="button" >Join as {{teamName}}</a>
  </div>
</template>

<script>
// @ is an alias to /src
import { apiUrl } from '@/consts.js'
export default {
  name: 'home',
  data() {
    return {
      teamName: ''
    }
  },
  methods: {
    async submitTeam() {
      if(this.teamName == '') {
        console.error('You need to fill this field')
      }
      const resp = await fetch(`${apiUrl}/${this.teamName}`, {method: 'POST'})
      const json = await resp.json()
      this.$store.commit('setTeam', json)
      this.$router.push('/question/' + json.answeredQuestionIds[0])
    }
  },
}
</script>

<style>
#home {
  background-image: url('../assets/bg.jpg');
  background-size: contain;
  padding:40px;
  height: 100vh;
  box-sizing: border-box;
}

.button {
  background-color: #5FAFFF;
  padding: 10px;
  border-radius:30px;
}

h1 {
  text-shadow: 2px 2px black;
}

input {
  padding: 10px 40px;
  border-radius: 10px;
  border: 0px;
  margin:30px;
}

</style>

