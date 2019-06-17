package c.gingdev.timelineview.timeline.model

import androidx.annotation.LayoutRes

data class timelineItemModel(val viewType: Int, @LayoutRes val parentType: Int, @LayoutRes val itemType: Int)