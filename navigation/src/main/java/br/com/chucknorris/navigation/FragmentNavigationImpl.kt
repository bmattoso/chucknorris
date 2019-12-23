package br.com.chucknorris.navigation

import br.com.chucknorris.category.presentation.CategoryFragment
import br.com.chucknorris.coreui.navigation.BaseNavigation
import br.com.chucknorris.coreui.navigation.FragmentNavigation
import javax.inject.Inject

class FragmentNavigationImpl @Inject constructor(
    private val baseNavigation: BaseNavigation
) : FragmentNavigation {

    override fun openCategoryFragment() {
        val fragment = CategoryFragment.newInstance()
        baseNavigation.openFragment(fragment)
    }
}