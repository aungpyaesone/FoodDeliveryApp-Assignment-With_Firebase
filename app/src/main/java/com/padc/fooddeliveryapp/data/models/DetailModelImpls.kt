package com.padc.fooddeliveryapp.data.models

import com.padc.fooddeliveryapp.data.vos.BurgerVO
import com.padc.fooddeliveryapp.network.impls.FireStoreImpls

object DetailModelImpls : DetailModel {

    private val mFirestore = FireStoreImpls

    override fun getFoodItems(docId: String, onSuccess: (List<BurgerVO>) -> Unit, onFailure: (String) -> Unit) {
        mFirestore.getBurgerList(docId,onSuccess,onFailure)
    }

    override fun addOrder(foodItem: BurgerVO, onSuccess: () -> Unit, onFailure: (String) -> Unit) {
        mFirestore.addOrder(foodItem,onSuccess,onFailure)
    }

}