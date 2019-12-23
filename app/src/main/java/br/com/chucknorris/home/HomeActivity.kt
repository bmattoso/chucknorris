package br.com.chucknorris.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import br.com.chucknorris.R
import br.com.chucknorris.coreui.navigation.BaseNavigation
import br.com.chucknorris.coreui.navigation.FragmentNavigation
import br.com.chucknorris.navigation.FragmentNavigationImpl

class HomeActivity : AppCompatActivity(), BaseNavigation {

    override val fragmentNavigation: FragmentNavigation = FragmentNavigationImpl(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        openInitialFragment()
    }

    private fun openInitialFragment() {
        fragmentNavigation.openCategoryFragment()
    }

    override fun openFragment(
        fragment: Fragment,
        addToBackStack: Boolean
    ) {
        supportFragmentManager.commit(allowStateLoss = true) {
            replace(R.id.containter, fragment, fragment.tag)
            if (addToBackStack) {
                addToBackStack(fragment.tag)
            }
        }
    }

    override fun openIntent(intent: Intent) {
        startActivity(intent)
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount <= 1) {
            super.onBackPressed()
        } else {
            supportFragmentManager.popBackStack()
        }
    }
}
