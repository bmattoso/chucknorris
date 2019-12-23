package br.com.chucknorris.repository.joke

import br.com.chucknorris.model.Joke
import br.com.chucknorris.repository.core.BaseRepository
import br.com.chucknorris.result.Result
import br.com.chucknorris.result.joke.GetJokeFromCategoryFailure
import io.reactivex.Single

abstract class JokeRepository : BaseRepository() {
    abstract fun getJokeFromCategory(category: String): Single<Result<GetJokeFromCategoryFailure, Joke>>
}
