package com.example.android.mystoreapp.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.example.android.mystoreapp.R
import com.example.android.mystoreapp.databinding.ActivityMainBinding
import com.example.android.mystoreapp.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {
    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)

        // Find View Pager
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager2)

        binding.welcomeNextText.setOnClickListener {
            viewPager?.currentItem = 1
        }

        return binding.root
    }

}