package com.crazy.baseimagegallery.base.ui.adapter.listener

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: OnListItemClickListener
 * Author: zy
 * Date: 2021/7/30 10:47
 * Description:
 * History:

 */
interface OnListItemClickListener<T> {
    /**
     * Item点击事件
     *
     * @param data     Data
     * @param position position
     */
    fun onItemClick(data: T?, position: Int)
}