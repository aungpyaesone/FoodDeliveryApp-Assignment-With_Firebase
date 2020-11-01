package com.padc.fooddeliveryapp.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.padc.fooddeliveryapp.data.models.CheckoutModel
import com.padc.fooddeliveryapp.data.models.CheckoutModelImpls
import com.padc.fooddeliveryapp.data.vos.BurgerVO
import com.padc.fooddeliveryapp.mvp.presenters.CheckOutPresenter
import com.padc.fooddeliveryapp.mvp.views.CheckOutView
import com.padc.shared.mvp.presenter.AbstractBasePresenter

class CheckOutPresenterImpl : CheckOutPresenter,AbstractBasePresenter<CheckOutView>() {
    private val mChekoutModel = CheckoutModelImpls

    override fun onTapTrackOrder(orderList: List<BurgerVO>) {
        mChekoutModel.deleteAllOrder(orderList)
    }

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {

    }
}