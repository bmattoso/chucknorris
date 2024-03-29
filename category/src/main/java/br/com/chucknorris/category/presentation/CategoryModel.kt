package br.com.chucknorris.category.presentation

import androidx.lifecycle.MutableLiveData

class CategoryModel {
    val showLoading = MutableLiveData<Boolean>()
    val showError = MutableLiveData<Boolean>()
    val showCategories = MutableLiveData<Boolean>()

    val errorMessage = MutableLiveData<Int>()
    val categories = MutableLiveData<List<CategoryView>>()
}
