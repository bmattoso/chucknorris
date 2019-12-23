package br.com.chucknorris.category.presentation

import androidx.lifecycle.MutableLiveData
import br.com.chucknorris.model.Category

class CategoryModel {
    val categories = MutableLiveData<List<Category>>()
    val showError = MutableLiveData<Boolean>()
}
