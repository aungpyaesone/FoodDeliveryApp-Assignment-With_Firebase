package com.padc.fooddeliveryapp.uitls

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Base64
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.padc.fooddeliveryapp.R
import com.padc.fooddeliveryapp.data.vos.BurgerVO
import com.padc.fooddeliveryapp.data.vos.CategoryVO
import com.padc.fooddeliveryapp.data.vos.RestaurantVO
import java.io.ByteArrayInputStream


fun String.convertToBitMap():Bitmap?{
    return try{
        val byte = Base64.decode(this,Base64.DEFAULT)
        val bitmap = BitmapFactory.decodeStream(ByteArrayInputStream(byte))
        bitmap
    }catch (e: Exception){
        e.message
        null
    }
}

fun ImageView.load(uri: Uri){
    Glide.with(context)
        .asBitmap()
        .load(uri)
        .centerCrop()
        .placeholder(R.drawable.ic_baseline_image_24)
        .into(this)
}

fun MutableMap<String,Any>?.convertToCategoryVO(): CategoryVO{
    val categoryVO = CategoryVO()
    categoryVO.name = this?.get("name") as String
    categoryVO.imgurl = this["imgurl"] as String

    return  categoryVO
}

fun MutableMap<String,Any>?.convertRestaurantVO(documentId:String): RestaurantVO{
    val restaurantVO = RestaurantVO()
    restaurantVO.id = this?.get("id") as String
    restaurantVO.name = this["name"] as String
    restaurantVO.imageurl = this["imgurl"] as String
    restaurantVO.documentId = documentId

    return  restaurantVO
}

fun MutableMap<String,Any>?.convertToBurgerVO(): BurgerVO{
    val burgerVO = BurgerVO()
    burgerVO.name = this?.get("name") as String
    burgerVO.imgurl = this["imgurl"] as String
    burgerVO.popular= this["popular"] as Boolean
    burgerVO.price = this["price"] as Long
    burgerVO.rating=this["rating"] as Long
    burgerVO.count = this["count"] as Long
    burgerVO.totalAmount = this["totalAmount"] as Long

    return burgerVO
}




