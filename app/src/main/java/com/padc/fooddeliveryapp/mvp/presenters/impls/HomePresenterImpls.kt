package com.padc.fooddeliveryapp.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.padc.fooddeliveryapp.data.models.MainModelImpls
import com.padc.fooddeliveryapp.data.vos.BurgerVO
import com.padc.fooddeliveryapp.data.vos.RestaurantVO
import com.padc.fooddeliveryapp.mvp.presenters.HomePresenter
import com.padc.fooddeliveryapp.mvp.views.HomeView
import com.padc.shared.mvp.presenter.AbstractBasePresenter

class HomePresenterImpls : HomePresenter,AbstractBasePresenter<HomeView>() {
    private val mMainModel = MainModelImpls

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        mMainModel.getAllRestaurants(onSuccess = {
            mView?.showRestaurantList(it)
        },onFailure = {
            mView?.showErrorMessage(it)
        })

        mMainModel.getAllCategories(onSuccess = {
            mView?.showCategoryList(it)
        },onFailure = {
            mView?.showErrorMessage(it)
        })

        mMainModel.fetchPopularFoodList(onSuccess = {
            mView?.showPopularFoodList(it)
        },onFailure = {
           // mView?.showErrorMessage(it)
        })

        mView?.displayViewType(mMainModel.getViewType())
    }

    override fun onTapRestaurantItem(restaurantVO: RestaurantVO) {
        mView?.navigateToDetailScreen(restaurantVO)
        restaurantVO.name?.let { mView?.showErrorMessage(it) }
    }

    override fun onTapFoodItem(foodItem: BurgerVO) {

    }


}