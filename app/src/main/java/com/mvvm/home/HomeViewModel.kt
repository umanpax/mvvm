package com.mvvm.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    var liveDataUserName = MutableLiveData<String>()
    var liveDataLastName = MutableLiveData<String>()
    var liveDataHobbies = MutableLiveData<ArrayList<String>>()
    var listHobbies = ArrayList<String>()

    fun getUserName() {
        liveDataUserName.postValue("Pierre")
    }
    fun getLastName() {
        liveDataLastName.postValue("Vezinet")
    }
    fun getHobbies() {
        listHobbies = ArrayList()
        listHobbies.add("Guitare")
        listHobbies.add("Piano")
        listHobbies.add("Vélo")
        listHobbies.add("Course")
        liveDataHobbies.postValue(listHobbies)
    }
}