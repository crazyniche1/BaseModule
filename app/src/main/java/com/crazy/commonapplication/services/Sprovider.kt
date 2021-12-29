package com.crazy.commonapplication.services

import android.content.Context
import com.alibaba.android.arouter.facade.template.IProvider

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: Sprovider
 * Author: zy
 * Date: 2021/12/28 17:53
 * Description:
 * History:

 */
interface Sprovider :IProvider {
    fun initService(name:String ):String
}