package br.com.chucknorris.joke.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import br.com.chucknorris.coreui.fragment.BaseFragment
import br.com.chucknorris.coreui.fragment.FragmentBinding
import br.com.chucknorris.joke.R
import br.com.chucknorris.joke.databinding.FragmentJokeBinding
import br.com.chucknorris.joke.di.JokeInjector
import javax.inject.Inject

private const val BUNDLE_CATEGORY_KEY = "BUNDLE_CATEGORY_KEY"

class JokeFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory)[JokeViewModel::class.java]
    }
    private val binding by FragmentBinding<FragmentJokeBinding>(this, R.layout.fragment_joke) { binding ->

    }
    private val selectedCategory: String by lazy { arguments?.getString(BUNDLE_CATEGORY_KEY) ?: "" }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        JokeInjector.inject(this)

        viewModel.loadJokeFromCategory(selectedCategory)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return binding.root
    }

    companion object {
        fun newInstance(category: String) = JokeFragment().apply {
            arguments = Bundle().apply {
                putString(BUNDLE_CATEGORY_KEY, category)
            }
        }
    }
}
