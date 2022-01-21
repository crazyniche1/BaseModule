package com.crazy.baseimagegallery.util

import androidx.annotation.MainThread
import androidx.annotation.Nullable
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Copyright (C), 2015-2022, 博彦科技
 * FileName: SingleLiveData
 * Author: zy
 * Date: 2022/1/18 11:07
 * Description:多个观察者存在时，只有一个Observer能够收到数据更新
 * History:

 */
class SingleLiveEvent<T>:MutableLiveData<T>() {
    companion object {
        val TAG = "SingleLiveEvent"

    }
    //高并发只有一个线程能访问该值
    val mPending = AtomicBoolean(false)

    @MainThread
    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
//        super.observe(owner, observer)
        super.observe(owner, {
            //如果expect为true，那么将值update为false，方法整体返回true，
            //当前Observer能够收到更新，后面如果还有订阅者，不能再收到更新通知了
            if (mPending.compareAndSet(true,false)){
                observer.onChanged(it)
            }
        })
    }


    override fun setValue(value: T?) {
        mPending.set(true)
        super.setValue(value)
    }
    @MainThread
    fun call() {
        value = null
    }
}