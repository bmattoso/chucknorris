package br.com.chucknorris.category.presentation

import br.com.chucknorris.category.R
import br.com.chucknorris.coreui.navigation.FragmentNavigation
import br.com.chucknorris.coreui.scheduler.SchedulerProvider
import br.com.chucknorris.coreui.viewmodel.BaseViewModel
import br.com.chucknorris.model.Category
import br.com.chucknorris.result.Result
import br.com.chucknorris.result.category.GetCategoriesAvailableFailure
import br.com.chucknorris.usecase.category.GetEventCategoryListUseCase
import javax.inject.Inject

class CategoryViewModel @Inject constructor(
    private val getEventCategoryListUseCase: GetEventCategoryListUseCase,
    private val schedulerProvider: SchedulerProvider,
    private val navigation: FragmentNavigation
) : BaseViewModel<CategoryModel>(), CategoryListener {

    override val model = CategoryModel()

    override fun onCategoryClick(id: String) {
        val selectedCategory = model.categories.value?.firstOrNull { category -> category.id == id }
        selectedCategory?.let {
            navigation.openRandomJokeFragment(selectedCategory.name)
        }
    }

    fun loadCategories() {
        showLoading()

        addDisposable(
            getEventCategoryListUseCase()
                .observeOn(schedulerProvider.ui())
                .doOnSuccess { result -> handleSuccessCategories(result) }
                .doOnError { showError(R.string.get_category_error) }
                .subscribe()
        )
    }

    private fun handleSuccessCategories(result: Result<GetCategoriesAvailableFailure, List<Category>>?) {
        if (result is Result.Success) {
            val categories = result.data.map { category -> transformCategoryIntoCategoryView(category) }
            showCategories(categories)
        } else if (result is Result.Error) {
            val errorMessage = getErrorMessage(result.error)
            showError(errorMessage)
        }
    }

    private fun showCategories(categories: List<CategoryView>) {
        model.categories.postValue(categories)
        model.showCategories.postValue(true)
        model.showError.postValue(false)
        model.showLoading.postValue(false)
    }

    private fun showError(message: Int) {
        model.errorMessage.postValue(message)
        model.showCategories.postValue(false)
        model.showError.postValue(true)
        model.showLoading.postValue(false)
    }

    private fun showLoading() {
        model.showCategories.postValue(false)
        model.showError.postValue(false)
        model.showLoading.postValue(true)
    }

    private fun getErrorMessage(error: GetCategoriesAvailableFailure): Int {
        return when (error) {
            GetCategoriesAvailableFailure.Server -> R.string.get_category_error
            GetCategoriesAvailableFailure.Connection -> R.string.conection_error
        }
    }

    private fun transformCategoryIntoCategoryView(category: Category) = CategoryView(
        category.id.toString(),
        category.name.capitalize()
    )
}
