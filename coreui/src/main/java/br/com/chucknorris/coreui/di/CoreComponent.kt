package br.com.chucknorris.coreui.di

import android.content.Context
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        CoreModule::class,
        ViewModelModule::class
    ]
)
interface CoreComponent {
    fun context(): Context
}
