package com.padc.fooddeliveryapp.data.models

import android.graphics.Bitmap
import com.padc.fooddeliveryapp.data.vos.User
import com.padc.fooddeliveryapp.network.auth.AuthManager
import com.padc.fooddeliveryapp.network.auth.AuthenticationManagerImpl

object AuthenticationModelImpl : AuthenticationModel {
    override var mAuthManager: AuthManager = AuthenticationManagerImpl

    override fun login(email: String, password: String, onSuccess: () -> Unit, onFailure: (String) -> Unit) {
       mAuthManager.login(email,password,onSuccess = onSuccess,onFailure = onFailure)
    }

    override fun register(email: String, password: String, userName: String, onSuccess: () -> Unit, onFailure: (String) -> Unit) {
        mAuthManager.register(email,password,userName,onSuccess =onSuccess,onFailure= onFailure)
    }

    override fun getUserProfile(): User {
        return mAuthManager.getUserProfile()
    }

    override fun updateUserProfile(imgUrl: String, onSuccess: (String) -> Unit, onFailure: (String) -> Unit) {
        mAuthManager.updateProfileUrl(imgUrl,onSuccess,onFailure)
    }

    override fun uploadPhotoUrl(bitmap: Bitmap, onSuccess: (imgUrl: String) -> Unit, onFailure: (String) -> Unit) {
        mAuthManager.uploadProfileUrl(bitmap,onSuccess,onFailure)
    }
}