package com.crazy.baseimagegallery.test

import com.crazy.baseimagegallery.mvp.presenter.MVPBasePresenter
import com.crazy.baseimagegallery.mvp.view.MVPBaseView

/**
 * Copyright (C), 2015-2021, 博彦科技
 * FileName: Contract
 * Author: zy
 * Date: 2021/6/23 17:43
 * Description:
 * History:

 */
interface Contract {

    interface View : MVPBaseView {
        fun showSongList(data: List<String>)

    }

    interface Presenter : MVPBasePresenter {
        fun getSongList(id: String, offset: Int)
    }
}