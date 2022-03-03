package com.crazy.baseimagegallery.base.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.crazy.baseimagegallery.R
import com.crazy.baseimagegallery.util.StateView

/**
 * 2.22.2.25 通过抽象接口获取R.layout.id 变为ViewBing 模式
 *
 * 或参考Navigation 导航，，可视化，自动处理 集中处理 ；
 * 但如果业务需求变态，可自定义一个管理Fragment的容器进行管理；
*/
abstract class BaseFragment <VB: ViewBinding>  :Fragment() {

    /** 多状态布局View*/
    private var statusView: StateView? = null
    private var _binding: VB? = null
    val viewBing get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//         rootView = inflater.inflate(getLayoutId(),null)
        _binding = getViewBinding()
        return viewBing.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (isSetStateView()) {
            setStatusLayout()
        }

        initView ()
        initData ()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
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
        val contentView: ViewGroup? = viewBing.root.findViewById(R.id.content_id)
        if (contentView != null) {
            statusView = StateView.inject(contentView)
        }
    }

    abstract fun initView()
    abstract fun initData()

    abstract fun getViewBinding(): VB
}