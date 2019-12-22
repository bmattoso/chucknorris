package br.com.chucknorris.home.di

import br.com.chucknorris.coreui.di.CoreComponent
import br.com.chucknorris.coreui.di.scope.ActivityScope
import br.com.chucknorris.home.HomeActivity
import dagger.Component

@Component(
    modules = [HomeModule::class],
    dependencies = [CoreComponent::class]
)
@ActivityScope
interface HomeComponent {
    fun inject(homeActivity: HomeActivity)
}
