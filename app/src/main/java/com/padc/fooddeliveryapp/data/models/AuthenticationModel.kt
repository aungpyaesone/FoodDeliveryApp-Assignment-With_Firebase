package com.padc.fooddeliveryapp.data.models

import android.graphics.Bitmap
import com.padc.fooddeliveryapp.data.vos.User
import com.padc.fooddeliveryapp.network.auth.AuthManager

interface AuthenticationModel {
    var mAuthManager :AuthManager

    fun login(email: String, password: String, onSuccess: () -> Unit, onFailure: (String) -> Unit)

    fun register(
            email: String,
            password: String,
            userName: String,
            onSuccess: () -> Unit,
            onFailure: (String) -> Unit
    )

    fun getUserProfile():User

    fun updateUserProfile(imgUrl: String,onSuccess: (String) -> Unit,onFailure: (String) -> Unit)
    fun uploadPhotoUrl(bitmap: Bitmap,onSuccess: (imgUrl:String) -> Unit,onFailure: (String) -> Unit)

}