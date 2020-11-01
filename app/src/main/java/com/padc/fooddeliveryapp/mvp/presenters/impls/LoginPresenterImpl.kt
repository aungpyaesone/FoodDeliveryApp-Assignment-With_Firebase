package com.padc.fooddeliveryapp.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.padc.fooddeliveryapp.data.models.AuthenticationModel
import com.padc.fooddeliveryapp.data.models.AuthenticationModelImpl
import com.padc.fooddeliveryapp.data.models.MainModel
import com.padc.fooddeliveryapp.data.models.MainModelImpls
import com.padc.fooddeliveryapp.mvp.presenters.LoginPresenter
import com.padc.fooddeliveryapp.mvp.views.LoginView
import com.padc.shared.mvp.presenter.AbstractBasePresenter

class LoginPresenterImpl : LoginPresenter, AbstractBasePresenter<LoginView>() {

    private val mAuthenticationModel: AuthenticationModel = AuthenticationModelImpl
    private val mMainModel : MainModel = MainModelImpls

    override fun onUiReady(owner: LifecycleOwner) {
        mMainModel.setupRemoteConfigWithDefaultValues()
        mMainModel.fetchRemoteConfig()
    }

    override fun onTapLogin(email: String, password: String) {
        mView?.showLoading()
        mAuthenticationModel.login(email, password, onSuccess = {
            mView?.hideLoading()
            mView?.navigateToHomeScreen()
        }, onFailure = {
            mView?.hideLoading()
            mView?.showErrorMessage(it)
        })
    }

    override fun onTapRegister() {
        mView?.navigateToRegisterScreen()
    }

    override fun onTapBack() {
        mView?.navigateToBack()
    }
}