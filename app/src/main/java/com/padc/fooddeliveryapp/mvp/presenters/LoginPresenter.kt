package com.padc.fooddeliveryapp.mvp.presenters

import com.padc.fooddeliveryapp.mvp.views.LoginView
import com.padc.shared.mvp.presenter.BasePresenter

interface LoginPresenter : BasePresenter<LoginView> {
    fun onTapLogin(email:String, password:String)
    fun onTapRegister()
    fun onTapBack()
}