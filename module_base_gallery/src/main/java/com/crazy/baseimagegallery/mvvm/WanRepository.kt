package com.crazy.baseimagegallery.mvvm

import com.crazy.baseimagegallery.http.bean.BaseResponse
import com.crazy.baseimagegallery.http.net.NetManager
import com.crazy.baseimagegallery.http.net.apiCall
import com.crazy.baseimagegallery.http.test.TestBean

/**
 * Copyright (C), 2015-2022, 博彦科技
 * FileName: WanRepository
 * Author: zy
 * Date: 2022/1/24 17:43
 * Description: 数据源仓库
 * History:

 */
class WanRepository {

     suspend fun testData (): BaseResponse<MutableList<TestBean>> {
            return  NetManager.instance.initRetrofit.homeBanner()
       }
}