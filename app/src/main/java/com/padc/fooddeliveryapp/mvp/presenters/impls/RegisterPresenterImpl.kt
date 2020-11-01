package com.padc.fooddeliveryapp.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.padc.fooddeliveryapp.data.models.AuthenticationModel
import com.padc.fooddeliveryapp.data.models.AuthenticationModelImpl
import com.padc.fooddeliveryapp.mvp.presenters.RegisterPresenter
import com.padc.fooddeliveryapp.mvp.views.RegisterView
import com.padc.fooddeliveryapp.network.auth.AuthManager
import com.padc.fooddeliveryapp.network.auth.AuthenticationManagerImpl
import com.padc.shared.mvp.presenter.AbstractBasePresenter

class RegisterPresenterImpl : RegisterPresenter,AbstractBasePresenter<RegisterView>() {
    private val mAuthenticationModel : AuthenticationModel = AuthenticationModelImpl
    override fun onTapRegister(email: String, password: String, userName: String) {
        mView?.showLoading()
        mAuthenticationModel.register(email,password,userName,onSuccess = {
            mView?.hideLoading()
            mView?.navigateToHomeScreen()
        },
        onFailure = {
            mView?.hideLoading()
            mView?.showErrorMessage(it)
        })
    }

    override fun onTapLogin() {
       mView?.navigateToLoginScreen()
    }

    override fun onTapBack() {
        mView?.navigateBack()
    }

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {

    }
}