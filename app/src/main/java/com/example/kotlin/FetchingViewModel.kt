package com.example.kotlin

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class FetchingViewModel : ViewModel() {
    private val _rideData = MutableLiveData<List<RideModel>>()
    val rideData: LiveData<List<RideModel>> = _rideData
    init {
        fetchData()
    }
    private fun fetchData() {
        val database: DatabaseReference = Firebase.database.reference

        database.child("Rides").get().addOnSuccessListener { dataSnapshot ->
            val ridesList = mutableListOf<RideModel>()

            for (rideSnapshot in dataSnapshot.children) {
                val ride = rideSnapshot.getValue(RideModel::class.java)
                ride?.let { ridesList.add(it) }
            }
            _rideData.value = ridesList
            Log.i("firebase", "Data fetched successfully")
        }.addOnFailureListener { exception ->
            Log.e("firebase", "Error getting data", exception)
        }
    }
}
