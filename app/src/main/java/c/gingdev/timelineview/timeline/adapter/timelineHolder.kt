package c.gingdev.timelineview.timeline.adapter

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewStub
import android.widget.ImageView
import android.widget.TextView
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

    fun bind(@LayoutRes itemResource: Int, viewType: Int, items: Int) {
//        Put Item into itemView
        this.viewType = viewType
        itemView.run {
            val view = findViewById<ViewStub>(R.id.timelineItemView)
            view.layoutResource = itemResource
            item = view.inflate() }

        boxLayout(getRandomColor(), items)
//        Set Layout As ParentType
        when (parentType) {
            R.layout.timeline_base -> {
                setViewType()
//
//                when(itemResource) {
//                    R.layout.timeline_layout_box_mini -> {  }
//                }
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

    private fun boxLayout(color: Int, items: Int){
        when(items) {

            1 -> {
                itemView.findViewById<TextView>(R.id.timelineContent).text = "출발지 : 집"
            }
            2 -> {
                itemView.findViewById<TextView>(R.id.timelineTitle).text = "탑승"
                itemView.findViewById<TextView>(R.id.timelineContent).text = "약 3분 소요"
            }
            3 -> {
                val innerCircle = itemView.findViewById<View>(R.id.innerCircle)
                innerCircle.backgroundTintList = ColorStateList.valueOf(context.resources.getColor(R.color.Bus_Maul))
                itemView.findViewById<ImageView>(R.id.timelineIcon).setImageDrawable(context.resources.getDrawable(R.drawable.ic_bus))
                itemView.findViewById<TextView>(R.id.timelineTitle).text = "녹사평역"
                itemView.findViewById<TextView>(R.id.timelineContent).text = "4분 32초."
            }
            4 -> {
                itemView.findViewById<TextView>(R.id.timelineTitle).text = "환승"
                itemView.findViewById<TextView>(R.id.timelineContent).text = "약 4분 소요"
            }
            5 -> {
                val innerCircle = itemView.findViewById<View>(R.id.innerCircle)
                innerCircle.backgroundTintList = ColorStateList.valueOf(context.resources.getColor(R.color.Subway_4))
                itemView.findViewById<ImageView>(R.id.timelineIcon).setImageDrawable(context.resources.getDrawable(R.drawable.ic_subway))
                itemView.findViewById<TextView>(R.id.timelineTitle).text = "삼각지역"
                itemView.findViewById<TextView>(R.id.timelineContent).text = "1분 27초."
            }
            8 -> {
                val innerCircle = itemView.findViewById<View>(R.id.innerCircle)
                innerCircle.backgroundTintList = ColorStateList.valueOf(context.resources.getColor(R.color.Subway_1))
                itemView.findViewById<ImageView>(R.id.timelineIcon).setImageDrawable(context.resources.getDrawable(R.drawable.ic_subway))
                itemView.findViewById<TextView>(R.id.timelineTitle).text = "동대문역"
                itemView.findViewById<TextView>(R.id.timelineContent).text = "3분 12초."
            }
            9 -> {
                itemView.findViewById<ImageView>(R.id.timelineIcon).setImageDrawable(context.resources.getDrawable(R.drawable.ic_walk))
                itemView.findViewById<TextView>(R.id.timelineTitle).text = "도착"
                itemView.findViewById<TextView>(R.id.timelineContent).text = "종각역"
            }
        }
    }
}