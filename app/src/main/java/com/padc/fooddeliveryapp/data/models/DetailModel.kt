package com.padc.fooddeliveryapp.data.models

import com.padc.fooddeliveryapp.data.vos.BurgerVO

interface DetailModel {
    fun getFoodItems(docId:String,onSuccess:(List<BurgerVO>)->Unit,onFailure:(String)->Unit)

    fun addOrder(foodItem: BurgerVO,onSuccess:()->Unit,onFailure: (String) -> Unit)

}