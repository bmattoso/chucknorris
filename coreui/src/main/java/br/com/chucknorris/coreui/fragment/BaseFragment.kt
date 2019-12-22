package br.com.chucknorris.coreui.fragment

import androidx.fragment.app.Fragment
import br.com.chucknorris.coreui.navigation.Navigation
import javax.inject.Inject

open class BaseFragment : Fragment() {

    private val navigation by lazy { requireActivity() as Navigation }

    fun openFragment(fragment: Fragment) {
        navigation.openFragment(fragment)
    }
}
