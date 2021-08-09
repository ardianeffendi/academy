package com.ardianeffendi.academy.ui.reader.list

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.ardianeffendi.academy.BaseFragment
import com.ardianeffendi.academy.data.ModuleEntity
import com.ardianeffendi.academy.databinding.FragmentModuleListBinding
import com.ardianeffendi.academy.ui.reader.CourseReaderActivity
import com.ardianeffendi.academy.ui.reader.CourseReaderCallback
import com.ardianeffendi.academy.ui.reader.CourseReaderViewModel
import com.ardianeffendi.academy.utils.DataDummy

class ModuleListFragment : BaseFragment<FragmentModuleListBinding, CourseReaderViewModel>(),
    MyAdapterClickListener {

    private lateinit var adapter: ModuleListAdapter
    private lateinit var courseReaderCallback: CourseReaderCallback

    companion object {
        val TAG: String = ModuleListFragment::class.java.simpleName
        fun newInstance(): ModuleListFragment = ModuleListFragment()
    }

    override var useSharedVModel = true

    override fun getViewBinding(): FragmentModuleListBinding =
        FragmentModuleListBinding.inflate(layoutInflater)

    override fun getViewModelClass(): Class<CourseReaderViewModel> =
        CourseReaderViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ModuleListAdapter(this)
        populateRecyclerView(viewModel.getModules())
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        courseReaderCallback = context as CourseReaderActivity
    }

    override fun onItemClicked(position: Int, moduleId: String) {
        courseReaderCallback.moveTo(position, moduleId)
        viewModel.setSelectedModule(moduleId)
    }

    private fun populateRecyclerView(modules: List<ModuleEntity>) {
        with((binding as FragmentModuleListBinding)) {
            progressBar.visibility = View.GONE
            adapter.setModules(modules)
            rvModule.layoutManager = LinearLayoutManager(context)
            rvModule.setHasFixedSize(true)
            rvModule.adapter = adapter
            val dividerItemDecoration = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
            rvModule.addItemDecoration(dividerItemDecoration)
        }
    }
}