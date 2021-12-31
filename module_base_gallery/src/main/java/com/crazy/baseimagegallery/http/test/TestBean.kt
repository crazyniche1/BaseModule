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
data class TestBean(val avatarUrl:String): BaseResponse<MutableList<GlobalSwitchC> ?>() {
    val comment:Int ?= null
    val desc:MutableList<GlobalSwitchC> ?= null


}
data class GlobalSwitchC(val id:Int){
    val title:String ?= null
}
