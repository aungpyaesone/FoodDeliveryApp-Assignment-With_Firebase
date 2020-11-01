package com.padc.fooddeliveryapp.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.padc.fooddeliveryapp.mvp.presenters.IntroPresenter
import com.padc.fooddeliveryapp.mvp.views.IntroView
import com.padc.shared.mvp.presenter.AbstractBasePresenter

class IntroPresenterImpl : IntroPresenter,AbstractBasePresenter<IntroView>() {
    override fun onTapCreateAccount() {
        mView?.navigateToRegisterScreen()
    }

    override fun onTapLogin() {
        mView?.navigateToLoginScreen()
    }

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {

    }

}