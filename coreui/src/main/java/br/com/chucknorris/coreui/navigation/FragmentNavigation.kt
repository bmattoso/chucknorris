package br.com.chucknorris.coreui.navigation

import androidx.fragment.app.Fragment
import javax.inject.Inject

class FragmentNavigation @Inject constructor() {

    fun getCategoryFragment(): Fragment? {
        return try {
            Class.forName(FragmentPath.Category.name).newInstance() as? Fragment
        } catch (e: ClassNotFoundException) {
            null
        }
    }
}
