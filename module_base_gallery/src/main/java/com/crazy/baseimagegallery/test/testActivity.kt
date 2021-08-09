package com.crazy.baseimagegallery.test

import android.graphics.Color
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.fragment.app.replace
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.beyondsoft.smarthome.utils.logs.LogTag
import com.crazy.baseimagegallery.R
import com.crazy.baseimagegallery.base.ui.BaseMvpActivity
import com.crazy.baseimagegallery.databinding.ActivityMainBinding
import com.crazy.baseimagegallery.util.date.DataUtil
import com.crazy.baseimagegallery.util.persistentStorage.PersistentStorage
import java.util.*

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: testActivity
 * Author: zy
 * Date: 2021/6/23 17:41
 * Description:
 * History:

 */
class testActivity : BaseMvpActivity<testPresenter, ActivityMainBinding>(), Contract.View {

    override fun injectComponent() {
        DaggerTestComponent.builder()
            .activityComponent(mActivityComponent)
            .testModule(testModule(this))
            .build()
            .inject(this)
    }

    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun initView() {
//        viewBing.tvTest.visibility = View.VISIBLE
    }

    override fun initData() {
//        viewBing.tvTest.gravity = Gravity.CENTER

        val calendar1 = DataUtil.stringToCalendar("ddddddd")
        val calendar = DataUtil.getWeekEndDay()
        viewBing.tvTest.text = DataUtil.calToString(calendar,DataUtil.dateF1)
        LogTag.d("calendar${viewBing.tvTest.text.trim()}")


        initRecycle(viewBing.rvRvList)

        initFragment ()

        var k = "test";
        var k2 = "test1";
        mPresenter.getSongList("1", 2)


    }

    private fun initFragment() {
        val musicFragment = MusicFragment()

        supportFragmentManager.beginTransaction().replace(R.id.fl_root, musicFragment).commit()
    }

    fun initRecycle(recyclerView: RecyclerView) {
        //context: Context?, mData: MutableList<String>?, layoutResId: Int)
        var mData = mutableListOf<String>()
        for (i in 1..30){
            mData.add("test shuju :"+i)
        }
        var ta = TestAdapter(mContext,mData,R.layout.item_)
        val mlm = LinearLayoutManager(mContext,RecyclerView.VERTICAL,false)
        recyclerView.adapter = ta
        recyclerView.layoutManager = mlm
    }

    override fun showSongList(data: List<String>) {
        LogTag.d("showSongList${data.size}")
    }

    override fun onDestroy() {
        super.onDestroy()
        PersistentStorage().onDestroy()
    }

}