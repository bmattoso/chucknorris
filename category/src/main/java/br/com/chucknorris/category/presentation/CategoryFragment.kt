package br.com.chucknorris.category.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import br.com.chucknorris.category.R
import br.com.chucknorris.category.databinding.FragmentCategoryBinding
import br.com.chucknorris.coreui.fragment.BaseFragment
import br.com.chucknorris.coreui.fragment.FragmentBinding
import javax.inject.Inject

class CategoryFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory)[CategoryViewModel::class.java]
    }
    private val binding by FragmentBinding<FragmentCategoryBinding>(this, R.layout.fragment_category)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CategoryInjector.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        viewModel.loadCategories()

        return binding.root
    }

    companion object {
        fun newInstance() = CategoryFragment()
    }
}
