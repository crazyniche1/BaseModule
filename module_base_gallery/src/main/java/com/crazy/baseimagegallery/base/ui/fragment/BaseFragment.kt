package com.crazy.baseimagegallery.base.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.crazy.baseimagegallery.R
import com.crazy.baseimagegallery.util.StateView

abstract class BaseFragment :Fragment() {

    /** 多状态布局View*/
    private var statusView: StateView? = null
    private lateinit var  rootView: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

         rootView = inflater.inflate(getLayoutId(),null)
        return rootView
    }

     abstract fun getLayoutId():Int

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (isSetStateView()) {
            setStatusLayout()
        }

        initView ()
        initData ()


    }

    /** 显示Loading*/
    fun showLoading() {
        statusView?.showLoading()
    }

    /** 隱藏Loading*/
    fun dismissLoading() {
        statusView?.showContent()
    }

    open fun isSetStateView(): Boolean = true

    private fun setStatusLayout() {
        val contentView: ViewGroup? = rootView.findViewById(R.id.content_id)
        if (contentView != null) {
            statusView = StateView.inject(contentView)
        }
    }

    abstract fun initView()
    abstract fun initData()
}