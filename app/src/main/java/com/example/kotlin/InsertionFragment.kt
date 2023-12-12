package com.example.kotlin

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController

class InsertionFragment : Fragment() {
    private lateinit var viewModel: InsertionViewModel
    private lateinit var etName: EditText
    private lateinit var etSource: EditText
    private lateinit var etDestination: EditText
    private lateinit var etTotalPassengers: EditText
    private lateinit var etPrice: EditText
    private lateinit var etContact: EditText
    private lateinit var etDate: EditText
    private lateinit var etTime: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_insertion, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[InsertionViewModel::class.java]

        etName = view.findViewById(R.id.etName)
        etSource = view.findViewById(R.id.etSource)
        etDestination = view.findViewById(R.id.etDestination)
        etTotalPassengers = view.findViewById(R.id.etTotalPassengers)
        etPrice = view.findViewById(R.id.etPrice)
        etContact = view.findViewById(R.id.etContact)
        etDate = view.findViewById(R.id.etDate)
        etTime = view.findViewById(R.id.etTime)

        view.findViewById<Button>(R.id.buttonSave).setOnClickListener {
            saveData()
            view.findNavController().navigate(R.id.action_insertionFragment_to_mainFragment)
        }
    }

    private fun saveData() {
        val name = etName.text.toString()
        val source = etSource.text.toString()
        val destination = etDestination.text.toString()
        val totalPassengers = etTotalPassengers.text.toString()
        val price = etPrice.text.toString()
        val contact = etContact.text.toString()
        val date = etDate.text.toString()
        val time = etTime.text.toString()

        if (name.isEmpty() || source.isEmpty() || destination.isEmpty() || totalPassengers.isEmpty()
            || price.isEmpty() || contact.isEmpty() || date.isEmpty() || time.isEmpty()) {
            Log.d("Save Data Button", "There are missing parts")
        } else {
            val rideModel = RideModel(
                empName = name,
                empSource = source,
                empDestination = destination,
                empTotalPassenger = totalPassengers,
                empPrice = price,
                empContact = contact,
                empDate = date,
                empTime = time
            )

            viewModel.saveRideData(rideModel)
        }
    }

}

