package com.crazy.baseimagegallery.template

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.viewbinding.ViewBinding
import com.crazy.baseimagegallery.R
import com.crazy.baseimagegallery.databinding.ModuleBaseGalleryWindowBaseDialogBinding
import com.crazy.baseimagegallery.util.popupwindows.BasePopUpWindow
import com.crazy.baseimagegallery.util.toast.ToastUtil

/**
 * Copyright (C), 2015-2022, 博彦科技
 * FileName: TestPopUpW
 * Author: zy
 * Date: 2022/3/1 10:56
 * Description:
 * History:

 */
class TestPopUpW(private val av:View,private val lif:LayoutInflater) :BasePopUpWindow<ModuleBaseGalleryWindowBaseDialogBinding>() {

    override fun getView(layoutView: ModuleBaseGalleryWindowBaseDialogBinding) {
        layoutView.txSureLabel.setOnClickListener {
            ToastUtil.showShort("txSureLabel****")
        }
    }

    override fun onBindingAndAnchor(): ModuleBaseGalleryWindowBaseDialogBinding {
        //这里进行的set 赋值
        anchorView = av
        return  ModuleBaseGalleryWindowBaseDialogBinding.inflate(lif)
    }

}