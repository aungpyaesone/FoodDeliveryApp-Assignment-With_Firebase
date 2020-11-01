package com.padc.fooddeliveryapp.data.vos

import com.google.firebase.firestore.IgnoreExtraProperties

@IgnoreExtraProperties
data class RestaurantVO
(
        var id: String? ="",
        var name: String? = "",
        var imageurl: String? = "",
        var documentId: String =""

        ) {
}