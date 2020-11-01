package com.padc.fooddeliveryapp.mvp.views

import com.padc.shared.mvp.views.BaseView

interface LoginView : BaseView {
    fun navigateToHomeScreen()
    fun navigateToRegisterScreen()
    fun navigateToBack()
}