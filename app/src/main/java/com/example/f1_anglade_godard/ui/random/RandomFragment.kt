package com.example.f1_anglade_godard.ui.random

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.f1_anglade_godard.R
import com.example.f1_anglade_godard.databinding.FragmentRandomBinding

class RandomFragment : Fragment(R.layout.fragment_random) {
    val viewModel: RandomViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}