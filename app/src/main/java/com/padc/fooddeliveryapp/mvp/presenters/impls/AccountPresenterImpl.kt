package com.padc.fooddeliveryapp.mvp.presenters.impls

import android.graphics.Bitmap
import androidx.lifecycle.LifecycleOwner
import com.padc.fooddeliveryapp.data.models.AuthenticationModel
import com.padc.fooddeliveryapp.data.models.AuthenticationModelImpl
import com.padc.fooddeliveryapp.mvp.presenters.AccountPresenter
import com.padc.fooddeliveryapp.mvp.views.AccountView
import com.padc.shared.mvp.presenter.AbstractBasePresenter

class AccountPresenterImpl : AccountPresenter,AbstractBasePresenter<AccountView>() {
    private val mAuthModel: AuthenticationModel = AuthenticationModelImpl

    override fun onTapUpdateProfile() {
        mView?.openGallery()
    }

    override fun updateUserProfile(bitmap: Bitmap) {
        mAuthModel.uploadPhotoUrl(bitmap,
        onSuccess = {
            mAuthModel.updateUserProfile(it, onSuccess = {data ->
                mView?.showErrorMessage(data)
            }) {errorMsg ->
                mView?.showErrorMessage(errorMsg)
            }
        },
        onFailure = {
            mView?.showErrorMessage(it)
        })
    }



    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        mView?.showUserProfile(mAuthModel.getUserProfile())
    }
}