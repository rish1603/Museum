package com.cct.app

import com.cct.app.Data.Question
import com.cct.app.Data.Team
import com.cct.app.Data.TeamDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class Controller {

    @Autowired
    lateinit var teamDao: TeamDao

    @Value("\${max.team.size}")
    private val maxTeamSize: Int? = null

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{teamName}")
    fun createTeam(@PathVariable teamName: String): Team {
        return teamDao.createTeam(teamName)
    }

    @GetMapping("/teams", produces = ["application/json"])
    fun getTeams(): List<Team> {
        return teamDao.getTeams()
    }

//    @GetMapping("/{teamName}" + "/{questionID}" + "/{answer}", produces = ["application/json"])
//    fun getNextQuestion(): Question{
//        return
//    }

    @CrossOrigin
    @GetMapping("/getQuestions", produces = ["application/json"])
    fun getQuestions(): Question {
        return teamDao.getNextQuestion()
    }

//    @ResponseStatus(HttpStatus.CREATED)
//    @PostMapping("/{teamName}" + "/{questionID}" + "/answer")
//    fun sendAnswer(@PathVariable teamName: String
//                   @PathVariable questionID: ) {
//        teamDao.createTeam(teamName)
//    }


}
