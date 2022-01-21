package com.crazy.baseimagegallery.http.test

import com.crazy.baseimagegallery.http.bean.BaseResponse

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: TestBean
 * Author: zy
 * Date: 2021/12/30 16:23
 * Description: test
 * History:

 */
data class TestBean(val children:List<Children>?)
   {

    class Children(val id:String ?){
        val children: List<Children> = mutableListOf()
        val menuFid: String = ""
        val menuIcon: String = ""
        val menuLevel = 0
        val menuName: String = ""
        val menuOrder = 0
        val menuStatus = 0
        val menuType = 0
        val menuUrl: String = ""
    }
}

