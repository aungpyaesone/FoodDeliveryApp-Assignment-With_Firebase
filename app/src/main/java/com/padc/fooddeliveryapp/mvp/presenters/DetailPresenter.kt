package com.padc.fooddeliveryapp.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padc.fooddeliveryapp.delegates.FoodItemDelegate
import com.padc.fooddeliveryapp.mvp.views.DetailView
import com.padc.shared.mvp.presenter.BasePresenter

interface DetailPresenter : BasePresenter<DetailView>,FoodItemDelegate {
    fun onUiReady(lifecycleOwner: LifecycleOwner,documentId:String)

    fun onTapGoToCart()
}