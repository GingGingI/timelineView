package c.gingdev.timelineview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import c.gingdev.timelineview.timeline.adapter.timelineAdapter
import c.gingdev.timelineview.timeline.model.*
import c.gingdev.timelineview.timeline.model.timelineItemModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = timelineAdapter()
        adapter.items.run {
            add(Pair(timelineItemModel(Start, PARENT_BASE, R.layout.timeline_layout_box_mini), 1))
            add(Pair(timelineItemModel(Middle, PARENT_BASE_ONLY_LINE, R.layout.timeline_layout_blank_mini), 1))
            add(Pair(timelineItemModel(Middle, PARENT_BASE, R.layout.timeline_layout_box_mini), 1))
            add(Pair(timelineItemModel(Middle, PARENT_BASE_ONLY_LINE, R.layout.timeline_layout_blank), 1))
            add(Pair(timelineItemModel(Middle, PARENT_BASE, R.layout.timeline_layout_box_mini), 1))
            add(Pair(timelineItemModel(Middle, PARENT_BASE_ONLY_LINE, R.layout.timeline_layout_box_mini), 1))
            add(Pair(timelineItemModel(Middle, PARENT_BASE_ONLY_LINE, R.layout.timeline_layout_blank), 1))
            add(Pair(timelineItemModel(Middle, PARENT_BASE, R.layout.timeline_layout_box_mini), 1))
            add(Pair(timelineItemModel(End, PARENT_BASE, R.layout.timeline_layout_box_mini), 1))
        }

        adapter.notifyDataSetChanged()
        recycler.adapter = adapter
    }
}
