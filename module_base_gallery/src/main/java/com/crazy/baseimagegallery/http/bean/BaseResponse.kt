package com.crazy.baseimagegallery.http.bean

import com.google.gson.annotations.SerializedName

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: BaseResponse
 * Author: zy
 * Date: 2021/12/30 14:11
 * Description: 解析基类
 * History:

 */
data class BaseResponse<T>(
   val code: Int = -1,
   val msg: String? = "",
   val data: T? = null
) :BaseBean()
