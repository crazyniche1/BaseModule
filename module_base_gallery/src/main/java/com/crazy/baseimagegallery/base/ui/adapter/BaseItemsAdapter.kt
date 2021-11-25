package com.crazy.baseimagegallery.base.ui.adapter

import android.widget.TextView
import com.crazy.baseimagegallery.base.ui.adapter.items.Visitable
import com.crazy.baseimagegallery.base.ui.adapter.viewholder.BaseViewHolder

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: BaseItemAdapter
 * Author: zy
 * Date: 2021/11/16 15:40
 * Description: 多列表适配器
 * ps:https://www.jianshu.com/p/1297d2e4d27a 可参考 这个 ，需要重写单列表适配器，逻辑完全变样；
 * History:

 */
abstract class  BaseItemsAdapter<T> ( dataSet:MutableList<T>) : BaseItemAdapter<T>() {

    init {

        mDataSet = dataSet

    }
    override fun getItemViewType(position: Int): Int = mLayoutResId
}