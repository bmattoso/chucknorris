package br.com.chucknorris.coreui.navigation

import br.com.chucknorris.model.Category

interface FragmentNavigation {
    fun openCategoryFragment()
    fun openRandomJokeFragment(category: Category)
}
