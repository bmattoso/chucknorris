package br.com.chucknorris.coreui.navigation

interface FragmentNavigation {
    fun openCategoryFragment()
    fun openRandomJokeFragment(category: String)
}
