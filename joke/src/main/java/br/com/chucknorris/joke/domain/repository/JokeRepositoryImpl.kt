package br.com.chucknorris.joke.domain.repository

import br.com.chucknorris.datasource.joke.JokeRemoteDataSource
import br.com.chucknorris.model.Joke
import br.com.chucknorris.repository.joke.JokeRepository
import br.com.chucknorris.result.Result
import br.com.chucknorris.result.joke.GetJokeFromCategoryFailure
import io.reactivex.Single
import javax.inject.Inject

class JokeRepositoryImpl @Inject constructor(
    private val jokeRemoteDataSource: JokeRemoteDataSource
) : JokeRepository() {

    override fun getJokeFromCategory(category: String): Single<Result<GetJokeFromCategoryFailure, Joke>> {
        return if (networkAvailability.isAvailable()) {
            jokeRemoteDataSource.getJokeFromCategory(category)
        } else {
            Single.just(Result.Error(GetJokeFromCategoryFailure.Connection))
        }
    }
}
