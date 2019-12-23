package br.com.chucknorris.joke.presentation

import androidx.lifecycle.MutableLiveData

class JokeModel {
    val showLoading = MutableLiveData<Boolean>()
    val showError = MutableLiveData<Boolean>()
    val showJoke = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<Int>()

    val joke = MutableLiveData<JokeView>()
    val categoryName = MutableLiveData<String>()
}
