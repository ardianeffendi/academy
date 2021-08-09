package com.ardianeffendi.academy.ui.academy

import androidx.lifecycle.ViewModel
import com.ardianeffendi.academy.data.CourseEntity
import com.ardianeffendi.academy.utils.DataDummy

class AcademyViewModel : ViewModel() {

    fun getCourses(): List<CourseEntity> = DataDummy.generateDummyCourses()
}