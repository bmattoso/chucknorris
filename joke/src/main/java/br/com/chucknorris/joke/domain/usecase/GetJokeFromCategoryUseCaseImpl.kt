package br.com.chucknorris.joke.domain.usecase

import br.com.chucknorris.model.Joke
import br.com.chucknorris.repository.joke.JokeRepository
import br.com.chucknorris.result.Result
import br.com.chucknorris.result.joke.GetJokeFromCategoryFailure
import br.com.chucknorris.usecase.joke.GetJokeFromCategoryUseCase
import io.reactivex.Single
import javax.inject.Inject

class GetJokeFromCategoryUseCaseImpl @Inject constructor(
    private val jokeRepository: JokeRepository
) : GetJokeFromCategoryUseCase {

    override fun invoke(category: String): Single<Result<GetJokeFromCategoryFailure, Joke>> {
        return jokeRepository.getJokeFromCategory(category)
    }
}
