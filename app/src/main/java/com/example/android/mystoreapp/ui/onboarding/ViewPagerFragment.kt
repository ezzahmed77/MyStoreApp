package com.example.android.mystoreapp.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.android.mystoreapp.R
import com.example.android.mystoreapp.databinding.FragmentSecondInstructionBinding
import com.example.android.mystoreapp.databinding.FragmentViewPagerBinding

class ViewPagerFragment : Fragment() {

    private lateinit var binding: FragmentViewPagerBinding

    private lateinit var myList : List<Fragment>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_view_pager, container, false)

        // Get an array list of fragments to use them with ViewPager Adapter
        myList = arrayListOf(WelcomeFragment(), FirstInstructionFragment(), SecondInstructionFragment())

        val mAdapter = ViewPagerAdapter(requireActivity().supportFragmentManager, lifecycle, myList)

        binding.viewPager2.adapter  = mAdapter

        return binding.root
    }

}