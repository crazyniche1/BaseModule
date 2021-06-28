package com.crazy.baseimagegallery.mvp.view

import android.content.Context
import androidx.lifecycle.LifecycleOwner

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: MVPBaseView
 * Author: zy
 * Date: 2021/6/8 11:23
 * Description: MVPBaseView
 * History:

 */
interface MVPBaseView {
    /**
     * 显示加载框
     */
    fun showLoading()

    /**
     * 隐藏加载框
     */
    fun dismissLoading()

    /**
     * 空数据
     *
     * @param tag TAG
     */
    fun onEmpty(tag: Any?){}

    /**
     * 错误数据
     *
     * @param tag      TAG
     * @param errorMsg 错误信息
     */
    fun onError(tag: Any?, errorMsg: String?){}

    /**
     * 上下文
     *
     * @return context

    fun getContext(): Context?
     */
    /**
     * 返回页面生命周期
     *
     * @return LifecycleOwner

    fun getLifecycleOwner(): LifecycleOwner?
     */
}