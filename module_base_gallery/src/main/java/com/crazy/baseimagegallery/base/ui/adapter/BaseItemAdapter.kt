package com.crazy.baseimagegallery.base.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.crazy.baseimagegallery.base.ui.adapter.listener.OnClickListener
import com.crazy.baseimagegallery.base.ui.adapter.viewholder.BaseViewHolder

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: BaseItemAdapter
 * Author: zy
 * Date: 2021/11/16 15:40
 * Description: 适配器
 * History: 单列表适配器

 */
abstract class  BaseItemAdapter<T> : RecyclerView.Adapter<BaseViewHolder>() {

    private  lateinit var mOnItemClickListener: OnClickListener.ItemOnClickListener<T>
    private lateinit  var mOnItemLongClickListener: OnClickListener.ItemOnLongClickListener<T>

    /**
     * ID for an XML layout resource to load (e.g.<code>R.layout.main_page</code>)
     */
     open var mLayoutResId:Int = 0

     open lateinit var mDataSet :MutableList<T>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(mLayoutResId, parent, false)
        return BaseViewHolder(view)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val mds = this.mDataSet[position]
        mOnBindViewHolder(holder, position, mds)
        val hi = holder.itemView
        hi.setOnClickListener {
            mOnItemClickListener?.let { it ->
                it.onItem(mds,holder.adapterPosition)
            }
        }
        hi.setOnLongClickListener {

            mOnItemLongClickListener?.let { it ->
                it.onLongItem(mds,holder.adapterPosition)
            }
            return@setOnLongClickListener false
        }


    }

    override fun getItemCount(): Int =this.mDataSet.size

    override fun getItemViewType(position: Int): Int = mLayoutResId

    abstract fun mOnBindViewHolder(holder: BaseViewHolder, position: Int, get: T)

    open fun setOnItemClickListener(onItemClickListener: OnClickListener.ItemOnClickListener<T>) {
        this.mOnItemClickListener = onItemClickListener
    }

    open fun setOnItemLongClickListener(onItemLongClickListener: OnClickListener.ItemOnLongClickListener<T>) {
        this.mOnItemLongClickListener = onItemLongClickListener
    }
}