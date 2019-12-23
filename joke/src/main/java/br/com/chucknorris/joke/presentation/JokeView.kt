package br.com.chucknorris.joke.presentation

data class JokeView(
    val date: String,
    val image: String,
    val description: String,
    val url: String
)
