package br.com.chucknorris.joke.presentation

import br.com.chucknorris.coreui.scheduler.SchedulerProvider
import br.com.chucknorris.coreui.viewmodel.BaseViewModel
import br.com.chucknorris.joke.R
import br.com.chucknorris.joke.presentation.mapper.JokeToJokeViewMapper
import br.com.chucknorris.model.Joke
import br.com.chucknorris.result.Result
import br.com.chucknorris.result.joke.GetJokeFromCategoryFailure
import br.com.chucknorris.usecase.joke.GetJokeFromCategoryUseCase
import javax.inject.Inject

class JokeViewModel @Inject constructor(
    private val getJokeFromCategoryUseCase: GetJokeFromCategoryUseCase,
    private val schedulerProvider: SchedulerProvider,
    private val jokeToJokeViewMapper: JokeToJokeViewMapper
) : BaseViewModel<JokeModel>() {
    override val model = JokeModel()

    fun loadJokeFromCategory(category: String) {
        showLoading()

        addDisposable(
            getJokeFromCategoryUseCase(category)
                .observeOn(schedulerProvider.ui())
                .doOnSuccess { result -> handleSuccessJoke(result) }
                .doOnError { showError(R.string.get_joke_category_error) }
                .subscribe()
        )
    }

    private fun handleSuccessJoke(result: Result<GetJokeFromCategoryFailure, Joke>) {
        when (result) {
            is Result.Success -> showJoke(result.data)
            is Result.Error -> {
                val errorResId = getErrorMessageFromResultError(result.error)
                showError(errorResId)
            }
        }
    }

    private fun getErrorMessageFromResultError(error: GetJokeFromCategoryFailure): Int {
        return when (error) {
            GetJokeFromCategoryFailure.Connection -> R.string.conection_error
            GetJokeFromCategoryFailure.Server -> R.string.get_joke_category_error
        }
    }

    private fun showLoading() {
        model.showJoke.postValue(false)
        model.showError.postValue(false)
        model.showLoading.postValue(true)
    }

    private fun showJoke(joke: Joke) {
        model.joke.postValue(jokeToJokeViewMapper.map(joke))
        model.showJoke.postValue(true)
        model.showError.postValue(false)
        model.showLoading.postValue(false)
    }

    private fun showError(message: Int) {
        model.errorMessage.postValue(message)
        model.showJoke.postValue(false)
        model.showError.postValue(true)
        model.showLoading.postValue(false)
    }
}
