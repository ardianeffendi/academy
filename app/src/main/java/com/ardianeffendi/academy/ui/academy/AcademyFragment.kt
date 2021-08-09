package com.ardianeffendi.academy.ui.academy

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.ardianeffendi.academy.BaseFragment
import com.ardianeffendi.academy.databinding.FragmentAcademyBinding

class AcademyFragment : BaseFragment<FragmentAcademyBinding, AcademyViewModel>() {

    override var useSharedVModel = false

    override fun getViewBinding(): FragmentAcademyBinding =
        FragmentAcademyBinding.inflate(layoutInflater)

    override fun getViewModelClass(): Class<AcademyViewModel> = AcademyViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val courses = viewModel.getCourses()
        val academyAdapter = AcademyAdapter()
        academyAdapter.setCourses(courses)

        with((binding as FragmentAcademyBinding).rvAcademy) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = academyAdapter
        }
    }
}