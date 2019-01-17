package com.cct.app.Data

import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.aggregation.VariableOperators
import org.springframework.stereotype.Component
import java.io.BufferedReader
import java.io.FileReader

@Component
class TeamDao {

    @Autowired
    lateinit var repository: TeamRepository

    fun createTeam(teamName: String) {
        repository.save(Team(teamName, arrayListOf(), 0))
    }

    fun getTeams(): List<Team> {
        return repository.findAll()
    }

    fun getNextQuestion(): Question {
        val path = "src/main/kotlin/com/cct/app/Data/Questions.json"
        val bufferedReader = BufferedReader(FileReader(path))
        val gson = Gson()

        val testModel = gson.fromJson(bufferedReader, Array<Question>::class.java)
        println(testModel[0])
        return testModel[0]
    }

}