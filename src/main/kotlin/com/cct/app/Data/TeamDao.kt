package com.cct.app.Data

import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.io.BufferedReader
import java.io.FileReader

@Component
class TeamDao {

    @Autowired
    lateinit var repository: TeamRepository

    fun createTeam(teamName: String): Team {
        var randomisedQuestions = ((0..9).shuffled())
        return repository.save(Team(teamName, randomisedQuestions, 0))
    }

    fun getTeams(): List<Team> {
        return repository.findAll()
    }

    fun handleAnswer(teamName: String, questionID: Int, answer: Int) {
        val team: Team = repository.findByTeamName(teamName)
        val questions = getQuestionsJson()

        if(questions!![questionID].rightAnswer == answer) {
            team.score++
        }

        repository.save(team)
    }

    fun getQuestionsJson(): Array<Question>? {
        val path = "src/main/kotlin/com/cct/app/Data/Questions.json"
        val bufferedReader = BufferedReader(FileReader(path))
        return Gson().fromJson(bufferedReader, Array<Question>::class.java)
    }

}
