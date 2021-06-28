package com.crazy.baseimagegallery.inject.module

import android.app.Activity
import com.gfd.common.injection.scope.ActivityScope
import dagger.Module
import dagger.Provides

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: ActivityMoudle
 * Author: zy
 * Date: 2021/6/23 17:20
 * Description:
 * History:

 */
@Module
class ActivityMoudle (private val activity: Activity) {

    @ActivityScope
    @Provides
    fun provideActivity(): Activity {
        return this.activity
    }

}