package com.padc.fooddeliveryapp.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.padc.fooddeliveryapp.mvp.presenters.GetStartPresenter
import com.padc.fooddeliveryapp.mvp.views.GetStartView
import com.padc.shared.mvp.presenter.AbstractBasePresenter

class GetStartPresenterImpl : GetStartPresenter,AbstractBasePresenter<GetStartView>() {
    override fun onTapGetStart() {
        mView?.navigateToIntroScreen()
    }

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {

    }
}