package com.crazy.commonapplication

import android.widget.Button
import android.widget.TextView
import com.beyondsoft.smarthome.utils.logs.LogTag
import com.crazy.baseimagegallery.base.ui.adapter.BaseItemAdapter
import com.crazy.baseimagegallery.base.ui.adapter.BaseItemsAdapter
import com.crazy.baseimagegallery.base.ui.adapter.viewholder.BaseViewHolder

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: Tadapter
 * Author: zy
 * Date: 2021/11/17 9:47
 * Description: 測試多列表适配器
 * History:

 */
class Tadapter1( private val mLayoutResIdList:List<Int>, dataSet:MutableList<HashMap<Int,String>>) :
    BaseItemsAdapter<HashMap<Int, String>>(dataSet){

    override fun mOnBindViewHolder(holder: BaseViewHolder, position: Int, get: HashMap<Int,String>) {
        LogTag.d(this.javaClass.name +"${(position%2)}" )

        if (mLayoutResId==mLayoutResIdList[0]){
            val mtv = holder.findViewById<TextView>(R.id.tvr)
            val mbt = holder.findViewById<Button>(R.id.bt)
            mtv?.text = get[position].toString()
            mbt?.setOnClickListener {
            }
            return
        }
        val mtv = holder.findViewById<TextView>(R.id.tvl)
        val mbt = holder.findViewById<Button>(R.id.bt)
        mbt?.setOnClickListener {
        }
        mtv?.text = get[position].toString()
    }

    override fun getItemViewType(position: Int): Int {
         mLayoutResId = if (position%2 ==0){
            mLayoutResIdList[0]
        }else{
            mLayoutResIdList[1]
        }
        return mLayoutResId
    }

}
