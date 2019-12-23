package br.com.chucknorris.service.joke

import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface JokeService {

    @GET("/jokes/random")
    fun getRandomJokeFromCategory(@Query("category") category: String): Single<Response<JokeResponse>>
}
