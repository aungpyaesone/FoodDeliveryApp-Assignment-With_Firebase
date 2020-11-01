package com.padc.fooddeliveryapp.mvp.presenters

import android.graphics.Bitmap
import com.padc.fooddeliveryapp.mvp.views.AccountView
import com.padc.shared.mvp.presenter.BasePresenter

interface AccountPresenter : BasePresenter<AccountView> {
    fun onTapUpdateProfile()
    fun updateUserProfile(bitmap: Bitmap)


}