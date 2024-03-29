package com.cct.app.Data

import org.springframework.data.annotation.Id

data class Team(
        @Id
        var teamName: String,
        var answeredQuestionIds: List<Int>,
        var score: Int
)