package br.com.chucknorris.coreui.fragment

import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class FragmentBinding<T : ViewDataBinding>(
    private val fragment: Fragment,
    @LayoutRes private val resId: Int,
    private val initializer: (T) -> Unit = {}
) : ReadOnlyProperty<Any?, T> {

    private lateinit var binding: T

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        if (!::binding.isInitialized) {
            binding = DataBindingUtil.inflate<T>(fragment.layoutInflater, resId, null, false).apply {
                lifecycleOwner = fragment.viewLifecycleOwner
                initializer(this)
            }
        }
        return binding
    }
}
