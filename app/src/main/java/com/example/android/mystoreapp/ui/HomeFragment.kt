package com.example.android.mystoreapp.ui

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.onNavDestinationSelected
import com.bumptech.glide.Glide
import com.example.android.mystoreapp.R
import com.example.android.mystoreapp.data.watches.Watch
import com.example.android.mystoreapp.data.watches.WatchesViewModel
import com.example.android.mystoreapp.databinding.FragmentHomeBinding
import org.w3c.dom.Text

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private lateinit var homeViewModel : WatchesViewModel

    private lateinit var linearLayout: LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        // Join the WatchesViewModel
        // adding activity to viewModel to also attach it with NewWatchFragment
        homeViewModel = ViewModelProvider(requireActivity()).get(WatchesViewModel::class.java)

        // Getting the Parent View
        linearLayout = binding.linearLayout

        // Observe the Watches to show them
        homeViewModel.listOfWatches.observe(viewLifecycleOwner, Observer { listOfWatches->
            updateUI(listOfWatches)
        })

        // For Adding New Watch
        binding.addButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_newWatchFragment)
        }

        // Fragment has option menu
        setHasOptionsMenu(true)

        return binding.root
    }

    // Update UI with new list
    private fun updateUI(listOfWatches : List<Watch>){
        // Adding All elements to the linearLayout
        for(item in listOfWatches){
            linearLayout.addView(getChildViewWithData(item))
        }
    }

    // Getting View with Watch Item Data to add it to the LinearLayout
    private fun getChildViewWithData(watch: Watch) : View{
        val childView = layoutInflater.inflate(R.layout.watch_item, null)

        val image: ImageView = childView.findViewById(R.id.cardImageView)
        val nameText: TextView = childView.findViewById(R.id.nameItem)
        val typeItem: TextView = childView.findViewById(R.id.typeItem)
        val descriptionItem: TextView = childView.findViewById(R.id.descriptionItem)
        val imageURL = watch.imageURL.toString()
        nameText.text = watch.name
        typeItem.text = watch.type
        descriptionItem.text = watch.description
        Glide.with(this)
            .load(imageURL)
            .error(R.drawable.erro_image)
            .placeholder(R.drawable.load_image)
            .into(image)

        return childView

    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.login_menu, menu)
    }

    // Determines what happens when menu item is selected
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.logInFragment->findNavController().navigate(R.id.action_homeFragment_to_logInFragment)
        }
        return true
    }

}