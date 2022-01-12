package com.example.f1_anglade_godard.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.f1_anglade_godard.MainActivity
import com.example.f1_anglade_godard.R
import com.example.f1_anglade_godard.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private lateinit var searchViewModel: SearchViewModel
    private var _binding: FragmentSearchBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        searchViewModel =
                ViewModelProvider(this).get(SearchViewModel::class.java)

        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textViewResult = root.findViewById<TextView>(R.id.text_result_recherche)
        val textViewRecherche = root.findViewById<TextView>(R.id.text_recherche)
        val buttonRecherche = root.findViewById<Button>(R.id.button_recherche)
        buttonRecherche.setOnClickListener {
            (requireActivity() as MainActivity).getResult(textViewResult, textViewRecherche.text.toString());
        }



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}