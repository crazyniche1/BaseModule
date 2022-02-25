package com.crazy.baseimagegallery.template

import com.crazy.baseimagegallery.R
import com.crazy.baseimagegallery.base.ui.fragment.BaseFragment
import com.crazy.baseimagegallery.databinding.FragmentMainBinding

/**
 * Copyright (C), 2015-2022, 博彦科技
 * FileName: FirstFragment
 * Author: zy
 * Date: 2022/2/23 17:41
 * Description:
 * History:

 */
class FirstFragment:BaseFragment<FragmentMainBinding>() {

    override fun initView() {

    }

    override fun initData() {
        viewBing.button.text = "我是你爸爸"
    }

    override fun getViewBinding() = FragmentMainBinding.inflate(this.layoutInflater)
}