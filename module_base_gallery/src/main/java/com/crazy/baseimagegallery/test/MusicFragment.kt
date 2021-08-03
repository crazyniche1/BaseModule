package com.crazy.baseimagegallery.test

import android.widget.Toast
import com.crazy.baseimagegallery.R
import com.crazy.baseimagegallery.base.ui.fragment.BaseFragment

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: MusicFragment
 * Author: zy
 * Date: 2021/8/3 17:46
 * Description:
 * History:

 */
class MusicFragment: BaseFragment() {
    override fun getLayoutId() = R.layout.activity_main

    override fun initView() {
        Toast.makeText(this.context, "MusicFragment", Toast.LENGTH_SHORT).show()
    }

    override fun initData() {
    }
}