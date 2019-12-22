package br.com.chucknorris.category.presentation

import br.com.chucknorris.category.di.DaggerCategoryComponent
import br.com.chucknorris.coreui.di.CoreComponentProvider

object CategoryInjector {
    fun inject(categoryFragment: CategoryFragment) {
        val coreComponentProvider = categoryFragment.requireActivity().application as CoreComponentProvider

        DaggerCategoryComponent.builder()
            .coreComponent(coreComponentProvider.coreComponent)
            .categoryFragment(categoryFragment)
            .build()
            .inject(categoryFragment)
    }
}
