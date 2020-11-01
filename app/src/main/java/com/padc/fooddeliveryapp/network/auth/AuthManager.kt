package com.padc.fooddeliveryapp.network.auth

import android.graphics.Bitmap
import com.padc.fooddeliveryapp.data.vos.User

interface AuthManager {
    fun login(email: String, password: String, onSuccess: () -> Unit, onFailure: (String) -> Unit)
    fun register(email: String, password: String, userName: String, onSuccess: () -> Unit, onFailure: (String) -> Unit)
    fun getUserProfile():User
    fun updateProfileUrl(photoUrl: String, onSuccess: (String) -> Unit, onFailure: (String) -> Unit)
    fun uploadProfileUrl(bitmap: Bitmap,onSuccess: (imgUrl:String) -> Unit,onFailure: (String) -> Unit)

}