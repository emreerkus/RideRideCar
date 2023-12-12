package com.example.kotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ActivityNavigator
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.log

class RideAdapter(private var rideList: List<RideModel>) : RecyclerView.Adapter<RideAdapter.RideViewHolder>() {

    class RideViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvSource: TextView = view.findViewById(R.id.tvSource)
        val tvDestination: TextView = view.findViewById(R.id.tvDestination)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RideViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ride, parent, false)
        return RideViewHolder(view)
    }


    override fun onBindViewHolder(holder: RideViewHolder, position: Int) {
        val ride = rideList[position]
        // holder.textViewName.text = ride.empName // Bind data to your views
        holder.tvSource.text = ride.empSource // Assuming empSource is the source field in RideModel
        holder.tvDestination.text = ride.empDestination // Assuming empDestination is the destination field in RideModel
        // Bind other data
        holder.itemView.setOnClickListener {
            val bundle = Bundle().apply {
                putString("name", ride.empName)
                putString("source", ride.empSource)
                putString("destination", ride.empDestination)
                putString("total", ride.empTotalPassenger)
                putString("price", ride.empPrice)
                putString("contact", ride.empContact)
                putString("date", ride.empDate)
                putString("time", ride.empTime)
            }
            holder.itemView.findNavController().navigate(R.id.action_fetchingFragment_to_fragment_ride_details, bundle)
        }

    }

    override fun getItemCount(): Int = rideList.size

    fun updateData(newList: List<RideModel>) {
        rideList = newList
        notifyDataSetChanged()
    }
}