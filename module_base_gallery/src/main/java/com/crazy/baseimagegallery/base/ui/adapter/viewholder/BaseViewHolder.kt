package com.crazy.baseimagegallery.base.ui.adapter.viewholder

import android.util.SparseArray
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: BaseViewHolder
 * Author: zy
 * Date: 2021/11/16 15:56
 * Description: 持有者
 * History:

 */
 class BaseViewHolder(mItemView: View) : RecyclerView.ViewHolder(mItemView) {
    private val childViews = SparseArray<View>()

    fun <T : View?> findViewById(id: Int): T? {
        var childView = childViews[id]
        if (childView == null) {
            childView = itemView.findViewById(id)
            if (childView != null) childViews.put(id, childView) else return null
        }
        return childView as T
    }

}