package com.padc.fooddeliveryapp.network.impls

import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson
import com.padc.fooddeliveryapp.data.vos.BurgerVO
import com.padc.fooddeliveryapp.data.vos.CategoryVO
import com.padc.fooddeliveryapp.data.vos.RestaurantVO
import com.padc.fooddeliveryapp.network.FirebaseApi
import com.padc.fooddeliveryapp.uitls.convertRestaurantVO
import com.padc.fooddeliveryapp.uitls.convertToBurgerVO
import com.padc.fooddeliveryapp.uitls.convertToCategoryVO

object FireStoreImpls : FirebaseApi {

    val db = Firebase.firestore
    override fun getAllRestaurants(onSuccess: (List<RestaurantVO>) -> Unit, onFailure: (String) -> Unit) {
        db.collection("restaurants")
                .addSnapshotListener { value, error ->
                    error?.let {
                        onFailure(it.message ?: "Please check internet connection")
                    } ?: run {
                        val restaurantList: MutableList<RestaurantVO> = arrayListOf()
                        val result = value?.documents ?: arrayListOf()
                        for (document in result) {
                            val id = document.id
                            val data = document.data.convertRestaurantVO(id)
                            restaurantList.add(data)
                        }
                        onSuccess(restaurantList)
                    }
                }
    }

    override fun getCategories(onSuccess: (List<CategoryVO>) -> Unit, onFailure: (String) -> Unit) {
        db.collection("Category")
                .addSnapshotListener { value, error ->
                    error?.let {
                        onFailure(it.message ?: "Please check internet connection")
                    } ?: run {
                        val categoryList: MutableList<CategoryVO> = arrayListOf()
                        val result = value?.documents ?: arrayListOf()
                        for (document in result) {
                            val data = document?.data.convertToCategoryVO()
                            categoryList.add(data)
                        }
                        onSuccess(categoryList)
                    }
                }
    }

    override fun getBurgerList(docId: String, onSuccess: (List<BurgerVO>) -> Unit, onFailure: (String) -> Unit) {
        db.collection("restaurants/${docId}/fooditems")
                .addSnapshotListener { value, error ->
                    error?.let {
                        onFailure(it.message ?: "Please check internet connection")
                    } ?: run {
                        val burgerVOList: MutableList<BurgerVO> = arrayListOf()
                        val result = value?.documents ?: arrayListOf()
                        for (document in result) {
                            val data = document?.data.convertToBurgerVO()
                            burgerVOList.add(data)
                        }
                        onSuccess(burgerVOList)
                    }

                }
    }

    override fun getPopularFoodList(onSuccess: (List<BurgerVO>) -> Unit, onFailure: (String) -> Unit) {
        db.collectionGroup("fooditems").whereEqualTo("popular", true)
                .addSnapshotListener { value, error ->
                    error?.let {
                        onFailure(it.message ?: "Please check internet connection")
                    } ?: run {
                        val popularFoodList: MutableList<BurgerVO> = arrayListOf()
                        val result = value?.documents ?: arrayListOf()
                        for (document in result) {
                            val hashmap = document.data
                            hashmap?.put("id", document.id.toString())
                            val Data = Gson().toJson(hashmap)
                            val docData = Gson().fromJson<BurgerVO>(Data, BurgerVO::class.java)
                            popularFoodList.add(docData)
                        }
                        onSuccess(popularFoodList)
                    }
                }
    }

    override fun addOrder(burgerVO: BurgerVO, onSuccess: () -> Unit, onFailure: (String) -> Unit) {
        val orderMap = hashMapOf(
                "name" to burgerVO.name,
                "imgurl" to burgerVO.imgurl,
                "price" to burgerVO.price,
                "popular" to burgerVO.popular,
                "rating" to burgerVO.rating,
                "count" to burgerVO.count,
                "totalAmount" to burgerVO.totalAmount
        )

        burgerVO.name?.let {
            db.collection("basket")
                .document(it)
                    .set(orderMap)
                    .addOnSuccessListener {
                        Log.d("success","Successfully add order")
                        onSuccess()
                    }
                    .addOnFailureListener{
                        Log.d("onFailure","Failed to add order")
                        onFailure("Failed to add order")
                    }
        }

    }

    override fun getOrders(onSuccess: (List<BurgerVO>) -> Unit, onFailure: (String) -> Unit) {
        db.collection("basket")
                .addSnapshotListener { value, error ->
                    error?.let {
                        onFailure(it.message ?: "Please check internet connection")
                    } ?: run {
                        val orderList: MutableList<BurgerVO> = arrayListOf()
                        val result = value?.documents ?: arrayListOf()
                        for (document in result) {
                            val data = document?.data.convertToBurgerVO()
                            orderList.add(data)
                        }
                        onSuccess(orderList)
                    }

                }
    }

    override fun deleteOrderByName(name: String) {
    db.collection("basket")
                    .document(name)
                    .delete()
                    .addOnSuccessListener {
                        Log.d("success","Successfully delete grocery")
                    }
                    .addOnFailureListener{Log.d("onFailure","Failed to delete Grocery")}
    }
}