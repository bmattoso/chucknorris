package br.com.chucknorris.coreui.fragment

import androidx.fragment.app.Fragment
import br.com.chucknorris.coreui.navigation.FragmentNavigation
import javax.inject.Inject

open class BaseFragment : Fragment() {

    @Inject
    lateinit var navigation: FragmentNavigation
}
