package com.cct.app

import com.cct.app.Data.Question
import com.cct.app.Data.Team
import com.cct.app.Data.TeamDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class Controller {

    @Autowired
    lateinit var teamDao: TeamDao

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{teamName}")
    fun createTeam(@PathVariable teamName: String): Team {
        return teamDao.createTeam(teamName)
    }

    @GetMapping("/teams", produces = ["application/json"])
    fun getTeams(): List<Team> {
        return teamDao.getTeams()
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/{teamName}" + "/{questionID}" + "/{answer}")
    fun sendAnswer(@PathVariable teamName: String, @PathVariable questionID: Int, @PathVariable answer: Int ) {
        teamDao.handleAnswer(teamName, questionID, answer)
    }

}