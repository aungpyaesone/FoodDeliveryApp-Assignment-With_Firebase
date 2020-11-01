package com.padc.fooddeliveryapp.network.auth

import android.graphics.Bitmap
import android.net.Uri
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.storage.FirebaseStorage
import com.padc.fooddeliveryapp.data.vos.User
import java.io.ByteArrayOutputStream
import java.util.*

object AuthenticationManagerImpl : AuthManager {

    private val mFirebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private val storage = FirebaseStorage.getInstance()
    private val storageReference = storage.reference

    override fun login(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful && it.isComplete) {
                onSuccess()
            } else {
                onFailure(it.exception?.message ?: "please check internet connection")
            }
        }
    }

    override fun register(
        email: String,
        password: String,
        userName: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        mFirebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful && it.isComplete) {
                mFirebaseAuth.currentUser?.updateProfile(
                    UserProfileChangeRequest.Builder()
                            .setDisplayName(userName)
                            .build()
                )
                onSuccess()
            } else {
                onFailure(it.exception?.message ?: "Please check your internet connection")
            }
        }
    }

    override fun getUserProfile(): User {
        return User(
                mFirebaseAuth.currentUser?.displayName ?:"",
                mFirebaseAuth.currentUser?.email ?:"",
                mFirebaseAuth.currentUser?.photoUrl.toString() ?:""
        )


    }

    override fun updateProfileUrl(photoUrl: String, onSuccess: (String) -> Unit, onFailure: (String) -> Unit) {
        mFirebaseAuth.currentUser?.updateProfile(
                UserProfileChangeRequest.Builder()
                        .setPhotoUri(Uri.parse(photoUrl))
                        .build())?.addOnCompleteListener{task ->
            if(task.isSuccessful){
                onSuccess("Success profile update")
            }else
            {
                onFailure("Failed profile update")
            }

        }


    }

    override fun uploadProfileUrl(bitmap: Bitmap, onSuccess: (imgUrl: String) -> Unit, onFailure: (String) -> Unit) {
        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val data = baos.toByteArray()

        val imageRef = storageReference.child("images/${UUID.randomUUID()}")
        val uploadTask = imageRef.putBytes(data)
        uploadTask.addOnFailureListener {
            //
        }.addOnSuccessListener { taskSnapshot ->
            //
        }

        val urlTask = uploadTask.continueWithTask {
            return@continueWithTask imageRef.downloadUrl
        }.addOnCompleteListener { task ->
            val photoUrl = task.result?.toString()
            photoUrl?.let{
                onSuccess(it)
            }
        }
    }


}