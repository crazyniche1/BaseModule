package com.crazy.baseimagegallery.base.ui.adapter.listener

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: OnClickListener
 * Author: zy
 * Date: 2021/11/17 11:19
 * Description: 适配器的监听
 * History:

 */
interface OnClickListener {

    interface ItemOnClickListener<T> {
        fun onItem(t: T, position: Int)
    }

    interface ItemOnLongClickListener<T> {
        fun onLongItem(t: T, position: Int):Boolean
    }
}