package com.padc.fooddeliveryapp.mvp.views

import com.padc.fooddeliveryapp.data.vos.BurgerVO
import com.padc.fooddeliveryapp.data.vos.CategoryVO
import com.padc.fooddeliveryapp.data.vos.RestaurantVO
import com.padc.shared.mvp.views.BaseView

interface HomeView : BaseView {

    fun showRestaurantList(restaurantList : List<RestaurantVO>)
    fun showCategoryList(categoryList: List<CategoryVO>)
    fun showPopularFoodList(popularFoodList:List<BurgerVO>)
    fun navigateToDetailScreen(restaurantVO: RestaurantVO)
    fun displayViewType(viewType:Int)
}