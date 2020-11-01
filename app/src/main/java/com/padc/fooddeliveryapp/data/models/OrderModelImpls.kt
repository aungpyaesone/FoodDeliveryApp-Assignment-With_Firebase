package com.padc.fooddeliveryapp.data.models

import com.padc.fooddeliveryapp.data.vos.BurgerVO
import com.padc.fooddeliveryapp.network.impls.FireStoreImpls

object OrderModelImpls : OrderModel {
    private val mFireStore = FireStoreImpls
    override fun getOrders(onSuccess: (List<BurgerVO>) -> Unit, onFailure: (String) -> Unit) {
        mFireStore.getOrders(onSuccess,onFailure)
    }

    override fun deleteOrderByName(name: String) {
        mFireStore.deleteOrderByName(name)
    }

    override fun addAndUpdate(foodItem: BurgerVO, onSuccess: () -> Unit, onFailure: (String) -> Unit) {
        mFireStore.addOrder(foodItem,onSuccess,onFailure)
    }


}