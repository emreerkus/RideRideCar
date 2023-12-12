package com.example.kotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FetchingFragment : Fragment() {
    private lateinit var viewModel: FetchingViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RideAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_fetching, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[FetchingViewModel::class.java]

        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        adapter = RideAdapter(emptyList()) // Initialize with empty list
        recyclerView.adapter = adapter

        // Observe ViewModel LiveData and update UI accordingly
        viewModel.rideData.observe(viewLifecycleOwner) { data ->
            adapter.updateData(data) // Update adapter data
        }
    }
}
