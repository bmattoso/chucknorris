package br.com.chucknorris.model

import java.util.Date

data class Joke(
    val id: String,
    val date: Date,
    val image: String,
    val description: String,
    val url: String
)
