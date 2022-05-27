package com.crazy.commonapplication

import android.net.Uri
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.crazy.baseimagegallery.base.ui.activity.BaseActivity
import com.crazy.baseimagegallery.util.AppUtils
import com.crazy.baseimagegallery.util.CommonUtil
import com.crazy.baseimagegallery.util.arouter.RouterPath
import com.crazy.baseimagegallery.util.toast.ToastUtil
import com.crazy.commonapplication.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.HashMap
import kotlin.random.Random


@Route(path = RouterPath.Home.home)
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getViewBinding(): ActivityMainBinding {

        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onStart() {
        super.onStart()

//        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
//        EventBus.getDefault().unregister(this)
    }

//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//
//        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults)
//
//    }
//
//    companion object {
//        const val  PERMISSIONS_REQUEST_CODE = 2
//    }
//
//    @AfterPermissionGranted(PERMISSIONS_REQUEST_CODE)
//    fun requestPermission() {
//
//       if ( EasyPermissions.hasPermissions(this,android.Manifest.permission.CAMERA)){
//           ToastUtil.showShort("有相机权限")
//
//       }else{
//
//
//           EasyPermissions.requestPermissions(this, "拍照过程需要用到相机权限",
//               PERMISSIONS_REQUEST_CODE, android.Manifest.permission.CAMERA)
//       }
//
//    }



    override fun initData() {

        val uri: Uri? = intent.data
        if (uri != null) {
            val host: String? = uri.getHost()
            val dataString = intent.dataString
            val id: String? = uri.getQueryParameter("id")
            val path: String? = uri.getPath()
            val path1: String? = uri.getEncodedPath()
            val queryString: String? = uri.getQuery()
            val getQueryParameter = uri.getQueryParameter("zy")
            Log.d("Alex", "getQueryParameter:$getQueryParameter")
            Log.d("Alex", "host:$host")
            Log.d("Alex", "dataString:$dataString")
            Log.d("Alex", "id:$id")
            Log.d("Alex", "path:$path")
            Log.d("Alex", "path1:$path1")
            Log.d("Alex", "queryString:$queryString")
        }

//        RaPermission().init(1,this).getPermission(object :OnPermissionCall{
//            override fun success() {
//                Toast.makeText(this@MainActivity,"success", Toast.LENGTH_SHORT).show()
//            }
//
//            override fun failed() {
//                Toast.makeText(this@MainActivity,"failed", Toast.LENGTH_SHORT).show()
//            }
//        })


        //Glide.with(this).load("http://goo.gl/gEgYUd").into(viewBing.rv)
        ARouter.getInstance().inject(this)
        initRecycleView(buildRecycleViewData())
        val id = intent.data
        val version = AppUtils(this).getVersion(BuildConfig.APPLICATION_ID)


        viewBing.bt.text = "这是一个按钮$version"

        viewBing.bt.setOnClickListener {

            val ranColor = -0x1000000 or Random.nextInt(0x00ffffff)

            viewBing.bt.setBackgroundColor(ranColor)

//                    val xx = RaPermission().init(1,this)
//            xx.getPermission(object : OnPermissionCall {
//                override fun success() {
//                }
//
//                override fun failed() {
//                }
//
//            })

//            SharedUtil<Any>(this).imageAPP("https://upload-images.jianshu.io/upload_images/3708736-e18ae9e2ab80e87d.png")
//            SharedUtil<Any>(this).toInstallWebView("http://weixin.qq.com/download")
//              ConcreteShareBuilder(this).create().shareText("nihao").show()
//            ConcreteShareBuilder(this).create().shareImage("url").show()
//            val intent = Intent(mContext,MainActivity2::class.java)
//            startActivity(intent)

//            requestPermission()
        }

        viewBing.bt.setOnLongClickListener {
            mdt.notifyDataSetChanged()
//            viewBing.vsTest.visibility = View.GONE
            val request  = OneTimeWorkRequest.Builder(TestWork::class.java).build()
            WorkManager.getInstance(this).enqueue(request)

//            ARouter.getInstance().navigation(FindServices::class.java)
            FindServices().findS()

            return@setOnLongClickListener true
        }

//        addView { li: LayoutInflater, vg: ViewGroup ->
//            println("测试添加addView")
//            val v = li.inflate(R.layout.module_base_gallery_window_base_dialog, vg, false)
//            vg.addView(v)
//        }


    }



    private fun BaseActivity<ActivityMainBinding>.addView( mView: (li: LayoutInflater,vg:ViewGroup) -> Unit){
        mView(this.layoutInflater,viewBing.layoutCst)
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


    private lateinit var  mdt: ViewBindTadapter
    private var mExitTime:Long=0

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
//        LogTag.d(""+ ActivityManager.instance.currentActivity())
        if (keyCode==KeyEvent.KEYCODE_BACK ) {
            if((System.currentTimeMillis().minus(mExitTime).compareTo(2000)) >0){
                mExitTime=System.currentTimeMillis()
//                ToastUtil.showShort(R.string.module_base_gallery_main_exit_app)

            }else{
                CommonUtil.exitApp()
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }


}