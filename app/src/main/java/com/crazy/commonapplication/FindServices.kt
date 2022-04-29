package com.crazy.commonapplication

import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.launcher.ARouter
import com.crazy.baseimagegallery.util.arouter.RouterPath
import com.crazy.commonapplication.services.LocalService

/**
 * Copyright (C), 2015-2022, 博彦科技
 * FileName: FindServices
 * Author: zy
 * Date: 2022/4/29 16:23
 * Description: Test
 * History:

 */
class FindServices {
    @Autowired(name = RouterPath.Service.s1)
    lateinit var  mService: LocalService

   init {
       ARouter.getInstance().inject(this)
   }

    fun findS(): Unit {
        mService?.initService("findS")
    }
}