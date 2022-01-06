package com.crazy.baseimagegallery.http.net

import android.os.Build
import androidx.annotation.RequiresApi
import okhttp3.Cookie
import okhttp3.CookieJar
import okhttp3.HttpUrl

/**
 * Copyright (C), 2015-2022, 博彦科技
 * FileName: CustomCookie
 * Author: zy
 * Date: 2022/1/4 16:10
 * Description: 添加cookies
 * History:

 */
class CustomCookie:CookieJar {
    val cookieList =  mutableListOf<Cookie>()
    //http请求前回调
    @RequiresApi(Build.VERSION_CODES.N)
    override fun loadForRequest(url: HttpUrl): List<Cookie> {
        //有效
        val cookieByValid =  mutableListOf<Cookie>()
        //过期
        val cookieByPast =  mutableListOf<Cookie>()

        for (e in cookieList){
            if (e.expiresAt < System.currentTimeMillis()){
                cookieByPast.add(e)
            }else if (e.matches(url)){
                cookieByValid.add(e)
            }
        }

        //添加新的cookie
        cookieList.remove(cookieByPast)

        return cookieByValid
    }

    override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
        cookieList.addAll(cookies)
    }
}