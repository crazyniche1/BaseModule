package com.crazy.baseimagegallery.base

import androidx.lifecycle.LifecycleOwner

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: BaseModel
 * Author: zy
 * Date: 2021/6/8 11:21
 * Description: m
 * History:

 */
 open class BaseModel {


    private lateinit var lifecycleOwner: LifecycleOwner

    constructor()

    constructor(mLifecycleOwner: LifecycleOwner){
        lifecycleOwner = mLifecycleOwner
    }


    /**
     * 返回生命周期所有者
     *
     * @return LifecycleOwner
     */
    protected fun getLifecycleOwner(): LifecycleOwner {
        return lifecycleOwner
    }

}