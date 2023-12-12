package com.example.kotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class RideDetailsFragment : Fragment() {

    private var tvName: TextView? = null
    private var tvSource: TextView? = null
    private var tvDestination: TextView? = null
    private var tvTotal: TextView? = null
    private var tvPrice: TextView? = null
    private var tvContact: TextView? = null
    private var tvDate: TextView? = null
    private var tvTime: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       
        val view = inflater.inflate(R.layout.fragment_ride_details, container, false)
        initView(view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setValuesToViews()
    }

    private fun initView(view: View) {
        tvName = view.findViewById(R.id.tvName)
        tvSource = view.findViewById(R.id.tvSource)
        tvDestination = view.findViewById(R.id.tvDestination)
        tvTotal = view.findViewById(R.id.tvTotal)
        tvPrice = view.findViewById(R.id.tvPrice)
        tvContact = view.findViewById(R.id.tvContact)
        tvDate = view.findViewById(R.id.tvDate)
        tvTime = view.findViewById(R.id.tvTime)
    }

    private fun setValuesToViews() {
        tvName?.text = arguments?.getString("name")
        tvSource?.text = arguments?.getString("source")
        tvDestination?.text = arguments?.getString("destination")
        tvTotal?.text = arguments?.getString("total")
        tvPrice?.text = arguments?.getString("price")
        tvContact?.text = arguments?.getString("contact")
        tvDate?.text = arguments?.getString("date")
        tvTime?.text = arguments?.getString("time")
    }
}
