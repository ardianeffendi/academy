package com.ardianeffendi.academy.ui.bookmark

import androidx.lifecycle.ViewModel
import com.ardianeffendi.academy.data.CourseEntity
import com.ardianeffendi.academy.utils.DataDummy

class BookmarkViewModel : ViewModel() {

    fun getBookmarks(): List<CourseEntity> = DataDummy.generateDummyCourses()

}
