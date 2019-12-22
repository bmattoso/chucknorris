package br.com.chucknorris.initializer

import br.com.chucknorris.application.ChuckNorrisApplication

interface LibraryInitializer {
    fun init(chuckNorrisApplication: ChuckNorrisApplication)
}
