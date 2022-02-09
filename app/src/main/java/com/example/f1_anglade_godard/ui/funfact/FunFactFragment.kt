package com.example.f1_anglade_godard.ui.funfact

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.f1_anglade_godard.R
import java.text.SimpleDateFormat
import java.util.*


class FunFactFragment : Fragment(R.layout.fragment_funfact) {
    val viewModel : FunFactViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Date
        val sdf = SimpleDateFormat("MM/dd")
        val currentDate = sdf.format(Date())
        val textViewDate = view.findViewById<TextView>(R.id.text_result_funfact_date)
        textViewDate.text = currentDate
        //FunFact
        val textViewFunFact = view.findViewById<TextView>(R.id.text_result_funfact)

        val textViewTitleFunFact = view.findViewById<TextView>(R.id.text_funfact)
        textViewTitleFunFact.text = getString(R.string.presentation_funfact).uppercase()

        viewModel.getNumber(textViewDate.text.toString())

        viewModel.funfactLiveData.observe(viewLifecycleOwner, Observer<String> { newStringResult ->
            textViewFunFact.text = newStringResult
        })

        val rainbow = GradientDrawable(
            GradientDrawable.Orientation.LEFT_RIGHT,
            intArrayOf(
                Color.RED,
                Color.MAGENTA,
                Color.BLUE,
                Color.CYAN,
                Color.GREEN,
                Color.YELLOW,
                Color.RED
            )
        )
        textViewDate.background = rainbow
    }
}