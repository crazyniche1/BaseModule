package com.crazy.baseimagegallery.template

import com.crazy.baseimagegallery.base.ui.adapter.BaseItemBindingAdapter
import com.crazy.baseimagegallery.databinding.ItemBinding


/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: ViewBindTadapter
 * Author: zy
 * Date: 2021/11/29 11:26
 * Description: 视图绑定类适配器
 * History:

 */
class ViewBindTadapter (dataSet:MutableList<HashMap<Int,String>>):
    BaseItemBindingAdapter<ItemBinding,
            HashMap<Int, String>>(ItemBinding::inflate,dataSet){

    override fun mOnBindViewHolder(vb: ItemBinding, position: Int, get: HashMap<Int,String>) {
        vb.tvr.text = position.toString()
    }
}

