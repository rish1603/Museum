import Vue from 'vue'
import Vuex from 'vuex'
import createPersistedState from 'vuex-persistedstate'
Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    team: {
      name: '',
      answeredQuestionIds: [],
      currentQuestion: 0,
    }
  },
  mutations: {
    setTeam: (state, payload) => {
      state.team.name = payload.teamName
      state.team.answeredQuestionIds = payload.answeredQuestionIds
      state.team.currentQuestion = payload.answeredQuestionIds[0]
    },
    nextQuestion: (state) => state.team.currentQuestion++
  },
  getters: {
    team: (state) => state.team,
    nextQuestion: (state) => state.team.answeredQuestionIds[state.team.currentQuestion]
  },
  plugins: [createPersistedState()]
})
