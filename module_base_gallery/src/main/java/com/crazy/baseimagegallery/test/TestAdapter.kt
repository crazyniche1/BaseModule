package com.crazy.baseimagegallery.test

import android.content.Context
import android.widget.TextView
import com.crazy.baseimagegallery.R
import com.crazy.baseimagegallery.base.ui.adapter.BaseListAdapter
import org.byteam.superadapter.SuperViewHolder

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: TestAdapter
 * Author: zy
 * Date: 2021/7/30 13:53
 * Description: testAdapter
 * History:

 */
class TestAdapter(context: Context?, mData: MutableList<String>?, layoutResId: Int) :
    BaseListAdapter<String>(context, mData, layoutResId) {


    override fun onBindData(
        holder: SuperViewHolder,
        viewType: Int,
        layoutPosition: Int,
        data: String
    ) {
        holder.setText(R.id.textView,data)

    }
}