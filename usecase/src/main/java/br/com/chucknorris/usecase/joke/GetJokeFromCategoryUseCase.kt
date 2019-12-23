package br.com.chucknorris.usecase.joke

import br.com.chucknorris.model.Joke
import br.com.chucknorris.result.Result
import br.com.chucknorris.result.joke.GetJokeFromCategoryFailure
import io.reactivex.Single

interface GetJokeFromCategoryUseCase {
    operator fun invoke(category: String): Single<Result<GetJokeFromCategoryFailure, Joke>>
}
