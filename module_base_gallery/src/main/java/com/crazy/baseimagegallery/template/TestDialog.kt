package com.crazy.baseimagegallery.template

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.viewbinding.ViewBinding
import com.crazy.baseimagegallery.R
import com.crazy.baseimagegallery.databinding.ModuleBaseGalleryWindowBaseDialogBinding
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
class TestDialog  : BaseDialog<ModuleBaseGalleryWindowBaseDialogBinding>(ModuleBaseGalleryWindowBaseDialogBinding::inflate){


    override fun mOnViewCreated(
        view: ModuleBaseGalleryWindowBaseDialogBinding,
        savedInstanceState: Bundle?
    ) {

        view.txSureLabel.setOnClickListener {
            ToastUtil.showShort("sure")
        }

        view.txSureLabel.setOnClickListener {
            ToastUtil.showShort("cancel")
        }
    }
}