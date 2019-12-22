package br.com.chucknorris.di

import br.com.chucknorris.coreui.di.CoreComponent
import br.com.chucknorris.coreui.di.scope.ActivityScope
import br.com.chucknorris.home.HomeActivity
import dagger.Component

@ActivityScope
@Component(
    modules = [],
    dependencies = [CoreComponent::class]
)
interface AppComponent {
    fun inject(homeActivity: HomeActivity)
}
