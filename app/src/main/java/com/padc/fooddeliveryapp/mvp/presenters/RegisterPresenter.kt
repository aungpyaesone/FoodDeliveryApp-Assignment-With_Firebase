package com.padc.fooddeliveryapp.mvp.presenters

import com.padc.fooddeliveryapp.mvp.views.RegisterView
import com.padc.shared.mvp.presenter.BasePresenter

interface RegisterPresenter : BasePresenter<RegisterView> {
    fun onTapRegister(email:String,password:String,userName:String)
    fun onTapLogin()
    fun onTapBack()
}