package com.ardianeffendi.academy.ui.reader.content

import android.os.Bundle
import android.view.View
import com.ardianeffendi.academy.BaseFragment
import com.ardianeffendi.academy.data.ContentEntity
import com.ardianeffendi.academy.data.ModuleEntity
import com.ardianeffendi.academy.databinding.FragmentModuleContentBinding
import com.ardianeffendi.academy.ui.reader.CourseReaderViewModel

class ModuleContentFragment : BaseFragment<FragmentModuleContentBinding, CourseReaderViewModel>() {

    companion object {
        val TAG: String = ModuleContentFragment::class.java.simpleName
        fun newInstance(): ModuleContentFragment = ModuleContentFragment()
    }

    override var useSharedVModel = true

    override fun getViewBinding(): FragmentModuleContentBinding =
        FragmentModuleContentBinding.inflate(layoutInflater)

    override fun getViewModelClass(): Class<CourseReaderViewModel> =
        CourseReaderViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val module = viewModel.getSelectedModule()
            populateWebView(module)
        }
    }

    private fun populateWebView(module: ModuleEntity) {
        binding?.webView?.loadData(module.contentEntity?.content ?: "", "text/html", "UTF-8")
    }

}