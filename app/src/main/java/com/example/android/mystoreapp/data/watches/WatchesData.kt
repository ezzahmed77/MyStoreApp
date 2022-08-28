package com.example.android.mystoreapp.data.watches

object WatchesData {

    private var listOfWatches : MutableList<Watch> = mutableListOf()

    fun getListOfWatches() = listOfWatches

    fun addNewWatch(watch: Watch){
        listOfWatches.add(watch)
    }
}
