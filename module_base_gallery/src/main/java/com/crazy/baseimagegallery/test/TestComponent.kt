package com.crazy.baseimagegallery.test

import com.crazy.baseimagegallery.inject.component.ActivityComponent
import com.gfd.common.injection.scope.PerComponentScope
import dagger.Component

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: Component
 * Author: zy
 * Date: 2021/6/23 17:53
 * Description:
 * History:

 */

@PerComponentScope
@Component(dependencies = [(ActivityComponent::class)], modules = [(testModule::class)])
interface TestComponent {
    fun inject(activity: testActivity)
}