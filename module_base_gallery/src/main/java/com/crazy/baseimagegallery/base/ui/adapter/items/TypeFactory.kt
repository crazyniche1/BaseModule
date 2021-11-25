package com.crazy.baseimagegallery.base.ui.adapter.items

import android.view.View
import com.crazy.baseimagegallery.base.ui.adapter.viewholder.BaseViewHolder

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: TypeFactory
 * Author: zy
 * Date: 2021/11/24 17:29
 * Description:
 * History:
 */
interface TypeFactory  {
    fun createViewHolder( type:Int,  itemView:View) : BaseViewHolder
}
