package br.com.chucknorris.coreui.di

import androidx.lifecycle.ViewModelProvider
import br.com.chucknorris.coreui.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}