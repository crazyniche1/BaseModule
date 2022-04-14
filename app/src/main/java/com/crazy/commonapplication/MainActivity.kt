package com.crazy.commonapplication

import android.content.Context
import android.content.Intent
import android.view.KeyEvent
import android.view.View
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import android.widget.Button
import androidx.recyclerview.widget.ItemTouchHelper
import com.alibaba.android.arouter.facade.annotation.Route
import com.beyondsoft.smarthome.utils.logs.LogTag
import com.crazy.baseimagegallery.base.ui.activity.BaseActivity
import com.crazy.baseimagegallery.util.CommonUtil
import com.crazy.baseimagegallery.util.activity.ActivityManager
import android.app.ActivityManager.RunningServiceInfo
import com.alibaba.android.arouter.launcher.ARouter
import com.crazy.baseimagegallery.util.AppUtils
import com.crazy.baseimagegallery.util.arouter.RouterPath
import com.crazy.baseimagegallery.util.toast.ToastUtil
import com.crazy.commonapplication.databinding.ActivityMainBinding
import com.crazy.commonapplication.databinding.ViewStubTopoBinding
import java.util.*
import kotlin.collections.HashMap
import kotlin.random.Random


@Route(path = RouterPath.Home.home)
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initView() {
//        viewBing.tv.text = "测试测试测试测试测试测试测试"
//        viewBing.tv.setTextColor(resources.getColor(R.color.red))
//        val builder = VmPolicy.Builder()
//        StrictMode.setVmPolicy(builder.build())
//        builder.detectFileUriExposure()
        viewBing.bt.setOnClickListener {

            val ranColor = -0x1000000 or Random.nextInt(0x00ffffff)

            viewBing.bt.setBackgroundColor(ranColor)

//            AppCompatDelegate.setDefaultNightMode( AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
//            SharedUtil<Any>(this).imageAPP("https://upload-images.jianshu.io/upload_images/3708736-e18ae9e2ab80e87d.png")
//            SharedUtil<Any>(this).toInstallWebView("http://weixin.qq.com/download")


//            ConcreteShareBuilder(this).create().shareText("nihao").show()
//            ConcreteShareBuilder(this).create().shareImage("url").show()
            val intent = Intent(mContext,MainActivity2::class.java)
//            startActivity(intent)


            /**
             * 使用标签viewStub 膨胀后，获取视图ID的方式
             * 无法复用Viewbinding
             */
            try {
                val ConstraintLayout_f = viewBing.vsTest.inflate()
                button2 =ConstraintLayout_f.findViewById(R.id.button2)
                button2?.setOnClickListener { ToastUtil.showShort("stub_button") }

                button2?.text = "nihao "

            }catch (e:Throwable){
                viewBing.vsTest.visibility = View.VISIBLE
            }

//            if (!AppUtils(this).serviceIsRun(MyService::class.java.name)){
//                startService(Intent(this,MyService::class.java))
//            }
            LogTag.d("Thread :${Thread.currentThread().name}")
            ARouter.getInstance().build(RouterPath.Service.s1).navigation()
        }


        viewBing.bt.setOnLongClickListener {
            mdt?.notifyDataSetChanged()
            viewBing.vsTest.visibility = View.GONE
            return@setOnLongClickListener true
        }

    }

    private fun serviceIsRun(): Boolean {
        var isRun =false
        val amc = getSystemService(Context.ACTIVITY_SERVICE) as android.app.ActivityManager
        var services :List<RunningServiceInfo> = amc.getRunningServices(Int.MAX_VALUE)

        for (service in  services ){
            if (service.service.className == MyService::class.java.name) return true
        }
        return isRun
    }


    override fun initData() {

//        Glide.with(this).load("http://goo.gl/gEgYUd").into(viewBing.rv)

        initRecycleView(buildRecycleViewData())
        val id = intent.data


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
        mdt = ViewBindTadapter(dataSet)
        val rv = viewBing.rv
        rv.addItemDecoration(MyDecoration())

        //解决侧滑或拖动引起的空白问题
        rv.setItemViewCacheSize(6)

        val al = LayoutAnimationController(AnimationUtils.loadAnimation(mContext,R.anim.item_animation_fall_down))
        rv.layoutAnimation = al

        val ith = ItemTouchHelper(RvCallback(mdt, mContext!!))
        ith.attachToRecyclerView(rv)


        rv.adapter = mdt
//        mdt.setOnItemClickListener(object : OnClickListener.ItemOnClickListener<HashMap<Int, String>>{
//            override fun onItem(t: HashMap<Int, String>, position: Int) {
//                Toast.makeText(this@MainActivity,""+t[position],Toast.LENGTH_SHORT).show()
//            }
//
//        })
    }


    private var button2: Button? = null
    private var ViewStubTopoBinding: ViewStubTopoBinding? = null
    private lateinit var  mdt: ViewBindTadapter
    private var mExitTime:Long=0

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        LogTag.d(""+ ActivityManager.instance.currentActivity())
        if (keyCode==KeyEvent.KEYCODE_BACK ) {
            if((System.currentTimeMillis().minus(mExitTime).compareTo(2000)) >0){
                mExitTime=System.currentTimeMillis()
                ToastUtil.showShort(R.string.module_base_gallery_main_exit_app)

            }else{
                CommonUtil.exitApp()
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

}