package com.ardianeffendi.academy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VBinding : ViewBinding, VModel : ViewModel> : Fragment() {

    open var useSharedVModel: Boolean = false

    protected var binding: VBinding? = null
    protected abstract fun getViewBinding(): VBinding

    protected lateinit var viewModel: VModel
    protected abstract fun getViewModelClass(): Class<VModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding?.root
    }

    private fun init() {
        binding = getViewBinding()
        viewModel = if (useSharedVModel) {
            ViewModelProvider(
                requireActivity(),
                ViewModelProvider.NewInstanceFactory()
            )
                .get(getViewModelClass())
        } else {
            ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
            ).get(getViewModelClass())
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}