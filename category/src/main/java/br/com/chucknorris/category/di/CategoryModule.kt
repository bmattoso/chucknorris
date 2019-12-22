package br.com.chucknorris.category.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.chucknorris.category.presentation.CategoryViewModel
import br.com.chucknorris.coreui.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class CategoryModule {

    @Binds
    @IntoMap
    @ViewModelKey(CategoryViewModel::class)
    abstract fun getCategoryViewModel(viewModel: CategoryViewModel): ViewModel
}
