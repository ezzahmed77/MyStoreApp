package com.example.android.mystoreapp.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.example.android.mystoreapp.R
import com.example.android.mystoreapp.databinding.FragmentFirstInstructionBinding

class FirstInstructionFragment : Fragment() {

    private lateinit var binding: FragmentFirstInstructionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_first_instruction, container, false)

        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager2)

        binding.firstInstructionNextText.setOnClickListener {
            viewPager?.currentItem = 2
        }


        return binding.root
    }

}