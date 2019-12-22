package br.com.chucknorris.home.di

import br.com.chucknorris.coreui.di.CoreComponentProvider
import br.com.chucknorris.home.HomeActivity

object HomeInjector {

    fun inject(homeActivity: HomeActivity) {
        val coreComponentProvider = homeActivity.application as CoreComponentProvider
        DaggerHomeComponent.builder()
            .coreComponent(coreComponentProvider.coreComponent)
            .build()
            .inject(homeActivity)
    }
}
