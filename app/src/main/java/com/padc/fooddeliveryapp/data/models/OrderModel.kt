package com.padc.fooddeliveryapp.data.models

import com.padc.fooddeliveryapp.data.vos.BurgerVO

interface OrderModel {
    fun getOrders(onSuccess:(List<BurgerVO>)->Unit, onFailure: (String) -> Unit)
    fun deleteOrderByName(name:String)

    fun addAndUpdate(foodItem: BurgerVO,onSuccess:()->Unit,onFailure: (String) -> Unit)

}