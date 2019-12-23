package br.com.chucknorris.coreui.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel<T> : ViewModel() {
    abstract val model: T

    private val disposableContainer = CompositeDisposable()

    fun addDisposable(disposable: Disposable) {
        disposableContainer.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        disposableContainer.clear()
    }
}
