package br.com.chucknorris.coreui.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CoreModule(private val chuckNorrisApplication: Application) {

    @Singleton
    @Provides
    fun provideContext(): Context = chuckNorrisApplication
}
