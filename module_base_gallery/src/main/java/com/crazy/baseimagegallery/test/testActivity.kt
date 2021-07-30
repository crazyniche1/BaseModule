package com.crazy.baseimagegallery.test

import android.graphics.Color
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.beyondsoft.smarthome.utils.logs.LogTag
import com.crazy.baseimagegallery.R
import com.crazy.baseimagegallery.base.ui.BaseMvpActivity
import com.crazy.baseimagegallery.databinding.ActivityMainBinding
import com.crazy.baseimagegallery.util.persistentStorage.PersistentStorage

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
        initRecycle(viewBing.rvRvList)

        var k = "test";
        var k2 = "test1";
        mPresenter.getSongList("1", 2)


        //使用CollapsingToolbarLayout必须把title设置到CollapsingToolbarLayout上，设置到Toolbar上则不会显示
        var mCollapsingToolbarLayout = viewBing.collapsingToolbarLayout
        mCollapsingToolbarLayout.setTitle("CollapsingToolbarLayout");
        //通过CollapsingToolbarLayout修改字体颜色
        mCollapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);//设置还没收缩时状态下字体颜色
        mCollapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);//设置收缩后Toolbar上字体的颜色


//        viewBing.btCommit.setOnClickListener {
//            var txt = viewBing.tvTest.text.toString()
//            PersistentStorage().enCodeString(k,txt)
//            PersistentStorage().enCodeBoolean(k2,true)
//        }
//
//        viewBing.tvTest.setOnClickListener {
//            var txt = PersistentStorage().deCodeString(k)
//            var txtBool = PersistentStorage().deCodeBoolean(k2)
//            Toast.makeText(this, ""+txt, Toast.LENGTH_SHORT).show()
//            Toast.makeText(this, ""+txtBool, Toast.LENGTH_SHORT).show()
//        }
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