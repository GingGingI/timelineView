package c.gingdev.timelineview.timeline.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import c.gingdev.timelineview.timeline.model.timelineItemModel

class timelineAdapter
    : RecyclerView.Adapter<timelineHolder>() {

    val items = ArrayList<Pair<timelineItemModel, Int>>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): timelineHolder
        = timelineHolder(
        parent = parent,
        parentType = viewType)

    override fun getItemViewType(position: Int): Int
        = items[position].first.parentType

    override fun getItemCount(): Int
        = items.size

    override fun onBindViewHolder(holder: timelineHolder, position: Int) {
        holder.bind(items[position].first.itemType, items[position].first.viewType)
    }
}