package com.example.kotlin


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.kotlin.databinding.FragmentMainBinding

class MainFragment: Fragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        binding.buttonInsertData.setOnClickListener{
            view.findNavController().navigate(R.id.action_mainFragment_to_insertionFragment)
        }
        binding.buttonFetchData.setOnClickListener{
            view.findNavController().navigate(R.id.action_mainFragment_to_fetchingFragment)
        }

    }
}
