package com.crazy.baseimagegallery.base.ui.adapter.items

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: Visitable
 * Author: zy
 * Date: 2021/11/24 17:28
 * Description:
 * History:

 */
interface Visitable<T>  {
    fun type(tf : T ): Int
}