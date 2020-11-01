package com.padc.fooddeliveryapp.delegates

import com.padc.fooddeliveryapp.data.vos.RestaurantVO

interface RestaurantItemDelegate {
    fun onTapRestaurantItem(restaurantVO: RestaurantVO)
}