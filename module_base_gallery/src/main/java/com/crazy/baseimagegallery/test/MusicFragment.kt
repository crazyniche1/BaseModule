package com.crazy.baseimagegallery.test

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.crazy.baseimagegallery.R
import com.crazy.baseimagegallery.base.ui.BaseLiveData
import com.crazy.baseimagegallery.base.ui.BaseViewModel
import com.crazy.baseimagegallery.base.ui.fragment.BaseFragment
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: MusicFragment
 * Author: zy
 * Date: 2021/8/3 17:46
 * Description:
 * History:

 */
class MusicFragment: BaseFragment() {
//    private val vmp: BaseViewModel by viewModels()
    private lateinit var vmp: BaseLiveData<String>

    override fun getLayoutId() = R.layout.activity_main

    override fun initView() {
        Toast.makeText(this.context, "MusicFragment", Toast.LENGTH_SHORT).show()

    }

    override fun initData() {

        //Get the ViewModel

        //Create the observer which updates the UI.
        val str= "observer which updates the UI"

         var nameObserver = Observer<String> {
            t: String? ->
             tv_test.text = t

             Toast.makeText(this.context, "$t", Toast.LENGTH_SHORT).show()

        }
//     Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
//        vmp.currentName.observe(this,nameObserver)
//        vmp.currentName.value = str

        button.setOnClickListener {

            var anotherName = "button"
//            vmp.currentName.setValue(anotherName)
        }


        BaseLiveData.getInstance("").observe(viewLifecycleOwner,
            Observer {
                tv_test.text = it.toString()
            })

    }
}