package com.ardianeffendi.academy.ui.bookmark

import com.ardianeffendi.academy.data.CourseEntity

interface BookmarkFragmentCallback {
    fun onShareClick(course: CourseEntity)
}
