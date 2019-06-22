package c.gingdev.timelineview

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import c.gingdev.timelineview.timeline.adapter.timelineAdapter
import c.gingdev.timelineview.timeline.model.*
import c.gingdev.timelineview.timeline.model.timelineItemModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        flagInit()

        val adapter = timelineAdapter()
        adapter.items.run {
            add(Pair(timelineItemModel(Start, PARENT_BASE, R.layout.timeline_layout_box_mini), 1))
            add(Pair(timelineItemModel(Middle, PARENT_BASE_ONLY_LINE, R.layout.timeline_layout_blank_mini), 2))
            add(Pair(timelineItemModel(Middle, PARENT_BASE, R.layout.timeline_layout_box_mini), 3))
            add(Pair(timelineItemModel(Middle, PARENT_BASE_ONLY_LINE, R.layout.timeline_layout_blank_mini), 4))
            add(Pair(timelineItemModel(Middle, PARENT_BASE, R.layout.timeline_layout_box_mini), 5))
//            add(Pair(timelineItemModel(Middle, PARENT_BASE_ONLY_LINE, R.layout.timeline_layout_box_mini), 6))
            add(Pair(timelineItemModel(Middle, PARENT_BASE_ONLY_LINE, R.layout.timeline_layout_blank), 7))
            add(Pair(timelineItemModel(Middle, PARENT_BASE, R.layout.timeline_layout_box_mini), 8))
            add(Pair(timelineItemModel(End, PARENT_BASE, R.layout.timeline_layout_box_mini), 9))
        }

        adapter.notifyDataSetChanged()
        recycler.adapter = adapter
    }

    @SuppressLint("NewApi")
    private fun flagInit() {
        window.run {
            decorView.systemUiVisibility = (
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                            View.SYSTEM_UI_FLAG_FULLSCREEN)

            setFlags(
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) setShowWhenLocked(true)
            else addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED)
        }
    }
}
