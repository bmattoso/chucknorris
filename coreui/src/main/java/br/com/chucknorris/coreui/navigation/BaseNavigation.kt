package br.com.chucknorris.coreui.navigation

import android.content.Intent
import androidx.fragment.app.Fragment

interface BaseNavigation {
    val fragmentNavigation: FragmentNavigation

    fun openFragment(fragment: Fragment)
    fun openIntent(intent: Intent)
}
