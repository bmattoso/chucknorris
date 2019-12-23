package br.com.chucknorris.joke.di

import br.com.chucknorris.coreui.di.CoreComponent
import br.com.chucknorris.coreui.di.scope.FragmentScope
import br.com.chucknorris.joke.presentation.JokeFragment
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        JokeModule::class,
        JokeNavigationModule::class,
        JokeDomainModule::class
    ],
    dependencies = [CoreComponent::class]
)
@FragmentScope
interface JokeComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun jokeFragment(jokeFragment: JokeFragment): Builder

        fun coreComponent(component: CoreComponent): Builder
        fun build(): JokeComponent
    }

    fun inject(jokeFragment: JokeFragment)
}
