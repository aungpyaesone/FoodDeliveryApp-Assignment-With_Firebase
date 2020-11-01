package com.padc.fooddeliveryapp.mvp.views

import com.padc.shared.mvp.views.BaseView

interface IntroView : BaseView {
    fun navigateToLoginScreen()
    fun navigateToRegisterScreen()
}