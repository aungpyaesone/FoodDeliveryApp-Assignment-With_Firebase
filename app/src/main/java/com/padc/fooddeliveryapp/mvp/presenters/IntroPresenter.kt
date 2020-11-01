package com.padc.fooddeliveryapp.mvp.presenters

import com.padc.fooddeliveryapp.mvp.views.IntroView
import com.padc.shared.mvp.presenter.BasePresenter

interface IntroPresenter : BasePresenter<IntroView> {
    fun onTapCreateAccount()
    fun onTapLogin()
}