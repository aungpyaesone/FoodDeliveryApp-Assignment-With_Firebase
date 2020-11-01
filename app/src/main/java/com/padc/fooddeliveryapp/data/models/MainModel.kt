package com.padc.fooddeliveryapp.data.models

import com.padc.fooddeliveryapp.data.vos.BurgerVO
import com.padc.fooddeliveryapp.data.vos.CategoryVO
import com.padc.fooddeliveryapp.data.vos.RestaurantVO
import com.padc.fooddeliveryapp.network.remoteconfigs.FirebaseRemoteConfigManager

interface MainModel {

    var mfirebaseRemoteConfigManager : FirebaseRemoteConfigManager
    fun getAllRestaurants(onSuccess:(List<RestaurantVO>) ->Unit,onFailure:(String) ->Unit)
    fun getAllCategories(onSuccess:(List<CategoryVO>)->Unit,onFailure: (String) -> Unit)
    fun setupRemoteConfigWithDefaultValues()
    fun fetchRemoteConfig()
    fun getViewType() : Int

    fun fetchPopularFoodList(onSuccess:(List<BurgerVO>)->Unit,onFailure: (String) -> Unit)
}