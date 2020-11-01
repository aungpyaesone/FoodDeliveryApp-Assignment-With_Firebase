package com.padc.fooddeliveryapp.data.models

import com.padc.fooddeliveryapp.data.vos.BurgerVO

interface CheckoutModel {
    fun deleteAllOrder(orderList:List<BurgerVO>)
}