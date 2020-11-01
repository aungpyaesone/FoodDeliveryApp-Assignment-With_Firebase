package com.padc.fooddeliveryapp.mvp.presenters

import com.padc.fooddeliveryapp.delegates.FoodItemDelegate
import com.padc.fooddeliveryapp.delegates.RestaurantItemDelegate
import com.padc.fooddeliveryapp.mvp.views.HomeView
import com.padc.shared.mvp.presenter.BasePresenter

interface HomePresenter : BasePresenter<HomeView>,RestaurantItemDelegate,FoodItemDelegate {
}