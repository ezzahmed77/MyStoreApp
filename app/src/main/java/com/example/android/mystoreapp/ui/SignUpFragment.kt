
package com.example.android.mystoreapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.android.mystoreapp.R
import com.example.android.mystoreapp.data.user.LogInSignUpViewModel
import com.example.android.mystoreapp.data.user.User
import com.example.android.mystoreapp.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding

    private lateinit var signUpViewModel: LogInSignUpViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up, container, false)

        // Connecting viewModel
        signUpViewModel = ViewModelProvider(this).get(LogInSignUpViewModel::class.java)

        binding.signUpButton.setOnClickListener {
            val fullName = binding.NewUserFullName.text.toString()
            val email = binding.NewUserEmail.text.toString()
            val password = binding.NewUserPassword.text.toString()

            if(fullName.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty()){
                val newUser = User(fullName, email, password)
                signUpViewModel.addNewUser(newUser)
                findNavController().navigate(R.id.action_signUpFragment_to_viewPagerFragment)
            }
            else{
                Toast.makeText(requireContext(), "Please Fill Out All Fields!", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }

}