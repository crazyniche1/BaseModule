package com.crazy.baseimagegallery.test

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: Service
 * Author: zy
 * Date: 2021/6/23 17:55
 * Description:
 * History:

 */
interface Service {

    fun getSongList(id: String, offset: Int, callBack: GetSongListCallBack)

    interface GetSongListCallBack {
        fun onSongList(data: List<String>)
        fun onTitle(title: String)
    }
}