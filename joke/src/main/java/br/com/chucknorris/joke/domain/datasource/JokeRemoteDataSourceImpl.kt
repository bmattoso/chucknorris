package br.com.chucknorris.joke.domain.datasource

import br.com.chucknorris.coreui.scheduler.SchedulerProvider
import br.com.chucknorris.datasource.joke.JokeRemoteDataSource
import br.com.chucknorris.model.Joke
import br.com.chucknorris.result.Result
import br.com.chucknorris.result.joke.GetJokeFromCategoryFailure
import br.com.chucknorris.service.joke.JokeResponse
import br.com.chucknorris.service.joke.JokeService
import io.reactivex.Single
import javax.inject.Inject
import retrofit2.Response

class JokeRemoteDataSourceImpl @Inject constructor(
    private val jokeService: JokeService,
    private val schedulerProvider: SchedulerProvider,
    private val jokeResponseToJokeMapper: JokeResponseToJokeMapper
) : JokeRemoteDataSource {

    override fun getJokeFromCategory(category: String): Single<Result<GetJokeFromCategoryFailure, Joke>> {
        return jokeService.getRandomJokeFromCategory(category.toLowerCase())
            .subscribeOn(schedulerProvider.io())
            .map { response -> transformResponseIntoResult(response) }
    }

    private fun transformResponseIntoResult(
        response: Response<JokeResponse>
    ): Result<GetJokeFromCategoryFailure, Joke> {
        val body = response.body()

        return if (response.isSuccessful && body != null) {
            Result.Success(jokeResponseToJokeMapper.map(body))
        } else {
            Result.Error(GetJokeFromCategoryFailure.Server)
        }
    }
}
