package br.com.chucknorris.coreui.di

import android.app.Application
import android.content.Context
import br.com.chucknorris.coreui.scheduler.SchedulerProvider
import br.com.chucknorris.coreui.scheduler.SchedulerProviderImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CoreModule(private val chuckNorrisApplication: Application) {

    @Singleton
    @Provides
    fun provideContext(): Context = chuckNorrisApplication

    @Singleton
    @Provides
    fun provideSchedulerProvider(schedulerProvider: SchedulerProviderImpl): SchedulerProvider = schedulerProvider
}
