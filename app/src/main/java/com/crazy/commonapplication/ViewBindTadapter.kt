package com.crazy.commonapplication

import com.beyondsoft.smarthome.utils.logs.LogTag
import com.crazy.baseimagegallery.base.ui.adapter.BaseItemBindingAdapter
import com.crazy.commonapplication.databinding.ItemStringBinding

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: ViewBindTadapter
 * Author: zy
 * Date: 2021/11/29 11:26
 * Description: 视图绑定类适配器
 * History:

 */
class ViewBindTadapter(dataSet: MutableList<HashMap<Int, String>>):
    BaseItemBindingAdapter<ItemStringBinding,
            HashMap<Int,String>>(ItemStringBinding::inflate,dataSet) {

    override fun mOnBindViewHolder(vb: ItemStringBinding, position: Int, get: HashMap<Int,String>) {
        vb.tvr.text = get[position]
    }

    fun mNotifyItemRemoved(position: Int) {
        this.mDataSet.removeAt(position)
        notifyItemRemoved(position)
        LogTag.d(""+mDataSet.size)

    }

}

