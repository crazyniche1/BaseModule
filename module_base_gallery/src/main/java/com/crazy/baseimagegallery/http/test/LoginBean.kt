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
data class LoginBean(val jwt:String?): BaseResponse<LoginBean>() {
    val user: Children? = null

    class Children(val account:String){
        val companyId: String? = null
        val companyName: String? = null
        val menuIcon: String? = null
        val menuLevel = 0
        val menuName: String? = null
        val menuOrder = 0
        val menuStatus = 0
        val menuType = 0
        val menuUrl: String? = null
    }

}
