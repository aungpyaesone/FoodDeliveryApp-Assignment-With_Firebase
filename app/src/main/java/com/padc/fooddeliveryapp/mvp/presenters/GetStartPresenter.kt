package com.padc.fooddeliveryapp.mvp.presenters

import com.padc.fooddeliveryapp.mvp.views.GetStartView
import com.padc.shared.mvp.presenter.BasePresenter

interface GetStartPresenter : BasePresenter<GetStartView> {
    fun onTapGetStart()
}