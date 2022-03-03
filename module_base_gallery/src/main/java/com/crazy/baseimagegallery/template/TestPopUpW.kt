package com.crazy.baseimagegallery.template

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.viewbinding.ViewBinding
import com.crazy.baseimagegallery.R
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
class TestPopUpW(anchorView:View, block:()->View) :BasePopUpWindow(anchorView,block) {

    override fun getView(layoutView: View) {
        val tc = layoutView.findViewById<TextView>(R.id.tx_cancel_label)
        val ts = layoutView.findViewById<TextView>(R.id.tx_sure_label)

        tc.setOnClickListener {
            ToastUtil.showShort("tx_cancel_label")
        }
        ts.setOnClickListener {
            ToastUtil.showShort("tx_sure_label")
        }
    }
}