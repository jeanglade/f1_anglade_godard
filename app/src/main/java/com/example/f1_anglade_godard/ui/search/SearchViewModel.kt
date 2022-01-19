package com.example.f1_anglade_godard.ui.search

import androidx.lifecycle.*
import com.example.f1_anglade_godard.rest.NumberApi

class SearchViewModel : ViewModel() {
    private val numberApi = NumberApi()
    private val numberLiveData: LiveData<String>
        get() {

        }

    private fun loadNumber(n:String) {
        numberLiveData = numberApi.getNumber(n)
    }

    //= liveData {
        //val number: String = numberApi.getNumber("1")
      //  emit(number)
    //}

}