package com.padc.fooddeliveryapp.data.models

import com.padc.fooddeliveryapp.data.vos.BurgerVO
import com.padc.fooddeliveryapp.network.impls.FireStoreImpls

object CheckoutModelImpls : CheckoutModel {
    private val mFirestore = FireStoreImpls
    override fun deleteAllOrder(orderList: List<BurgerVO>) {
      mFirestore.deleteAllOrder(orderList)
    }
}