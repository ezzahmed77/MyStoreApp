package com.example.android.mystoreapp.data.watches

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WatchesViewModel : ViewModel() {

    private var _listOfWatches = MutableLiveData<List<Watch>>()
    val listOfWatches : LiveData<List<Watch>>
        get() = _listOfWatches

    private var watchesData = WatchesData

    init {
        // Getting list of watches from WatchesData Object
        _listOfWatches.value = watchesData.getListOfWatches()
    }

    fun addNewWatch(watch: Watch){
        watchesData.addNewWatch(watch)
    }

}