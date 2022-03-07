package com.crazy.baseimagegallery.util.popupwindows

import android.annotation.SuppressLint
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.util.Log
import android.view.*
import android.widget.PopupWindow
import androidx.core.widget.PopupWindowCompat
import androidx.viewbinding.ViewBinding
import org.jetbrains.annotations.TestOnly


/**
 * Copyright (C), 2015-2022, 博彦科技
 * FileName: BasePopUpWindow
 * Author: zy
 * Date: 2022/2/28 17:03
 * Description:
 *  目前不支持  内部嵌套EditView
 *  2022.03.07 new add viewBinding 需要优化 ，继承的类传参过复杂
 * History:

 */
abstract class BasePopUpWindow <VB: ViewBinding>: PopUpWindowCallback {

//    private val layoutView:View = block()
//    private val binding: VB by lazy {inflate(layoutInflater)}
    lateinit var anchorView:View

    private var pw: PopupWindow? = null
    /**
     * 默认左上角视图
     */
    @TestOnly
    private fun initView( ) {
        initView(ViewGroup.LayoutParams.WRAP_CONTENT,  ViewGroup.LayoutParams.WRAP_CONTENT)
    }


    /**
     * isTouchable 获取焦点
     * isOutsideTouchable响应Windows外部点击
     */
    @SuppressLint("ClickableViewAccessibility")
    private fun initView(width:Int, height:Int) {
        if (anchorView==null){
            Exception("the view on which to pin the popup window is not  null ")
        }
        pw =PopupWindow(onBindingAndAnchor().root,width, height,true)
        PopupWindowCompat.showAsDropDown(pw!!,anchorView, 10, 10,  Gravity.CENTER)
        pw?.setBackgroundDrawable(ColorDrawable(0x00000000))

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            pw?.isOutsideTouchable =true
            pw?.isTouchable =true
        }else{
            /**
             * pw?.setTouchInterceptor 无效  ，采用pw?.contentView?.setOnTouchListener
             * 该监听解决 android 6 以前 点击popupwindows 的其他区域 windows不消失的问题
             */
            pw?.contentView?.setOnTouchListener {  _, event ->
                val x = event.x.toInt()
                val y = event.y.toInt()
                val mWidth = pw?.contentView?.measuredWidth
                val mHeight = pw?.contentView?.measuredHeight
                if (event.action != KeyEvent.KEYCODE_UNKNOWN || x >= KeyEvent.KEYCODE_UNKNOWN && x < mWidth!! && y >= KeyEvent.KEYCODE_UNKNOWN && y < mHeight!!) {
                    if (event.action == KeyEvent.KEYCODE_BACK) {
                        Log.e("ForwardPopWindow", "out side ...")
                        return@setOnTouchListener true
                    } else {
                        return@setOnTouchListener  false
                    }
                } else {
                    cancel()
                    return@setOnTouchListener true
                }
            }

        }
        onBack()

        getView(onBindingAndAnchor())

    }

    private fun onBack() {
        //拦截系统返回事件
        pw?.isFocusable = true
        pw?.contentView?.isFocusable = true
        //必须设置获取焦点模式 否则无法拦截setOnKeyListener
        pw?.contentView?.isFocusableInTouchMode = true
//        pw?.setBackgroundDrawable(null)
        pw?.contentView?.setOnKeyListener { v, keyCode, event ->
            if (keyCode== KeyEvent.KEYCODE_BACK){
                cancel()
                return@setOnKeyListener true

            }
            return@setOnKeyListener false
        }

    }

    /**
     * 当 Windows中有editView时
     * windows 会被输入法指顶 SOFT_INPUT_ADJUST_RESIZE
     */
    fun inputTop() {
        pw?.inputMethodMode = PopupWindow.INPUT_METHOD_NEEDED
        pw?.softInputMode = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE
    }

    abstract fun getView(layoutView:VB )
    // viewBinding 绑定 和 传入加载视图
    abstract fun onBindingAndAnchor() :VB

    override fun show() {
        if (pw?.isShowing != true){
            initView( )
            pw?.update()
        }
    }

    override fun cancel() {
        pw?.dismiss()
    }
}

interface PopUpWindowCallback {
    fun show()
    fun cancel()
}