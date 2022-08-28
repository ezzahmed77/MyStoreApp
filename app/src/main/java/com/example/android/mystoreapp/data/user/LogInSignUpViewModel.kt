package com.example.android.mystoreapp.data.user

import androidx.lifecycle.ViewModel

class LogInSignUpViewModel : ViewModel() {
    private lateinit var usersDataList: MutableList<User>
    private var usersData : UsersData = UsersData


    init {
        usersDataList = usersData.listOfUsers
    }


    fun isExistUser(user : User): Boolean{
        var userIndex =0
        while(userIndex < usersDataList.size){
            if(usersDataList[userIndex].email == user.email && usersDataList[userIndex].password == user.password){
                return true
            }
            userIndex++
        }
        return false
    }


    fun addNewUser(user: User){
        UsersData.addNewUser(user)
    }

}