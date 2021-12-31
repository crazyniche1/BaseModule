package com.crazy.baseimagegallery.http

import com.crazy.baseimagegallery.http.test.TestBean
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: Api
 * Author: zy
 * Date: 2021/12/30 14:06
 * Description: API 请求路径
 * History:

 */
interface Api {
    @POST("/banner/json")
    suspend fun homeBanner ():TestBean
}