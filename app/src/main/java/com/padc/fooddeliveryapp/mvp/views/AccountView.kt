package com.padc.fooddeliveryapp.mvp.views

import com.padc.fooddeliveryapp.data.vos.User
import com.padc.shared.mvp.views.BaseView

interface AccountView : BaseView {
        fun openGallery()
        fun showUserProfile(user:User)

}