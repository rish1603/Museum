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
        return repository.save(Team(teamName, arrayListOf(), 0))
    }

    fun getTeams(): List<Team> {
        return repository.findAll()
    }

    fun getNextQuestion(): Question {

        val testModel = getQuestionsJson()
        println(testModel!![0])
        return testModel!![0]
    }

    fun handleAnswer(teamName: String, questionID: Int, answer: Int) {
        val team: Team = repository.findByTeamName(teamName)
        val questions = getQuestionsJson()

        if(questions!![questionID].rightAnswer == answer) {
            team.score++
        }
        team.answeredQuestionIds.add(questionID)

        repository.save(team)
    }

    fun getQuestionsJson(): Array<Question>? {
        val path = "src/main/kotlin/com/cct/app/Data/Questions.json"
        val bufferedReader = BufferedReader(FileReader(path))
        val gson = Gson()
        return gson.fromJson(bufferedReader, Array<Question>::class.java)
    }
}