package com.example.f1_anglade_godard.ui.funfact

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.f1_anglade_godard.rest.NumberApi
import kotlinx.coroutines.launch

class FunFactViewModel : ViewModel() {
    private val numberApi = NumberApi()

    val funfactLiveData = MutableLiveData<String>()

    fun getNumber(n: String) = viewModelScope.launch {
        val textNumber: String = numberApi.getNumber(n)
        funfactLiveData.value = textNumber
    }
}