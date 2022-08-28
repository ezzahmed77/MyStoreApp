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
import com.example.android.mystoreapp.databinding.FragmentLogInBinding


class LogInFragment : Fragment() {

    private lateinit var binding: FragmentLogInBinding

    private lateinit var loginViewModel: LogInSignUpViewModel

    private lateinit var user: User


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_log_in, container, false)

        // Connect ViewModel
        loginViewModel = ViewModelProvider(this).get(LogInSignUpViewModel::class.java)

        // Get instance of User
        user = User()

        // Login only if user exists
        binding.loginButton.setOnClickListener{
            if(isEmailOrPasswordEmpty()){
                Toast.makeText(requireContext(), "Please Fill Out All Fields", Toast.LENGTH_SHORT).show()
            }
            else{
                if(loginViewModel.isExistUser(user)){
                    findNavController().navigate(R.id.action_logInFragment_to_homeFragment)
                }
                else{
                    Toast.makeText(context, "Account not exist\nRegister instead", Toast.LENGTH_SHORT).show()
                }
            }

        }

        // Register for new users
        binding.registerText.setOnClickListener {
            findNavController().navigate(R.id.action_logInFragment_to_signUpFragment)
        }


        return binding.root
    }

    // Check if all fields are not empty
    private fun isEmailOrPasswordEmpty(): Boolean{
        // Get User Login Information
        val email = binding.loginEmailText.text.toString()
        val password = binding.loginPasswordText.text.toString()
        return if(email.isEmpty() || password.isEmpty() ){
            true
        } else{
            user.email = email
            user.password = password
            false
        }
    }


}