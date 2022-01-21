package com.crazy.baseimagegallery.template

import com.crazy.baseimagegallery.http.net.util.RequestGenerateUtils
import android.text.Editable
import android.text.TextWatcher
import androidx.annotation.MainThread
import com.beyondsoft.smarthome.utils.logs.LogTag
import com.crazy.baseimagegallery.base.ui.activity.BaseActivity
import com.crazy.baseimagegallery.databinding.ActivityMainBinding
import com.crazy.baseimagegallery.http.net.NetManager
import com.crazy.baseimagegallery.http.net.apiCall
import com.crazy.baseimagegallery.util.toast.ToastUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class TMainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun isSetStateView(): Boolean =true

    override fun initView() {
        viewBing.button.setOnClickListener {
//            SharedUtil<Any>(this,).image("https://upload-images.jianshu.io/upload_images/3708736-e18ae9e2ab80e87d.png?imageMogr2/auto-orient/strip|imageView2/2/w/345/format/webp")
//            requestNet()
            showLoading()
            viewBing.button.postDelayed({
                dismissLoading()
            },3000L)

        }

    }
    private  fun requestNet() {



        val job = GlobalScope.launch {
            try {
                val hashMap = RequestGenerateUtils.requestParams()

                hashMap["username"] = "shuangan001"
                hashMap["password"] ="123456abc"


//                val  data =ss.data
                val res = apiCall { NetManager.instance.initRetrofit.homeBanner() }
                LogTag.d("Data_____${res}")
                launch(Dispatchers.Main){
                    ToastUtil.showShort(""+res)
                }
//                ToastUtil.showShort(""+res.msg)
//                LogTag.d("Data_____${res.data}${res.msg}")
//                for ((i,e) in res.data?.withIndex()!!){
//                    LogTag.d("Data_____${e.avatarUrl}")
//                }
//                val url = "https://www.jianshu.com/shakespeare/v2/notes/2919bdb8d09a/book"
//                val res1 = apiCall { NetManager.instance.initRetrofit.homeBanner() }
//                LogTag.d("Data1_____${res1}")

            }catch (e:Exception){
                LogTag.e("Data_EX:${e}")
            }

        }

        if (job.isCancelled)job.cancel()
    }

    override fun initData() {

    }

}
