package br.com.chucknorris.initializer

import br.com.chucknorris.application.ChuckNorrisApplication
import br.com.chucknorris.coreui.di.CoreModule
import br.com.chucknorris.coreui.di.DaggerCoreComponent

class DaggerInitializer : LibraryInitializer {

    override fun init(chuckNorrisApplication: ChuckNorrisApplication) {
        chuckNorrisApplication.coreComponent = DaggerCoreComponent
            .builder()
            .coreModule(CoreModule(chuckNorrisApplication))
            .build()
    }
}
