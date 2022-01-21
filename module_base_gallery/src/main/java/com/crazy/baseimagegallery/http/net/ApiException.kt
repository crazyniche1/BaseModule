package com.crazy.baseimagegallery.http.net

import com.crazy.baseimagegallery.http.bean.BaseResponse
import com.google.gson.JsonParseException
import org.apache.http.conn.ConnectTimeoutException
import org.json.JSONException
import retrofit2.HttpException
import java.io.IOException
import java.lang.RuntimeException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * Copyright (C), 2015-2022, 博彦科技
 * FileName: ApiException
 * Author: zy
 * Date: 2022/1/7 15:34
 * Description: 网络、数据解析错误处理
 * History:

 */
class ApiException(
    private val code: Int,
    override val message: String?,
    override val cause: Throwable? = null) :RuntimeException(message,cause){

       companion object{
           //状态码
           const val CODE_NET_ERROR = 4000
           const val CODE_TIMEOUT = 4080
           const val CODE_JSON_PARSE_ERROR = 4010
           const val CODE_SERVER_ERROR = 5000

           const val CODE_AUTH_INVALID = 401

           fun build(e:Throwable): ApiException {
               return when(e){

                   is HttpException -> ApiException(CODE_NET_ERROR, "网络异常(${e.code()},${e.message()})")
                   is UnknownHostException ->ApiException(CODE_NET_ERROR, "网络连接失败，请检查后再试")
                   is ConnectTimeoutException -> ApiException(CODE_TIMEOUT, "请求超时，请稍后再试")
                   is SocketTimeoutException  -> ApiException(CODE_TIMEOUT, "请求超时，请稍后再试")
                   is IOException -> ApiException(CODE_NET_ERROR, "网络异常(${e.message})")
                   is JsonParseException  -> ApiException(CODE_JSON_PARSE_ERROR, "数据解析错误，请稍后再试")
                   is JSONException  -> ApiException(CODE_JSON_PARSE_ERROR, "数据解析错误，请稍后再试")
                   else ->  ApiException(CODE_SERVER_ERROR, "系统错误(${e.message})")
               }
           }


       }

    fun <T> toResponse():BaseResponse<T>{
        return BaseResponse(code,message)
    }
}