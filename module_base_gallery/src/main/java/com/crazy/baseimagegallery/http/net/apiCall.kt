package com.crazy.baseimagegallery.http.net

import com.beyondsoft.smarthome.utils.logs.LogTag
import com.crazy.baseimagegallery.http.bean.BaseResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.withContext

/**
 * Copyright (C), 2015-2022, 博彦科技
 * FileName: apiCall
 * Author: zy
 * Date: 2022/1/7 15:24
 * Description:创建 apiCall 方法，统一处理异常逻辑
 * History:

 */
suspend inline fun<T>  apiCall(crossinline call:suspend CoroutineScope.() ->BaseResponse<T>): BaseResponse<T> {
    return withContext(Dispatchers.IO){
        var res:BaseResponse<T>

        try {
            res = call()
        }catch (e:Throwable){
            return@withContext ApiException.build(e).toResponse()
        }

        if (res.code ==ApiException.CODE_TIMEOUT){
            // 登录过期，取消协程，跳转登录界面
            cancel()
        }
        return@withContext res
    }
}