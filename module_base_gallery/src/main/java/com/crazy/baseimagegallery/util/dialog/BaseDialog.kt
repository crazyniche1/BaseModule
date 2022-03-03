package com.crazy.baseimagegallery.util.dialog

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.FrameLayout
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.crazy.baseimagegallery.R
import java.lang.Exception


/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: CustomDialog
 * Author: zy
 * Date: 2021/3/15 17:41
 * Description:Dialog的抽象基类
 * 使用 ：继承自 BaseDialog  重写
 * History:

 */
  abstract class BaseDialog : DialogFragment(), View.OnClickListener {

    private val mTag: String = "tag"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.ModuleBaseGalleryAppTheme_dialogStyle)
        //在onCreate或者onCreateView都可以 setStyle
//        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
//        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.RED))
//        dialog?.window?.setDimAmount(0.5f)//背景黑暗度
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //设置背景为透明
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return inflater.inflate(layoutResId, container)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mOnViewCreated(view,savedInstanceState)
    }

    open fun show(SupportFragmentManager: FragmentManager) {
        show(SupportFragmentManager,mTag)
    }

    override fun onClick(v: View?) {}


    //布局ID
    abstract  var layoutResId:Int
    //附加视图
    abstract  fun mOnViewCreated (view: View, savedInstanceState: Bundle?)

}