package com.padc.fooddeliveryapp.mvp.views

import com.padc.shared.mvp.views.BaseView

interface RegisterView : BaseView {
    fun navigateToHomeScreen()
    fun navigateToLoginScreen()
    fun navigateBack()

}