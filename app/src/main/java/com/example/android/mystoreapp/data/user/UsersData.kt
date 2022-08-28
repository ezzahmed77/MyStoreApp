package com.example.android.mystoreapp.data.user

// This is object to store a list of users!
object UsersData {
    var listOfUsers : MutableList<User> = mutableListOf()

    // Adding new user to the list
    fun addNewUser(user : User){
        listOfUsers.add(user)
    }

}