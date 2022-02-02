
package com.example.f1_anglade_godard.ui.list

import androidx.lifecycle.*
import com.example.f1_anglade_godard.rest.NumberApi
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {
    private val numberApi = NumberApi()

    val liveData = MutableLiveData<String>()

    fun getNumber(n: String) = viewModelScope.launch {
        val textNumber: String = numberApi.getNumber(n)
        liveData.value = textNumber
    }
}