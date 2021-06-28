package com.crazy.baseimagegallery.test

import javax.inject.Inject

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: ServiceImpl
 * Author: zy
 * Date: 2021/6/23 17:56
 * Description:
 * History:

 */
class ServiceImpl  @Inject constructor() :Service {

    @Inject
    override fun getSongList(id: String, offset: Int, callBack: Service.GetSongListCallBack) {
        callBack.onTitle("titleData")

        val data: MutableList<String> = ArrayList()
        data.add("1")
        data.add("2")
        data.add("3")
        data.add("4")
        callBack.onSongList(data)
    }
}