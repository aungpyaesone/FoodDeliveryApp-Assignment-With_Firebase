package com.padc.fooddeliveryapp.network.impls

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.padc.fooddeliveryapp.data.vos.BurgerVO
import com.padc.fooddeliveryapp.data.vos.CategoryVO
import com.padc.fooddeliveryapp.data.vos.RestaurantVO
import com.padc.fooddeliveryapp.network.FirebaseApi

object FirebaseRealtimeImpls : FirebaseApi {

    private val database: DatabaseReference = Firebase.database.reference
    private val storage = FirebaseStorage.getInstance()
    private val storageReference = storage.reference

    override fun getAllRestaurants(onSuccess: (List<RestaurantVO>) -> Unit, onFailure: (String) -> Unit) {
        database.child("restaurants").addValueEventListener(object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                onFailure(error.message)
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                val restaurantList = arrayListOf<RestaurantVO>()
                snapshot.children.forEach { dataSnapshot ->
                    dataSnapshot.getValue(RestaurantVO::class.java)?.let {
                        restaurantList.add(it)
                    }
                }
                onSuccess(restaurantList)
            }
        })
    }

    override fun getCategories(onSuccess: (List<CategoryVO>) -> Unit, onFailure: (String) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun getBurgerList(docId: String, onSuccess: (List<BurgerVO>) -> Unit, onFailure: (String) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun getPopularFoodList(onSuccess: (List<BurgerVO>) -> Unit, onFailure: (String) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun addOrder(burgerVO: BurgerVO, onSuccess: () -> Unit, onFailure: (String) -> Unit) {
        TODO("Not yet implemented")
    }

    override fun getOrders(onSuccess: (List<BurgerVO>) -> Unit, onFailure: (String) -> Unit) {
            TODO("Not yet implemented")
    }

    override fun deleteOrderByName(name: String) {
        TODO("Not yet implemented")
    }

    override fun deleteAllOrder(orderList: List<BurgerVO>) {
        TODO("Not yet implemented")
    }
}