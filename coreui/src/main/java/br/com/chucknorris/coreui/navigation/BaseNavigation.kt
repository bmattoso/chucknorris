package br.com.chucknorris.coreui.navigation

import androidx.fragment.app.Fragment

interface BaseNavigation {
    val fragmentNavigation: FragmentNavigation

    fun openFragment(fragment: Fragment)
}
