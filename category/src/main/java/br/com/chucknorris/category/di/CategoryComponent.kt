package br.com.chucknorris.category.di

import br.com.chucknorris.category.presentation.CategoryFragment
import br.com.chucknorris.coreui.di.CoreComponent
import br.com.chucknorris.coreui.di.scope.FragmentScope
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [CategoryModule::class],
    dependencies = [CoreComponent::class]
)
@FragmentScope
interface CategoryComponent {
    fun inject(categoryFragment: CategoryFragment)
}
