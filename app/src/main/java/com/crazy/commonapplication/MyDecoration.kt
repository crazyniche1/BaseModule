package com.crazy.commonapplication

import android.graphics.Canvas
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: MyDecoration
 * Author: zy
 * Date: 2021/11/29 16:58
 * Description: test
 * History:

 */
class MyDecoration : ItemDecoration() {

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        //设置rect  通过填充边界margin 或padding 方式  对比recycle 背景和item 背景，通过偏移量 呈现出虚线效果
        outRect.set(0,0,0,2)
//        super.getItemOffsets(outRect, view, parent, state)
    }
}