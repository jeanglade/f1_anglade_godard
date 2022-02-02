package com.example.f1_anglade_godard.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.f1_anglade_godard.R

class SearchFragment : Fragment(R.layout.fragment_search) {
    val viewModel : SearchViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textViewResult = view.findViewById<TextView>(R.id.text_result_recherche)
        val editTextRecherche = view.findViewById<TextView>(R.id.edit_text_recherche)
        val buttonRecherche = view.findViewById<Button>(R.id.button_recherche)

        buttonRecherche.setOnClickListener {
            if(editTextRecherche.text.toString().trim().equals(""))
                textViewResult.text = getString(R.string.required_number)
            else
                viewModel.getNumber(editTextRecherche.text.toString())
        }

        viewModel.userInputLiveData.observe(viewLifecycleOwner, Observer<String> { newStringResult ->
            textViewResult.text = newStringResult
        })
    }
}