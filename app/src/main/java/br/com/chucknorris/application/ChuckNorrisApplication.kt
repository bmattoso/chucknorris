package br.com.chucknorris.application

import android.app.Application
import br.com.chucknorris.coreui.di.CoreComponent
import br.com.chucknorris.coreui.di.CoreComponentProvider
import br.com.chucknorris.initializer.DaggerInitializer
import br.com.chucknorris.initializer.LibraryInitializer

class ChuckNorrisApplication : Application(), CoreComponentProvider {

    override lateinit var coreComponent: CoreComponent

    private val libraries = listOf<LibraryInitializer>(
        DaggerInitializer()
    )

    override fun onCreate() {
        super.onCreate()

        libraries.forEach { library -> library.init(this) }
    }
}
