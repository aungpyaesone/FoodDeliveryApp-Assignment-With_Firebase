package com.padc.fooddeliveryapp.data.vos

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class FoodItemVO(
        var name:String? ="",
        var popular:Boolean? = null,
        var imgurl: String? = "",
        var price: Long? = 0,
        var rating: Long? = 0,
        var count: Long? = 0
) {
}