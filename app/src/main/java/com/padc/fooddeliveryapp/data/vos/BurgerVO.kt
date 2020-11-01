package com.padc.fooddeliveryapp.data.vos

data class BurgerVO(
        var name:String? ="",
        var popular:Boolean? = null,
        var imgurl: String? = "",
        var price: Long? = 0,
        var rating: Long? = 0,
        var count: Long? = 0,
        var totalAmount: Long? =0

) {
}