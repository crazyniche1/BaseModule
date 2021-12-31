package com.crazy.baseimagegallery.template

import android.text.Editable
import android.text.TextWatcher
import com.beyondsoft.smarthome.utils.logs.LogTag
import com.crazy.baseimagegallery.base.ui.activity.BaseActivity
import com.crazy.baseimagegallery.databinding.ActivityMainBinding
import com.crazy.baseimagegallery.http.net.NetManager
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception

class TMainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initView() {
        viewBing.button.setOnClickListener {
//            SharedUtil<Any>(this,).image("https://upload-images.jianshu.io/upload_images/3708736-e18ae9e2ab80e87d.png?imageMogr2/auto-orient/strip|imageView2/2/w/345/format/webp")
            requestNet()
        }

        viewBing.etv.addTextChangedListener(object :xxx(){
            override fun afterTextChanged(s: Editable?) {
                super.afterTextChanged(s)
            }
        })

    }

    private fun requestNet() {
        GlobalScope.launch {
            try {
                val ss = NetManager.initRetrofit.homeBanner()
                val  data =ss.data
                for ((i,e) in data?.withIndex()!!){
                    data[i]
                }
                LogTag.d("Data${ss.data}")

            }catch (e:Exception){
                LogTag.e("Data${e}")
            }

        }
    }

    override fun initData() {

    }

}

open class xxx :TextWatcher{
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }

    override fun afterTextChanged(s: Editable?) {
    }

}