package com.crazy.commonapplication

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.beyondsoft.smarthome.utils.logs.LogTag

/**
 * Copyright (C), 2015-2022, 博彦科技
 * FileName: TestWork
 * Author: zy
 * Date: 2022/3/30 17:15
 * Description:
 * History:

 */
class TestWork(appContext: Context, workerParams: WorkerParameters) : Worker(appContext,workerParams) {
    override fun doWork(): Result {
        TODO("Not yet implemented")
        LogTag.d("Worker$ 运行成功")
        Result.success()
    }


}