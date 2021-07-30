package com.crazy.baseimagegallery.base.ui.adapter

import android.content.Context
import com.crazy.baseimagegallery.base.ui.adapter.listener.OnListItemClickListener
import org.byteam.superadapter.IMulItemViewType
import org.byteam.superadapter.SuperAdapter
import org.byteam.superadapter.SuperViewHolder


/**
* Copyright (C), 2015-2021, 博彦科技
* FileName: BaseListAdapter
* Author: zy
* Date: 2021/7/29 17:58
* Description: 万能适配器
* History:
 
*/
abstract class BaseListAdapter<T> : SuperAdapter<T>{

    /**
     * Item点击监听
     */
    private var listener: OnListItemClickListener<T>? = null


    /**
     * 常规列表重写该方法
     *
     * @param context     context
     * @param items       数据源
     * @param mulItemViewType 多布局类型
     */

    constructor(
        context: Context?,
        items: MutableList<T>?,
        mulItemViewType: IMulItemViewType<T>?
    ) : super(context, items, mulItemViewType){
    }

    /**
     * 多布局列表重写该方法
     *
     * @param context           context
     * @param mData             数据源
     * @param layoutResId      布局文件
     */

    constructor(
        context: Context?,
        mData: MutableList<T>?,
        layoutResId: Int
    ) : super(context, mData, layoutResId)

    /**
     * Item点击事件
     *
     * @param listener listener
     */

    fun setOnListItemClickListener(listener :OnListItemClickListener<T> ) {
        this.listener = listener
    }

    override fun onBind(holder: SuperViewHolder?, viewType: Int, layoutPosition: Int, item: T) {

        holder?.itemView?.setOnClickListener {
            if (listener != null) {
                listener!!.onItemClick(item, layoutPosition)
            } }
        holder?.let { onBindData(it,viewType,layoutPosition,item) }
    }

    abstract fun onBindData(holder: SuperViewHolder, viewType: Int, layoutPosition: Int, data: T)
}