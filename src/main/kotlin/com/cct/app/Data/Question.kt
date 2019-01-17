package com.cct.app.Data

data class Question (
        var question: String,
        var choices: ArrayList<String>,
        var rightAnswer: Int
)