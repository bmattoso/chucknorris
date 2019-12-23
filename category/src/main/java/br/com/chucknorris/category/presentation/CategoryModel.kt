package br.com.chucknorris.category.presentation

import androidx.lifecycle.MutableLiveData
import br.com.chucknorris.model.Category

class CategoryModel {
    val showLoading = MutableLiveData<Boolean>()
    val categories = MutableLiveData<List<Category>>()
    val showError = MutableLiveData<Boolean>()
}
