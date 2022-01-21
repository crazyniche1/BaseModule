package com.crazy.baseimagegallery.http.net.util

import com.beyondsoft.smarthome.utils.logs.LogTag
import com.google.gson.GsonBuilder
import okhttp3.MediaType.Companion.parse
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

/**
 * Copyright (C), 2015-2022, 博彦科技
 * FileName: com.crazy.baseimagegallery.http.net.util.RequestGenerateUtils
 * Author: zy
 * Date: 2022/1/5 15:46
 * Description: 请求体
 * History:

 */
object RequestGenerateUtils {

    /**
     * 封装数据
     */
    fun requestParams()= mutableMapOf<String,Any>()

    /**
     * 以json形式传参
     */
     fun requestBody( bean :Any): RequestBody {
        val json = GsonBuilder().disableHtmlEscaping().create().toJson(bean)
        LogTag.d("request：$json")
        return json.toRequestBody("application/json; charset=utf-8".toMediaTypeOrNull())
    }

}