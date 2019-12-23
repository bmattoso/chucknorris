package br.com.chucknorris.datasource.joke

import br.com.chucknorris.model.Joke
import br.com.chucknorris.result.Result
import br.com.chucknorris.result.joke.GetJokeFromCategoryFailure
import io.reactivex.Single

interface JokeRemoteDataSource {
    fun getJokeFromCategory(category: String): Single<Result<GetJokeFromCategoryFailure, Joke>>
}
