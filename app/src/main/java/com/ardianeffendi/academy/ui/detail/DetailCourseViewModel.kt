package com.ardianeffendi.academy.ui.detail

import androidx.lifecycle.ViewModel
import com.ardianeffendi.academy.data.CourseEntity
import com.ardianeffendi.academy.data.ModuleEntity
import com.ardianeffendi.academy.utils.DataDummy

class DetailCourseViewModel : ViewModel() {
    private lateinit var courseId: String

    fun setSelectedCourse(courseId: String) {
        this.courseId = courseId
    }

    fun getCourse(): CourseEntity {
        lateinit var course: CourseEntity
        val courseEntities = DataDummy.generateDummyCourses()
        for (courseEntity in courseEntities) {
            if (courseEntity.courseId == courseId) {
                course = courseEntity
            }
        }
        return course
    }

    fun getModules(): List<ModuleEntity> = DataDummy.generateDummyModules(courseId)
}