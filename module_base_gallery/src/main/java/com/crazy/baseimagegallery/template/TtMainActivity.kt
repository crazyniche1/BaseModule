package com.crazy.baseimagegallery.template

import com.beyondsoft.smarthome.utils.logs.LogTag
import com.crazy.baseimagegallery.databinding.ActivityMainBinding
import com.crazy.baseimagegallery.mvvm.view.BaseVMActivity


class TtMainActivity : BaseVMActivity<ActivityMainBinding>() {

    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun isSetStateView(): Boolean =true

    override fun initView() {
        viewBing.button.setOnClickListener {
//            SharedUtil<Any>(this,).image("https://upload-images.jianshu.io/upload_images/3708736-e18ae9e2ab80e87d.png?imageMogr2/auto-orient/strip|imageView2/2/w/345/format/webp")
//            requestNet()
//            showLoading()
            viewBing.button.postDelayed({
                dismissLoading()
            },3000L)

        }

    }

    override fun initData() {

        //get vm
//        val vmp = ViewModelProvider(this)
//        val tvVM= vmp[TestViewMode::class.java]
        val tvVM= getActivityScopeViewModel(TestViewMode::class.java)

        tvVM.test1Request()

        tvVM.mWanLiveData.observe(this){
            for (i in it.withIndex()){
                LogTag.d("test:::"+tvVM.mWanLiveData.toString())
            }
        }
        tvVM.errorInfo.observe(this){
            LogTag.d("err_test:::"+it.toString())
        }


    }

}
