package com.crazy.baseimagegallery.http.net

import com.crazy.baseimagegallery.http.Api
import com.crazy.baseimagegallery.http.HttpConstant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: NetManager
 * Author: zy
 * Date: 2021/12/30 16:32
 * Description: 主题
 * History:

 */
object NetManager {
    val readTimeout:Long = 10 *1000
    val writeTimeout:Long = 10 *1000
    val connectTimeout:Long = 10 *1000
    val timeType:TimeUnit = TimeUnit.SECONDS
    /**
     * 懒加载初始化 retrofit
     */
     val initRetrofit :Api by lazy {
         Retrofit.Builder()
            .baseUrl(HttpConstant.BaseUrl)
                //序列化反序列化转化提供工厂
            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(initHttpClient())
            .build()
            .create(Api::class.java)
    }

    private fun initHttpClient(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .readTimeout(readTimeout, timeType)
            .writeTimeout(writeTimeout, timeType)
            .connectTimeout(connectTimeout, timeType)
            //设置打印拦截日志
//            .addNetworkInterceptor (httpLoggingInterceptor)
            .addInterceptor(LogInterceptor())
            .build()
    }

}
