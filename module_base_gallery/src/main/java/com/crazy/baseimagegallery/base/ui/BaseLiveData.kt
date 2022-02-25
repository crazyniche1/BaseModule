package com.crazy.baseimagegallery.base.ui

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: BaseLiveData
 * Author: zy
 * Date: 2021/8/5 17:29
 * Description: 全局单例模式
 * History:

 */
class BaseLiveData<T>(t: Any) : LiveData<T>() {

    private val listener = { it: T ->
        postValue(it)
    }

    //活跃
    override fun onActive() {
        super.onActive()
    }

    //不活跃
    override fun onInactive() {
        super.onInactive()
    }

    companion object {
        private lateinit var sInstance : BaseLiveData<Any>

        @MainThread
        fun getInstance(t:Any): BaseLiveData <Any>{
            sInstance = if (::sInstance.isInitialized) sInstance else BaseLiveData(t)
            return sInstance
        }
    }
}