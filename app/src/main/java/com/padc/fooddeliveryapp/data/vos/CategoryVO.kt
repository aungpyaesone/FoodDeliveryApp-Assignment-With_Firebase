package com.padc.fooddeliveryapp.data.vos

import com.google.firebase.firestore.IgnoreExtraProperties

@IgnoreExtraProperties
data class CategoryVO (
        var name:String? = "",
        var imgurl: String =""
)
{
}