package br.com.chucknorris.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import br.com.chucknorris.R
import br.com.chucknorris.coreui.navigation.FragmentNavigation
import br.com.chucknorris.coreui.navigation.Navigation
import br.com.chucknorris.home.di.HomeInjector
import javax.inject.Inject

class HomeActivity : AppCompatActivity(), Navigation {

    @Inject
    lateinit var fragmentNavigation: FragmentNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        HomeInjector.inject(this)
        setContentView(R.layout.activity_main)
        openInitialFragment()
    }

    private fun openInitialFragment() {
        val categoryFragment = fragmentNavigation.getCategoryFragment()
        categoryFragment?.let {
            openFragment(categoryFragment)
        }
    }

    override fun openFragment(fragment: Fragment) {
        supportFragmentManager.commit(allowStateLoss = true) {
            replace(R.id.containter, fragment, fragment.tag)
        }
    }
}
