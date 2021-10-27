package com.crazy.baseimagegallery.base.ui

import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import com.crazy.baseimagegallery.base.BaseApplication
import com.crazy.baseimagegallery.base.ui.activity.BaseActivity
import com.crazy.baseimagegallery.inject.component.DaggerActivityComponent
import com.crazy.baseimagegallery.inject.module.ActivityMoudle
import com.crazy.baseimagegallery.mvp.presenter.MVPBasePresenter
import com.crazy.baseimagegallery.mvp.view.MVPBaseView
import javax.inject.Inject

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: BaseMvpActivity
 * Author: zy
 * Date: 2021/6/10 17:54
 * Description:
 * History:
 */
abstract class BaseMvpActivity<T : MVPBasePresenter,V: ViewBinding> : BaseActivity<V>(), MVPBaseView {

    @Inject
    lateinit var mPresenter: T

    protected lateinit var mActivityComponent: DaggerActivityComponent

    override fun initOperate() {
        super.initOperate()
        initActivityInjection()
        injectComponent()
    }

    private fun initActivityInjection() {
        mActivityComponent = DaggerActivityComponent.builder()
            .activityMoudle(ActivityMoudle(this))
            .appComponent((application as BaseApplication).appComponent)
            .build() as DaggerActivityComponent
    }

    abstract fun injectComponent()

}