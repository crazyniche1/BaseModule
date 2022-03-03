package com.binjiang.smarthome.utils.widget.customDialog.base

import android.view.View

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: OnClickListener
 * Author: zy
 * Date: 2021/10/11 16:26
 * Description: dialog 所有类型监听
 * History:

 */
interface OnClickListener {


    interface OnButtonClickListener{

        fun onSureClick(v: View?)
        fun onCancelClick(v: View?)
    }

    interface ButtonClickListener {
        fun onSureClick(view: View?, ss: String?)
        fun onCancelClick(view: View?)
    }
}