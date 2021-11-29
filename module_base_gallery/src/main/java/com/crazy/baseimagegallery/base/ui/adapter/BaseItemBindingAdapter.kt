package com.crazy.baseimagegallery.base.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.crazy.baseimagegallery.base.ui.adapter.viewholder.BaseViewBindHolder
import com.crazy.baseimagegallery.base.ui.adapter.viewholder.BaseViewHolder

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: BaseItemBindingAdapter
 * Author: zy
 * Date: 2021/11/26 17:31
 * Description: 视图绑定 (@link:https://www.jianshu.com/p/b5ab750216a0)
 * History:

 */
abstract class BaseItemBindingAdapter<VB:ViewBinding,T>
    (val mCreator: (inflater: LayoutInflater, root: ViewGroup, attachToRoot: Boolean) -> VB,val mDataSet :MutableList<T>): RecyclerView.Adapter<BaseViewBindHolder<VB>>(){

    private fun <vb : ViewBinding> ViewGroup.getViewHolder(
        creator: (inflater: LayoutInflater, root: ViewGroup, attachToRoot: Boolean) -> vb
    ): BaseViewBindHolder<vb> = BaseViewBindHolder(this, creator)

     override fun onBindViewHolder(holder: BaseViewBindHolder<VB>, position: Int) {
         mOnBindViewHolder(holder.mItemView,position=position,mDataSet[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewBindHolder<VB> {
        return parent.getViewHolder(mCreator)
    }


    override fun getItemCount(): Int = mDataSet.size

    abstract fun mOnBindViewHolder(vb:VB, position: Int, get: T)
}
