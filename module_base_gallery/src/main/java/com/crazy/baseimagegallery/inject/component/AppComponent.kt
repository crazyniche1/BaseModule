package com.crazy.baseimagegallery.inject.component

import android.content.Context
import com.crazy.baseimagegallery.inject.builder.ActivityBuilder
import com.crazy.baseimagegallery.inject.module.AppMoudle
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: AppComponent
 * Author: zy
 * Date: 2021/6/21 10:13
 * Description:
 * History:(AndroidInjectionModule::class), (ActivityBuilder::class),
 */
@Singleton
@Component(modules = [ (AppMoudle::class)])
interface AppComponent {

    fun context(): Context
}