package com.example.android.mystoreapp.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.android.mystoreapp.R
import com.example.android.mystoreapp.databinding.FragmentFirstInstructionBinding
import com.example.android.mystoreapp.databinding.FragmentSecondInstructionBinding

class SecondInstructionFragment : Fragment() {

    private lateinit var binding: FragmentSecondInstructionBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second_instruction, container, false)

        binding.secondInstructionFinishText.setOnClickListener {
            findNavController().navigate(R.id.action_viewPagerFragment_to_homeFragment)
        }

        return binding.root

    }

}