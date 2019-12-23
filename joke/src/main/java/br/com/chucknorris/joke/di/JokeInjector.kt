package br.com.chucknorris.joke.di

import br.com.chucknorris.coreui.di.CoreComponentProvider
import br.com.chucknorris.joke.presentation.JokeFragment

object JokeInjector {

    fun inject(jokeFragment: JokeFragment) {
        val coreComponentProvider = jokeFragment.requireActivity().application as CoreComponentProvider

        DaggerJokeComponent.builder()
            .coreComponent(coreComponentProvider.coreComponent)
            .jokeFragment(jokeFragment)
            .build()
            .inject(jokeFragment)
    }
}
