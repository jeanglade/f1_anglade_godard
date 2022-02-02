
package com.example.f1_anglade_godard.ui.search

import androidx.lifecycle.*
import com.example.f1_anglade_godard.rest.NumberApi
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {
    private val numberApi = NumberApi()

    val userInputLiveData = MutableLiveData<String>()

    fun getNumber(n: String) = viewModelScope.launch {
        val textNumber: String = numberApi.getNumber(n)
        userInputLiveData.value = textNumber
    }
}