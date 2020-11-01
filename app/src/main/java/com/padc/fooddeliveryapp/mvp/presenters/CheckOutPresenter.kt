package com.padc.fooddeliveryapp.mvp.presenters

import com.padc.fooddeliveryapp.data.vos.BurgerVO
import com.padc.fooddeliveryapp.mvp.views.CheckOutView
import com.padc.shared.mvp.presenter.BasePresenter

interface CheckOutPresenter : BasePresenter<CheckOutView> {

    fun onTapTrackOrder(orderList:List<BurgerVO>)
}