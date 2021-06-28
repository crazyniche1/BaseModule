package com.crazy.baseimagegallery.inject.component

import android.app.Activity
import android.content.Context
import com.crazy.baseimagegallery.inject.module.ActivityMoudle
import com.gfd.common.injection.scope.ActivityScope
import dagger.Component

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: ActivityComponent
 * Author: zy
 * Date: 2021/6/23 17:19
 * Description:
 * History:

 */

@ActivityScope
@Component(dependencies = [AppComponent::class],
    modules = [ActivityMoudle::class])
interface ActivityComponent {
    fun context(): Context
    fun activity(): Activity
}