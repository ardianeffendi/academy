package com.ardianeffendi.academy.ui.bookmark

import android.os.Bundle
import android.view.View
import androidx.core.app.ShareCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.ardianeffendi.academy.BaseFragment
import com.ardianeffendi.academy.R
import com.ardianeffendi.academy.data.CourseEntity
import com.ardianeffendi.academy.databinding.FragmentBookmarkBinding
import com.ardianeffendi.academy.utils.DataDummy

class BookmarkFragment : BaseFragment<FragmentBookmarkBinding, BookmarkViewModel>(),
    BookmarkFragmentCallback {

    override var useSharedVModel = false

    override fun getViewBinding(): FragmentBookmarkBinding =
        FragmentBookmarkBinding.inflate(layoutInflater)

    override fun getViewModelClass(): Class<BookmarkViewModel> = BookmarkViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val courses = viewModel.getBookmarks()
            val adapter = BookmarkAdapter(this)
            adapter.setCourses(courses)

            with((binding as FragmentBookmarkBinding).rvBookmark) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = adapter
            }
        }
    }

    override fun onShareClick(course: CourseEntity) {
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(requireActivity())
                .setType(mimeType)
                .setChooserTitle("Bagikan aplikasi ini sekarang.")
                .setText(resources.getString(R.string.share_text, course.title))
                .startChooser()
        }
    }

}