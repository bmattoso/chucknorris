package br.com.chucknorris.category.presentation

import br.com.chucknorris.coreui.viewmodel.BaseViewModel
import javax.inject.Inject

class CategoryViewModel @Inject constructor() : BaseViewModel<CategoryModel>() {

    override val model = CategoryModel()

    fun loadCategories() {
    }
}
