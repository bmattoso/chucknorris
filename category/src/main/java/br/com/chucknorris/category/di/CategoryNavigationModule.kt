package br.com.chucknorris.category.di

import br.com.chucknorris.category.presentation.CategoryFragment
import br.com.chucknorris.coreui.navigation.BaseNavigation
import br.com.chucknorris.coreui.navigation.FragmentNavigation
import dagger.Module
import dagger.Provides

@Module
class CategoryNavigationModule {

    @Provides
    fun providesBaseNavigation(categoryFragment: CategoryFragment): BaseNavigation =
        categoryFragment.requireActivity() as BaseNavigation

    @Provides
    fun providesFragmentNavigation(baseNavigation: BaseNavigation): FragmentNavigation =
        baseNavigation.fragmentNavigation
}
