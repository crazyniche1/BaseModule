package com.crazy.baseimagegallery.util.text

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: TextUtil
 * Author: zy
 * Date: 2021/11/2 11:05
 * Description: 文字工具类
 * History:

 */
 class TextUtil {

    constructor()

     fun isEmpty (string: String):String{
        return if ( string.isNullOrBlank()) "" else string
    }
}