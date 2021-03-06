package com.crazy.baseimagegallery.template

import android.widget.Button
import com.crazy.baseimagegallery.base.ui.adapter.BaseItemAdapter
import com.crazy.baseimagegallery.base.ui.adapter.viewholder.BaseViewHolder

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: Tadapter
 * Author: zy
 * Date: 2021/11/17 9:47
 * Description: 測試
 * History:
 * e.g.
 *  viewBing.rv.layoutManager = GridLayoutManager(this,3)
var dataSet = mutableListOf<HashMap<Int,String>>()
for (i  in  0..10){
val map = HashMap<Int,String>()
map[i] = "nihaoya$i"
dataSet.add(i,map)
}
val mdt = Tadapter(R.layout.item_string,dataSet)
viewBing.rv.adapter = mdt

mdt.setOnClickListener(object :Tadapter.BtItemOnClickListener<HashMap<Int,String>>{
override fun onBtItem(t: HashMap<Int, String>, position: Int) {
Toast.makeText(this@MainActivity,"bottun",Toast.LENGTH_SHORT).show()
}
})

mdt.setOnItemClickListener(object :OnClickListener.ItemOnClickListener<HashMap<Int, String>>{
override fun onItem(t: HashMap<Int, String>, position: Int) {
Toast.makeText(this@MainActivity,""+t[position],Toast.LENGTH_SHORT).show()
}

})
 *

 */
class Tadapter(  layoutResId:Int,  dataSet:MutableList<HashMap<Int,String>>) :
    BaseItemAdapter<HashMap<Int, String>>(){

    private var mbt: Button? = null
    private var mItemOnClickListener: BtItemOnClickListener<HashMap<Int,String>>?=null

    init {
        mLayoutResId = layoutResId
        mDataSet = dataSet
    }

    override fun mOnBindViewHolder(holder: BaseViewHolder, position: Int, get: HashMap<Int,String>) {
//        val mtv = holder.findViewById<TextView>(R.id.tvx)
//         mbt = holder.findViewById<Button>(R.id.bt)
//        mtv?.text = get[position].toString()
//
//        mbt?.setOnClickListener {
//            mItemOnClickListener?.onBtItem(get,position)
//        }
    }

    fun setOnClickListener(ItemOnClickListener: BtItemOnClickListener<HashMap<Int,String>>) {
        mItemOnClickListener = ItemOnClickListener
    }


    interface BtItemOnClickListener<T>{
        fun onBtItem(t: T, position: Int)
    }

}
