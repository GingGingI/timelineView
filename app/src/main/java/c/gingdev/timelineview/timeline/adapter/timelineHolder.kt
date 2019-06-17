package c.gingdev.timelineview.timeline.adapter

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewStub
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import c.gingdev.timelineview.R
import c.gingdev.timelineview.timeline.model.*
import kotlinx.android.synthetic.main.timeline_base.view.*

class timelineHolder(
    @LayoutRes val parentType: Int,
    val parent: ViewGroup): RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(parentType, parent, false)) {
    private val context = parent.context
    private lateinit var item : View
    private var viewType: Int = -1

    fun bind(@LayoutRes itemResource: Int, viewType: Int) {
//        Put Item into itemView
        this.viewType = viewType
        itemView.run {
            val view = findViewById<ViewStub>(R.id.timelineItemView)
            view.layoutResource = itemResource
            item = view.inflate() }

//        Set Layout As ParentType
        when (parentType) {
            R.layout.timeline_base -> {
                setViewType()

                when(itemResource) {
                    R.layout.timeline_layout_box_mini -> { boxLayout(getRandomColor()) }
                }
            }
            R.layout.timeline_base_only_line -> {
//                NoThing?
            }
        }
    }

//    TestColorGenerator
    private fun getRandomColor(): Int
        = when((0 until 4).random()) {
            1 -> { R.color.colorAccent }
            2 -> { R.color.colorPrimary }
            3 -> { R.color.colorPrimaryDark }
            else -> { R.color.colorNone }
        }


    //    Base일시 좌측 라인 조정.
    private fun setViewType() {
        when (viewType) {
            Start -> { itemView.timelineTopLine.visibility = View.GONE }
            End -> { itemView.timelineBottomLine.visibility = View.GONE }
        }
    }

    private fun boxLayout(color: Int){
        val innerCircle = itemView.findViewById<View>(R.id.innerCircle)
        innerCircle.backgroundTintList = ColorStateList.valueOf(context.resources.getColor(color))
    }
}