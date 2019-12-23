package br.com.chucknorris.coreui.di

import android.content.Context
import br.com.chucknorris.core.NetworkAvailability
import br.com.chucknorris.coreui.di.network.NetworkModule
import br.com.chucknorris.coreui.scheduler.SchedulerProvider
import dagger.Component
import javax.inject.Singleton
import retrofit2.Retrofit

@Singleton
@Component(
    modules = [
        CoreModule::class,
        NetworkModule::class
    ]
)
interface CoreComponent {
    fun context(): Context
    fun schedulerProvider(): SchedulerProvider
    fun networkAvailability(): NetworkAvailability
    fun retrofit(): Retrofit
}
