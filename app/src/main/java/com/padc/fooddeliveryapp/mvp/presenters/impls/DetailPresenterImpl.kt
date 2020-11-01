package com.padc.fooddeliveryapp.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.padc.fooddeliveryapp.data.models.DetailModelImpls
import com.padc.fooddeliveryapp.data.vos.BurgerVO
import com.padc.fooddeliveryapp.mvp.presenters.DetailPresenter
import com.padc.fooddeliveryapp.mvp.views.DetailView
import com.padc.shared.mvp.presenter.AbstractBasePresenter

class DetailPresenterImpl : DetailPresenter, AbstractBasePresenter<DetailView>() {

    private val mDetailModel = DetailModelImpls
    override fun onUiReady(lifecycleOwner: LifecycleOwner, documentId: String) {
        mDetailModel.getFoodItems(documentId, onSuccess = {
            mView?.showPopularChoiceList(it.filter { data -> data.popular == true })
            mView?.showDetailList(it)
        },
                onFailure = {
                    mView?.showErrorMessage(it)
                })


    }

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
    }

    override fun onTapGoToCart() {
        mView?.navigateToOrderScreen()
    }

    override fun onTapFoodItem(foodItem: BurgerVO) {
        mDetailModel.addOrder(foodItem, onSuccess = {
            mView?.showAddToCart()
        }, onFailure = {
            mView?.showErrorMessage(it)
        })
    }
}