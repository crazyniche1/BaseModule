package com.crazy.baseimagegallery.base.ui.activity

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.view.KeyEvent
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.beyondsoft.smarthome.utils.logs.LogTag
import com.crazy.baseimagegallery.R
import com.crazy.baseimagegallery.databinding.ActivityMainBinding
import com.crazy.baseimagegallery.databinding.LayoutBaseBinding
import com.crazy.baseimagegallery.template.TMainActivity
import com.crazy.baseimagegallery.util.StateView
import com.crazy.baseimagegallery.util.activity.ActivityManager
import com.gyf.immersionbar.ImmersionBar


/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: BaseActivity
 * Author: zy
 * Date: 2021/6/23 17:27
 * Description:
 * History:

 */
abstract class BaseActivity <V:ViewBinding>  :AppCompatActivity() {

    /** 视图绑定布局 */
    private var _binding: V? =null
    val viewBing get() = _binding!!

    lateinit var baseBinding: LayoutBaseBinding

    /** 多状态布局View*/
    private var statusView: StateView? = null

    var mContext: Context? = null
    /**
     * 是否设置多状态View 默认为false
     * @return Boolean true:设置
     */
    open fun isSetStateView(): Boolean = false

    /** 初始化操作，在onCreate中调用*/
    open fun initOperate() {}

    /** 设置布局id
    abstract fun getLayoutId(): Int
     */

    /**初始化视图*/
    abstract fun initView()

    /** 初始化数据*/
    abstract fun initData()

    /** 设置监听 */
    open fun setListener() {}

    /** 显示Loading*/
    fun showLoading() {
        statusView?.showLoading()
    }

    /** 隱藏Loading*/
    fun dismissLoading() {
        statusView?.showContent()
    }

    /** 是都设置沉浸式状态来，true：设置，默认为设置*/
    open fun isSetStateBar() = true

    /**
     * 是否设置布局与状态栏之间的paddingTop,默认值为true
     * @return Boolean
     */
    open fun isSetPaddingTop(): Boolean = true

    /**
     * 这里可以使用反射加 扩展函数
     * 参考 郭林文章：https://blog.csdn.net/c10WTiybQ1Ye3/article/details/112690188
     * */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mContext = this
        //加入Activity管理器
        ActivityManager.instance.addActivity(this)
        _binding = getViewBinding()
        setContentView(viewBing.root)

        if (isSetStateBar()) {
            setStatusBar()
        }
        initOperate()

        if (isSetStateView()) {
            setStatusLayout()
        }
        initView()
        initData()
        setListener()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
        ActivityManager.instance.removeActivity(this)
    }
    /**
     * ActivityMainBinding.inflate(layoutInflater)
     */
    protected abstract fun getViewBinding(): V
//    protected abstract val getViewBinding():(LayoutInflater)->V

    /**
     * 设置透明状态栏
     */
    private fun setStatusBar() {
        ImmersionBar.with(this)
            //原理：如果当前设备支持状态栏字体变色，会设置状态栏字体为黑色，如果当前设备不支持状态栏字体变色，会使当前状态栏加上透明度，否则不执行透明度
            .statusBarDarkFont(true, 0.2f)
            .navigationBarColor(android.R.color.white)
            .keyboardEnable(true)
            .init()
        //添加内容布局距离屏幕的距离
        if (isSetPaddingTop()) {
            val rootView = this.window.decorView.findViewById(android.R.id.content) as ViewGroup
            rootView.setPadding(
                0,
                ImmersionBar.getStatusBarHeight(this),
                0,
                0
            )
            rootView.setBackgroundColor(resources.getColor(R.color.common_white))
        }
    }

    /**
     * 当一个page，上下滑动导致bar 变色， 需要根据bar的高度变化去实时的变化bar状态栏的字体颜色
     * 实时变色
     *
     */
    private fun changeBarColor(){

        ImmersionBar.with(this).statusBarDarkFont(true, 0.2f).init()
    }

    /** 配置多状态布局*/
    private fun setStatusLayout() {
        statusView = StateView.inject(findViewById(R.id.content_id))
    }

}