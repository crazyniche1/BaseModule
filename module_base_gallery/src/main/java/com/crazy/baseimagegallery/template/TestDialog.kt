package com.crazy.baseimagegallery.template

import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.crazy.baseimagegallery.R
import com.crazy.baseimagegallery.util.dialog.BaseDialog
import com.crazy.baseimagegallery.util.toast.ToastUtil

/**
 * Copyright (C), 2015-2022, 博彦科技
 * FileName: TestDialog
 * Author: zy
 * Date: 2022/2/28 17:40
 * Description:
 * History:

 */
class TestDialog : BaseDialog() {

    override var layoutResId: Int = R.layout.module_base_gallery_window_base_dialog

    override fun mOnViewCreated(view: View, savedInstanceState: Bundle?) {

        val sure = view.findViewById<TextView>(R.id.tx_sure_label)
        val cancel = view.findViewById<TextView>(R.id.tx_cancel_label)

        sure.setOnClickListener {
            ToastUtil.showShort("sure")
        }

        cancel.setOnClickListener {
            ToastUtil.showShort("cancel")
        }
    }
}