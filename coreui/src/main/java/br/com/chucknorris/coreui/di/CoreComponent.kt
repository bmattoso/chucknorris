package br.com.chucknorris.coreui.di

import android.content.Context
import br.com.chucknorris.coreui.di.network.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        CoreModule::class,
        NetworkModule::class
    ]
)
interface CoreComponent {
    fun context(): Context
}
