package com.crazy.baseimagegallery.http.bean

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: BaseResponse
 * Author: zy
 * Date: 2021/12/30 14:11
 * Description: 解析基类
 * History:

 */
open class BaseResponse<T>:BaseBean(){
     val code: String ?=null
     val msg: String ?=null
     val data: T ?=null
     val status: String ?=null
}
