package com.crazy.commonapplication

import android.content.Intent
import android.view.KeyEvent
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import androidx.recyclerview.widget.ItemTouchHelper
import com.beyondsoft.smarthome.utils.logs.LogTag
import com.crazy.baseimagegallery.base.ui.activity.BaseActivity
import com.crazy.baseimagegallery.util.CommonUtil
import com.crazy.baseimagegallery.util.activity.ActivityManager
import com.crazy.baseimagegallery.util.toast.ToastUtil
import com.crazy.commonapplication.databinding.ActivityMainBinding
import kotlin.random.Random


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
        }

        viewBing.bt.setOnLongClickListener {
            mdt?.notifyDataSetChanged()
            return@setOnLongClickListener true
        }

    }


    override fun initData() {

//        Glide.with(this).load("http://goo.gl/gEgYUd").into(viewBing.rv)

//        viewBing.rv.layoutManager = GridLayoutManager(this,3)
        val dataSet = mutableListOf<HashMap<Int,String>>()
        for (i  in  0..10){
            val map = HashMap<Int,String>()
            map[i] = "nihaoya$i"
            dataSet.add(i,map)
        }
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

    private lateinit var  mdt: ViewBindTadapter
    private var mExitTime:Long=0

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        LogTag.d(""+ ActivityManager.instance.currentActivity())
        if (keyCode==KeyEvent.KEYCODE_BACK ) {
            if((System.currentTimeMillis().minus(mExitTime).compareTo(2000)) >0){
                mExitTime=System.currentTimeMillis()
                ToastUtil.showShort(R.string.main_exit_app)

            }else{
                CommonUtil.exitApp()
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

}