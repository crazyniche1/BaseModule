package com.crazy.baseimagegallery.base.ui.adapter.viewholder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: BaseViewHolder
 * Author: zy
 * Date: 2021/11/16 15:56
 * Description: 持有者
 * History:

 */
 class BaseViewBindHolder<T:ViewBinding> private constructor(val mItemView: T) : RecyclerView.ViewHolder(mItemView.root) {

    constructor(
        parent: ViewGroup,
        creator: (inflater: LayoutInflater, root: ViewGroup, attachToRoot: Boolean) -> T
    ) : this(creator(LayoutInflater.from(parent.context), parent, false))

}