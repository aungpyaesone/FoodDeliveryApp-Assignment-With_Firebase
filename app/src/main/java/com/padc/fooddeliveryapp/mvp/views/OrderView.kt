package com.padc.fooddeliveryapp.mvp.views

import com.padc.fooddeliveryapp.data.vos.BurgerVO
import com.padc.shared.mvp.views.BaseView

interface OrderView : BaseView {

    fun showOrderList(orderList:List<BurgerVO>)
    fun showTotalPrice(totalPrice:Int)

    fun showBottomSheet()
}