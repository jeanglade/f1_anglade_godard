package com.example.f1_anglade_godard.ui.search

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
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
        //Number
        val textViewResult = view.findViewById<TextView>(R.id.text_result_recherche)
        val editTextRecherche = view.findViewById<TextView>(R.id.edit_text_recherche)
        val buttonRecherche = view.findViewById<Button>(R.id.button_recherche)
        //Date
        val editTextRechercheDate = view.findViewById<TextView>(R.id.edit_text_recherche_date)
        //Année
        val editTextRechercheYear = view.findViewById<TextView>(R.id.edit_text_recherche_year)

        buttonRecherche.setOnClickListener {
            if(editTextRecherche.text.toString().trim().equals("") && editTextRechercheDate.text.toString().trim().equals("") && editTextRechercheYear.text.toString().trim().equals(""))
            {
                textViewResult.text = getString(R.string.required_number)
                textViewResult.setVisibility(View.VISIBLE)
                context?.let { hideKeyboardFrom(it, view) }
            }
            else{
                if(!editTextRecherche.text.toString().trim().equals("")){
                    viewModel.getNumber(editTextRecherche.text.toString().replace("-", ""))
                    editTextRecherche.text = ""
                }
                else{
                    if(!editTextRechercheDate.text.toString().trim().equals("")){
                        if(Regex("^(0[1-9]|1[012])[/](0[1-9]|[12][0-9]|3[01])\$").matches(editTextRechercheDate.text.toString()))
                            viewModel.getNumber(editTextRechercheDate.text.toString() + "/date")
                        else {
                            textViewResult.text = getString(R.string.wrong_date_format)
                            textViewResult.setVisibility(View.VISIBLE)
                            context?.let { hideKeyboardFrom(it, view) }
                        }
                        editTextRechercheDate.text = ""
                    }
                    else{
                        viewModel.getNumber(editTextRechercheYear.text.toString().replace("-", "") + "/year")
                        editTextRechercheYear.text = ""
                    }
                }
            }
        }

        viewModel.userInputLiveData.observe(viewLifecycleOwner, Observer<String> { newStringResult ->
            textViewResult.text = newStringResult
            textViewResult.setVisibility(View.VISIBLE)
            context?.let { hideKeyboardFrom(it, view) }
        })

    }

    fun hideKeyboardFrom(context: Context, view: View) {
        val imm: InputMethodManager =
            context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}