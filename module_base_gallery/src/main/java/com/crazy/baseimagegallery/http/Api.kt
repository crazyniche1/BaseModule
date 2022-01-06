package com.crazy.baseimagegallery.http

import com.crazy.baseimagegallery.http.test.LoginBean
import com.crazy.baseimagegallery.http.test.TestBean
import okhttp3.RequestBody
import retrofit2.http.Body
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
    @GET("/api/v1/user/menu/tree/after-login")
    suspend fun homeBanner ():TestBean

    @POST("/api/v1/user/login-saas")
    suspend fun homeLogin (@Body rs:RequestBody ): LoginBean

}