package com.example.kotlin

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.kotlin.RideModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class InsertionViewModel : ViewModel() {

    private var database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private var ref: DatabaseReference  = database.getReference("Rides")

    fun saveRideData(rideModel: RideModel) {
        val id = ref.push().key ?: return
        val rideRef = ref.child(id);

        rideRef.setValue(rideModel)
    }
}

