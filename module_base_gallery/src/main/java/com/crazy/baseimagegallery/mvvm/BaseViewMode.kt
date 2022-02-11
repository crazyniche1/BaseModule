package com.crazy.baseimagegallery.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.crazy.baseimagegallery.http.bean.BaseResponse
import com.crazy.baseimagegallery.http.net.ApiException
import com.crazy.baseimagegallery.http.net.apiCall
import com.crazy.baseimagegallery.http.test.TestBean
import com.crazy.baseimagegallery.util.SingleLiveEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Copyright (C), 2015-2022, 博彦科技
 * FileName: BaseViewMode
 * Author: zy
 * Date: 2022/1/17 17:44
 * Description: 业务代码 ，网络请求资源后的获取
 * History:
 cnakao :https://www.jianshu.com/p/a2eeff4caf6e  https://juejin.cn/post/6921321173661777933#heading-7
 */
abstract class BaseViewMode:ViewModel() {
     val showLoad = SingleLiveEvent<Boolean>()
     val rs = WanRepository()

    /**
     * 开始加载
     */
    private fun startLoad() {
        showLoad.value = true
    }

    /**
     * 停止加载
     */
    private fun stopLoad() {
        showLoad.value = false
    }

    /**
     * 是否显示加载
     * isShowLoad
     */

     fun launchRequest(
         isShowLoad :Boolean = true ,
         request: suspend () -> Unit ) {
            //是否展示Loading
            if (isShowLoad) {
                startLoad()
            }

            //使用viewModelScope.launch开启协程,强制主线程
            viewModelScope.launch(Dispatchers.Main) {
                request()
                if (isShowLoad) {
                    stopLoad()
                }
            }
    }

}