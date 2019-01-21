<template>
  <div id="question" class="route">
    <Timer :time="timeLeft" />
    <h1>Question {{$route.params.id}}</h1>
    <h3>{{question.question}}</h3>
    <a v-for="(choice, i) in question.choices" v-on:click="selectAnswer(i)" :key="i" class="questionBt">{{choice}}</a>
  </div>
</template>

<script>
import Timer from '@/components/Timer'
import { timePerQuestion, apiUrl } from '../consts.js'
export default {
  name: 'Question',
  components: {
    Timer
  },
  data: () => ({
    timeLeft: timePerQuestion,
    timer: '',
    question: {
        "question": "Loading the question",
        "choices": [],
        "rightAnswer": 1000
    }
  }),
  methods: {
    passSecond() {
      this.timeLeft = this.timeLeft - 1
      // if(this.timeLeft == 0) {
      //   this.$store.commit('nextQuestion')
      //   this.$router.push('/question/' + this.$store.getters.nextQuestion)
      //   this.timeLeft = timePerQuestion
      //   this.fetchQuestion()
      // }
    },
    async selectAnswer(choice) {
      console.log('Selected choice ' + choice)
      console.log(this.$store.getters.team.name)
      const resp = await fetch(`${apiUrl}/${this.$store.getters.team.name}/${this.$route.params.id}/${choice}`, {method: "POST"})
      console.log('next')
      this.$store.commit('nextQuestion')
      clearInterval(this.timer)
      if(this.$store.getters.nextQuestion == undefined){
        this.$router.push('/leaderboard/')
      } else {
        this.$router.push('/question/' + this.$store.getters.nextQuestion)
        this.timeLeft = timePerQuestion
        this.fetchQuestion()
      }
    },
    async fetchQuestion() {
      this.timer = setInterval(this.passSecond, 1000)
      const resp = await fetch(`${apiUrl}/question/${this.$route.params.id}`)
      const json = await resp.json()
      this.question = json
    }
  },
  async created() {
    clearInterval(this.timer)
    await this.fetchQuestion()
  },
  beforeDestroy() {
    clearInterval(this.timer)
  },
}
</script>

<style>
.questionBt {
  display: block;
  background-color: white;
  color: #5FAFFF;
  border-radius: 20px;
  padding: 10px;
  margin:20px;
}
</style>
