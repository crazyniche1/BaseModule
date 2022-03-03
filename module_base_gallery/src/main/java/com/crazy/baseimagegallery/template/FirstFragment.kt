package com.crazy.baseimagegallery.template

import android.view.LayoutInflater
import android.view.Menu
import com.beyondsoft.smarthome.utils.logs.LogTag
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

         val  groupId =0
        //底部导航
        viewBing.bnvMenu.menu.add(groupId,0,Menu.NONE,"首页1")
        viewBing.bnvMenu.menu.add(groupId,1,Menu.NONE,"首页2")
        viewBing.bnvMenu.menu.add(groupId,2,Menu.NONE,"首页3")
//            LogTag.d(""+it.itemId)
        viewBing.bnvMenu.setOnNavigationItemSelectedListener { item ->
            LogTag.d("" + item.itemId)
            return@setOnNavigationItemSelectedListener true
        }

        viewBing.tvTest.setOnClickListener {


        }

    }

    override fun getViewBinding() = FragmentMainBinding.inflate(this.layoutInflater)
}