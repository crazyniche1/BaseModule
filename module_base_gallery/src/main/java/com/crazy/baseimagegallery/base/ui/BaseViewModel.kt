package com.crazy.baseimagegallery.base.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: BaseViewModel
 * Author: zy
 * Date: 2021/8/4 17:19
 * Description: 先放构建一个liveData 基类;没有任何内容
 * History:
 *
 *

 */
class BaseViewModel  : ViewModel() {

    //creater  liveData sting
    val currentName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    //creater  liveData list
    val getCurrentListName: MutableLiveData<List<String>> by lazy {
        MutableLiveData<List<String>>()
    }



}