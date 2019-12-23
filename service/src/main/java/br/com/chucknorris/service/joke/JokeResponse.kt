package br.com.chucknorris.service.joke

import com.google.gson.annotations.SerializedName

data class JokeResponse(
    val id: String,
    @SerializedName("created_at")
    val date: String,
    @SerializedName("icon_url")
    val image: String,
    @SerializedName("value")
    val description: String,
    val url: String
)
