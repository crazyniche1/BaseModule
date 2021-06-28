package com.crazy.baseimagegallery.test

import dagger.Module
import dagger.Provides

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: testModule
 * Author: zy
 * Date: 2021/6/23 17:54
 * Description:
 * History:

 */
@Module
class testModule (val view: Contract.View) {

    @Provides
    fun provideView(): Contract.View {
        return view
    }

    @Provides
    fun provideService(): Service {
        return ServiceImpl()
    }
}