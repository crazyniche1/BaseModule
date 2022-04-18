package com.crazy.baseimagegallery.util.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import androidx.viewbinding.ViewBinding
import com.crazy.baseimagegallery.R


/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: CustomDialog
 * Author: zy
 * Date: 2021/3/15 17:41
 * Description:Dialog的抽象基类
 * 使用 ：继承自 BaseDialog  重写
 * History:
 * 1.0 DialogFragment封装并抽象  ，后续只需要继承该基类即可
 * 2.0 加入ViewBinding
 *
 * ps:
 *
 * @link com.crazy.baseimagegallery.template.TestDialog
 *
 *  class TestDialog  : BaseDialog<ModuleBaseGalleryWindowBaseDialogBinding>(ModuleBaseGalleryWindowBaseDialogBinding::inflate){
 *       override fun mOnViewCreated(
 *       view: ModuleBaseGalleryWindowBaseDialogBinding,
 *       savedInstanceState: Bundle?
 *       ) {
 *
 *       view.txSureLabel.setOnClickListener {
 *       ToastUtil.showShort("sure")
 *       }
 *
 *       view.txSureLabel.setOnClickListener {
 *       ToastUtil.showShort("cancel")
 *       }
 *   }
 * }
 *
 * use:
 *  TestDialog().show(this.supportFragmentManager)
 *

 */
abstract class BaseDialog <VB:ViewBinding> (val inflate : (LayoutInflater) -> VB): DialogFragment(), View.OnClickListener {

    private val mTag: String = "tag"

    private val binding: VB by lazy {inflate(layoutInflater)}

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
//        inflater.inflate(getViewBinding.root, container)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mOnViewCreated(binding,savedInstanceState)
    }

    open fun show(SupportFragmentManager: FragmentManager) {
        show(SupportFragmentManager,mTag)
    }

    override fun onClick(v: View?) {}

    //布局ID
//    abstract  var layoutResId:Int
//    abstract  var getViewBinding: ViewBinding
    //附加视图
    abstract  fun mOnViewCreated (view: VB, savedInstanceState: Bundle?)

}