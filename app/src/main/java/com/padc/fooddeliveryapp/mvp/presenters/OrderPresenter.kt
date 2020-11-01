package com.padc.fooddeliveryapp.mvp.presenters

import com.padc.fooddeliveryapp.delegates.OrderItemDelegate
import com.padc.fooddeliveryapp.mvp.views.OrderView
import com.padc.shared.mvp.presenter.BasePresenter

interface OrderPresenter : BasePresenter<OrderView>,OrderItemDelegate {
    fun onTapCheckOut()
}