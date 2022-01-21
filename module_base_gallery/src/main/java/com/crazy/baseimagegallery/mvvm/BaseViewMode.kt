package com.crazy.baseimagegallery.mvvm

import androidx.lifecycle.ViewModel
import com.crazy.baseimagegallery.R
import com.crazy.baseimagegallery.util.SingleLiveEvent
import com.crazy.baseimagegallery.util.StateView

/**
 * Copyright (C), 2015-2022, 博彦科技
 * FileName: BaseViewMode
 * Author: zy
 * Date: 2022/1/17 17:44
 * Description: 业务代码 ，网络请求资源后的获取
 * History:
 cnakao :https://www.jianshu.com/p/a2eeff4caf6e  https://juejin.cn/post/6921321173661777933#heading-7
 */
class BaseViewMode:ViewModel() {
    val showLoad = SingleLiveEvent<Boolean>()
    val showErrorInfo = SingleLiveEvent<String>()



}