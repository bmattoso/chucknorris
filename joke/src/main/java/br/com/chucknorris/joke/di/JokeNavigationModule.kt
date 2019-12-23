package br.com.chucknorris.joke.di

import br.com.chucknorris.coreui.navigation.BaseNavigation
import br.com.chucknorris.coreui.navigation.FragmentNavigation
import br.com.chucknorris.joke.presentation.JokeFragment
import dagger.Module
import dagger.Provides

@Module
class JokeNavigationModule {

    @Provides
    fun providesBaseNavigation(jokeFragment: JokeFragment): BaseNavigation =
        jokeFragment.requireActivity() as BaseNavigation

    @Provides
    fun providesFragmentNavigation(baseNavigation: BaseNavigation): FragmentNavigation =
        baseNavigation.fragmentNavigation
}
