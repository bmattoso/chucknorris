package br.com.chucknorris.joke.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.chucknorris.coreui.di.scope.FragmentScope
import br.com.chucknorris.coreui.viewmodel.ViewModelFactory
import br.com.chucknorris.coreui.viewmodel.ViewModelKey
import br.com.chucknorris.joke.presentation.JokeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class JokeModule {

    @Binds
    @IntoMap
    @ViewModelKey(JokeViewModel::class)
    abstract fun getCategoryViewModel(viewModel: JokeViewModel): ViewModel

    @Binds
    @FragmentScope
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
