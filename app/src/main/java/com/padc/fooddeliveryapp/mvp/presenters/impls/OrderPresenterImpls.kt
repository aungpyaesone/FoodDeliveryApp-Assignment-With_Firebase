package com.padc.fooddeliveryapp.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.padc.fooddeliveryapp.data.models.OrderModelImpls
import com.padc.fooddeliveryapp.data.vos.BurgerVO
import com.padc.fooddeliveryapp.mvp.presenters.OrderPresenter
import com.padc.fooddeliveryapp.mvp.views.OrderView
import com.padc.shared.mvp.presenter.AbstractBasePresenter

class OrderPresenterImpls : OrderPresenter,AbstractBasePresenter<OrderView>() {
    private val mOrderModel = OrderModelImpls

    override fun onTapCheckOut() {
        mView?.showBottomSheet()
    }

    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
       mOrderModel.getOrders(onSuccess = {
           mView?.showOrderList(it)

           val price:List<Int> = it.map{ it.totalAmount?.toInt()!! }
           mView?.showTotalPrice(calculatePrice(price))


       },onFailure = {
           mView?.showErrorMessage(it)
       })
    }

    override fun onTapOrderItem(orderItem: BurgerVO) {

    }

    override fun onTapIncreased(foodItem: BurgerVO) {
        foodItem.count?.let {
            var count =it.toInt()
            count++
            foodItem.totalAmount = foodItem.price?.times(count)
            foodItem.count = count.toLong()
        }

        mOrderModel.addAndUpdate(foodItem,onSuccess = {},onFailure = {})
    }

    override fun onTapDecreased(foodItem: BurgerVO) {
        foodItem.count?.let {
            var count =it.toInt()
            if(count>1){
                count--
            }
            foodItem.totalAmount = foodItem.price?.times(count)
            foodItem.count = count.toLong()
            mOrderModel.addAndUpdate(foodItem,onSuccess = {},onFailure = {})
        }


    }

    override fun onTapDelete(foodItem: BurgerVO) {
        foodItem.name?.let { mOrderModel.deleteOrderByName(it) }
    }


    private fun calculatePrice(price:List<Int>):Int{
        var result = 0
        for(total in price){
            result +=total
        }
        return result
    }
}