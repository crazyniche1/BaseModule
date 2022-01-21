package com.crazy.baseimagegallery.http.net.interceptor

import com.beyondsoft.smarthome.utils.logs.LogTag
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: LogInterceptor
 * Author: zy
 * Date: 2021/12/30 17:46
 * Description: 自定义日志拦截
 * History:

 */
class LogInterceptor:Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val startTime = System.currentTimeMillis()
        val response  = chain.proceed(chain.request())
        val endTime  = System.currentTimeMillis()
        val duration = endTime - startTime

        val mediaType = response.body?.contentType()
        val content = response.body?.string()
        val mBody = content?.toResponseBody(mediaType)
        LogTag.d("request_content： "+chain.request().toString())
        LogTag.d("$duration ms,body: $content")

        return response.newBuilder().body(mBody).build()
    }
}