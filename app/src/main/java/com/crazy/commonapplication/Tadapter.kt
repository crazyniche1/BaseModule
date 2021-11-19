package com.crazy.commonapplication

import android.widget.Button
import android.widget.TextView
import com.crazy.baseimagegallery.base.ui.adapter.BaseAdapter
import com.crazy.baseimagegallery.base.ui.adapter.BaseViewHolder

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: Tadapter
 * Author: zy
 * Date: 2021/11/17 9:47
 * Description: 測試
 * History:

 */
class Tadapter(  layoutResId:Int,  dataSet:MutableList<HashMap<Int,String>>) :
    BaseAdapter<HashMap<Int, String>>(){

    private var mbt: Button? = null
    private var mItemOnClickListener: BtItemOnClickListener<HashMap<Int,String>>?=null

    init {
        mLayoutResId = layoutResId
        mDataSet = dataSet
    }

    override fun mOnBindViewHolder(holder: BaseViewHolder, position: Int, get: HashMap<Int,String>) {
        val mtv = holder.findViewById<TextView>(R.id.tvx)
         mbt = holder.findViewById<Button>(R.id.bt)
        mtv?.text = get[position].toString()

        mbt?.setOnClickListener {
            mItemOnClickListener?.onBtItem(get,position)
        }
    }

    fun setOnClickListener(ItemOnClickListener: BtItemOnClickListener<HashMap<Int,String>>) {
        mItemOnClickListener = ItemOnClickListener
    }


    interface BtItemOnClickListener<T>{
        fun onBtItem(t: T, position: Int)
    }

}
