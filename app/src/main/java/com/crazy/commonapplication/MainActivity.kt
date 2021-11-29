package com.crazy.commonapplication

//import com.crazy.baseimagegallery.util.share.SharedUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.crazy.baseimagegallery.base.ui.activity.BaseActivity
import com.crazy.commonapplication.databinding.ActivityMainBinding
import com.crazy.mshare.concreteBuilder.ConcreteShareBuilder
import kotlin.collections.HashMap


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

//            AppCompatDelegate.setDefaultNightMode( AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
//            SharedUtil<Any>(this).imageAPP("https://upload-images.jianshu.io/upload_images/3708736-e18ae9e2ab80e87d.png")
//            SharedUtil<Any>(this).toInstallWebView("http://weixin.qq.com/download")


            ConcreteShareBuilder(this).create().shareText("nihao").show()
//            ConcreteShareBuilder(this).create().shareImage("url").show()
        }
    }

    override fun initData() {

//        Glide.with(this).load("http://goo.gl/gEgYUd").into(viewBing.rv)

        viewBing.rv.layoutManager = GridLayoutManager(this,3)
        val dataSet = mutableListOf<HashMap<Int,String>>()
        for (i  in  0..10){
            val map = HashMap<Int,String>()
            map[i] = "nihaoya$i"
            dataSet.add(i,map)
        }
        val mdt = ViewBindTadapter(dataSet)

        viewBing.rv.adapter = mdt


//        mdt.setOnItemClickListener(object : OnClickListener.ItemOnClickListener<HashMap<Int, String>>{
//            override fun onItem(t: HashMap<Int, String>, position: Int) {
//                Toast.makeText(this@MainActivity,""+t[position],Toast.LENGTH_SHORT).show()
//            }
//
//        })

    }

}