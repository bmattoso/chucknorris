package br.com.chucknorris.category.di

import br.com.chucknorris.category.presentation.CategoryFragment
import br.com.chucknorris.coreui.di.CoreComponent
import br.com.chucknorris.coreui.di.scope.FragmentScope
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        CategoryModule::class,
        CategoryNavigationModule::class
    ],
    dependencies = [CoreComponent::class]
)
@FragmentScope
interface CategoryComponent {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun categoryFragment(categoryFragment: CategoryFragment): Builder

        fun coreComponent(component: CoreComponent): Builder
        fun build(): CategoryComponent
    }

    fun inject(categoryFragment: CategoryFragment)
}
