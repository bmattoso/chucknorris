package br.com.chucknorris.category.presentation

import br.com.chucknorris.coreui.scheduler.SchedulerProvider
import br.com.chucknorris.coreui.viewmodel.BaseViewModel
import br.com.chucknorris.model.Category
import br.com.chucknorris.result.Result
import br.com.chucknorris.result.category.GetCategoriesAvailableFailure
import br.com.chucknorris.usecase.category.GetEventCategoryListUseCase
import javax.inject.Inject

class CategoryViewModel @Inject constructor(
    private val getEventCategoryListUseCase: GetEventCategoryListUseCase,
    private val schedulerProvider: SchedulerProvider
) : BaseViewModel<CategoryModel>() {

    override val model = CategoryModel()

    fun loadCategories() {
        model.showLoading.postValue(true)

        addDisposable(
            getEventCategoryListUseCase()
                .observeOn(schedulerProvider.ui())
                .doOnSuccess { result -> handleSuccessCategories(result) }
                .doOnError { showError() }
                .subscribe()
        )
    }

    private fun handleSuccessCategories(result: Result<GetCategoriesAvailableFailure, List<Category>>?) {
        if (result is Result.Success) {
            model.categories.postValue(result.data)
            hideLoading()
        } else {
            showError()
        }
    }

    private fun showError() {
        model.showError.postValue(true)
        hideLoading()
    }

    private fun hideLoading() {
        model.showLoading.postValue(false)
    }
}
