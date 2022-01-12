package com.example.f1_anglade_godard.ui.search

import android.widget.TextView
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest

class SearchViewModel : ViewModel() {
    public fun getResult(textView:TextView, nombre:String){
        //val queue = Volley.newRequestQueue(this)

        val requestUrl = "http://numbersapi.com/$nombre?json"
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, requestUrl, null,
            { response ->
                textView.text = "Response: %s".format(response.toString())
            },
            { textView.text = "That didn't work!" })
        //queue.add(jsonObjectRequest)
    }
}