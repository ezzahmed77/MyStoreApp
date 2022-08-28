package com.example.android.mystoreapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.android.mystoreapp.R
import com.example.android.mystoreapp.data.watches.Watch
import com.example.android.mystoreapp.data.watches.WatchesData
import com.example.android.mystoreapp.data.watches.WatchesViewModel
import com.example.android.mystoreapp.databinding.FragmentNewWatchBinding

class NewWatchFragment : Fragment() {
    private lateinit var binding: FragmentNewWatchBinding

    private lateinit var newWatchViewModel : WatchesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_watch, container, false)
        binding.lifecycleOwner = this

        // Getting the View Model
        newWatchViewModel = ViewModelProvider(requireActivity()).get(WatchesViewModel::class.java)




        binding.saveButton.setOnClickListener {
            // Getting the Edit Text Fields
            val newWatchName = binding.newWatchNameText.text.toString()
            val newWatchType = binding.newWatchTypeText.text.toString()
            val newWatchImageURL = binding.newWatchImageUrlText.text.toString()
            val newWatchDescription = binding.newWatchDescriptionText.text.toString()
            if(newWatchName.isNotEmpty() && newWatchType.isNotEmpty()
                && newWatchImageURL.isNotEmpty() && newWatchDescription.isNotEmpty()){

                val watch = Watch(newWatchName, newWatchType, newWatchImageURL, newWatchDescription)
                newWatchViewModel.addNewWatch(watch)
                findNavController().navigate(R.id.action_newWatchFragment_to_homeFragment)
            }
            else{
                Toast.makeText(requireContext(), "Please Fill Out All Fields!", Toast.LENGTH_SHORT).show()
            }

        }

        binding.cancelButton.setOnClickListener {
            findNavController().navigate(R.id.action_newWatchFragment_to_homeFragment)
        }


        return binding.root
    }

}