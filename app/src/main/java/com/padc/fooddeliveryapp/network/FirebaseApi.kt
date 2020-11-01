package com.padc.fooddeliveryapp.network

import com.padc.fooddeliveryapp.data.vos.BurgerVO
import com.padc.fooddeliveryapp.data.vos.CategoryVO
import com.padc.fooddeliveryapp.data.vos.RestaurantVO

interface FirebaseApi {
    fun getAllRestaurants(onSuccess: (List<RestaurantVO>) -> Unit,
                          onFailure: (String) -> Unit)

    fun getCategories(onSuccess: (List<CategoryVO>) -> Unit,
                      onFailure: (String) -> Unit)

    fun getBurgerList(docId: String, onSuccess: (List<BurgerVO>) -> Unit, onFailure: (String) -> Unit)

    fun getPopularFoodList(onSuccess: (List<BurgerVO>) -> Unit, onFailure: (String) -> Unit)

    fun addOrder(burgerVO: BurgerVO, onSuccess: () -> Unit, onFailure: (String) -> Unit)

    fun getOrders(onSuccess: (List<BurgerVO>) -> Unit, onFailure: (String) -> Unit)

    fun deleteOrderByName(name: String)

    fun deleteAllOrder(orderList:List<BurgerVO>)
}