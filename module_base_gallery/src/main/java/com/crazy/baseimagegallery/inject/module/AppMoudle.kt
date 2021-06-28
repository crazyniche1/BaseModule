package com.crazy.baseimagegallery.inject.module

import android.app.Application
import android.content.Context
import com.crazy.baseimagegallery.base.BaseApplication
import com.crazy.baseimagegallery.util.SchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: AppMoudle
 * Author: zy
 * Date: 2021/6/18 11:21
 * Description:
 * History:
 */
@Module
class AppMoudle (private val context:BaseApplication){

    @Singleton
    @Provides
    fun provideContext(): Context {
        return this.context
    }


}