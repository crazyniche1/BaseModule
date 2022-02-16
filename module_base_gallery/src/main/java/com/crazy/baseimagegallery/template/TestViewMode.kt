package com.crazy.baseimagegallery.template

import androidx.lifecycle.MutableLiveData
import com.crazy.baseimagegallery.http.net.ApiException
import com.crazy.baseimagegallery.http.net.apiCall
import com.crazy.baseimagegallery.http.test.TestBean
import com.crazy.baseimagegallery.mvvm.vm.BaseViewMode

/**
 * Copyright (C), 2015-2022, 博彦科技
 * FileName: TestViewMode
 * Author: zy
 * Date: 2022/1/17 11:01
 * Description: vm class
 * History:

 */
class TestViewMode : BaseViewMode() {

     val mWanLiveData = MutableLiveData<List<TestBean>>()
     val errorInfo = MutableLiveData<String>()

    fun test1Request() {

        launchRequest {
            val request = apiCall { rs.testData() }
            when(request.code){
                ApiException.CODE_SUCCESS ->mWanLiveData.value = request.data!!
                else ->errorInfo.value = request.msg.toString()
            }
        }
    }



}