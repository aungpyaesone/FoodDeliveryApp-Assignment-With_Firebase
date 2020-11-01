package com.padc.fooddeliveryapp.delegates

import com.padc.fooddeliveryapp.data.vos.BurgerVO

interface FoodItemDelegate {
    fun onTapFoodItem(foodItem: BurgerVO)
}