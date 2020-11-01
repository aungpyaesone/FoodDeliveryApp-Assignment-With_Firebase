package com.padc.fooddeliveryapp.mvp.views

import com.padc.fooddeliveryapp.data.vos.BurgerVO
import com.padc.shared.mvp.views.BaseView

interface DetailView : BaseView {
    fun showDetailList(detailList:List<BurgerVO>)
    fun showPopularChoiceList(popularChoiceList: List<BurgerVO>)
    fun showAddToCart()

    fun navigateToOrderScreen()
}