package com.crazy.baseimagegallery.template

import android.content.Intent
import android.net.Uri
import androidx.recyclerview.widget.LinearLayoutManager
import com.beyondsoft.smarthome.utils.logs.LogTag
import com.bumptech.glide.Glide
import com.crazy.baseimagegallery.base.BaseApplication.Companion.context
import com.crazy.baseimagegallery.databinding.ActivityMainBinding
import com.crazy.baseimagegallery.mvvm.view.BaseVMActivity


class TtMainActivity : BaseVMActivity<ActivityMainBinding>() {

    private val tvVM by lazy{(getActivityScopeViewModel(TestViewMode::class.java) )}

    override fun getViewBinding()  = ActivityMainBinding.inflate(layoutInflater)
    override fun isSetStateView(): Boolean =false

    override fun initData() {
//        viewBing.button.setOnClickListener {
//            SharedUtil<Any>(this,).image("https://upload-images.jianshu.io/upload_images/3708736-e18ae9e2ab80e87d.png?imageMogr2/auto-orient/strip|imageView2/2/w/345/format/webp")
//            requestNet()
//            showLoading()

//            ARouter.getInstance().build(RouterPath.Home.home).navigation()
//            val it = Intent(this,TMainActivity::class.java)
//            startActivity(it)
//            finish()
//
//            viewBing.button.postDelayed({
//                dismissLoading()
//            },3000L)

//            tvVM.test1Request()
//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fv_test) as NavHostFragment

//            NavigationUI.setupActionBarWithNavController(this,navHostFragment.navController)

//        tvVM.test1Request()
//        Glide.with(this).load("http://goo.gl/gEgYUd").into(viewBing.fcv)
        tvVM.mWanLiveData.observe(this){
            for (i in it.withIndex()){
                LogTag.d("test:::"+tvVM.mWanLiveData.toString())
            }
        }
        tvVM.errorInfo.observe(this){
            LogTag.d("err_test:::$it")
        }

//        initRecycleView(buildRecycleViewData())

//        viewBing.button.setOnClickListener {
//
//            val uri: Uri = Uri.parse("http://bs-portal.iot.com/login")
//            val intent = Intent(Intent.ACTION_VIEW)
//            intent.data = uri
//            startActivity(intent)
//            if (this != null && intent.resolveActivity(this.packageManager)!=null) {
//
//            }
//            TestPopUpW(viewBing.tvTest,layoutInflater).show()
//
//            TestDialog().show(this.supportFragmentManager)
//        }


    }

    private fun buildRecycleViewData():MutableList<HashMap<Int,String>>{
        val dataSet = mutableListOf<HashMap<Int,String>>()
        for (i  in  0..10){
            val map = HashMap<Int,String>()
            map[i] = "nihaoya$i"
            dataSet.add(i,map)
        }
        return dataSet
    }
    private fun initRecycleView(dataSet:MutableList<HashMap<Int,String>>){
        var mdt = ViewBindTadapter(dataSet)
//        val rv = viewBing.rvRvList

//        rv.adapter = mdt
//        rv.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)


    }

}
