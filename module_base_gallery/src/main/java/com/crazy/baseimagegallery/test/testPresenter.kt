package com.crazy.baseimagegallery.test

import javax.inject.Inject

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: testPresenter
 * Author: zy
 * Date: 2021/6/23 17:42
 * Description:
 * History:

 */
class testPresenter @Inject constructor() :Contract.Presenter,Service.GetSongListCallBack {

    @Inject
    lateinit var mView: Contract.View

    @Inject
    lateinit var mService: Service


    override fun getSongList(id: String, offset: Int) {
        mView.showLoading()
        mService.getSongList(id,offset,this)
    }

    override fun onSongList(data: List<String>) {
        mView.dismissLoading()
        mView.showSongList(data)
    }

    override fun onTitle(title: String) {
//        mView.showHead(title)
    }
}