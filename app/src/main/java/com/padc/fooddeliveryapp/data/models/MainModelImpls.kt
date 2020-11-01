package com.padc.fooddeliveryapp.data.models

import com.padc.fooddeliveryapp.data.vos.BurgerVO
import com.padc.fooddeliveryapp.data.vos.CategoryVO
import com.padc.fooddeliveryapp.data.vos.RestaurantVO
import com.padc.fooddeliveryapp.network.FirebaseApi
import com.padc.fooddeliveryapp.network.impls.FireStoreImpls
import com.padc.fooddeliveryapp.network.impls.FirebaseRealtimeImpls
import com.padc.fooddeliveryapp.network.remoteconfigs.FirebaseRemoteConfigManager

object MainModelImpls : MainModel
{
    private val mFirebaseApi  = FireStoreImpls
    override var mfirebaseRemoteConfigManager: FirebaseRemoteConfigManager = FirebaseRemoteConfigManager

    override fun getAllRestaurants(onSuccess: (List<RestaurantVO>) -> Unit, onFailure: (String) -> Unit) {
        mFirebaseApi.getAllRestaurants(onSuccess,onFailure)
    }

    override fun getAllCategories(onSuccess: (List<CategoryVO>) -> Unit, onFailure: (String) -> Unit) {
        mFirebaseApi.getCategories(onSuccess,onFailure)
    }

    override fun setupRemoteConfigWithDefaultValues() {
        mfirebaseRemoteConfigManager.setupRemoteConfigWithDefaultValues()
    }

    override fun fetchRemoteConfig() {
        mfirebaseRemoteConfigManager.fetchRemoteConfig()
    }

    override fun getViewType(): Int {
        return mfirebaseRemoteConfigManager.getViewType()
    }

    override fun fetchPopularFoodList(onSuccess: (List<BurgerVO>) -> Unit, onFailure: (String) -> Unit) {
        mFirebaseApi.getPopularFoodList(onSuccess,onFailure)
    }
}