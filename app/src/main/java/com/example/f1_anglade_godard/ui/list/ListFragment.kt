package com.example.f1_anglade_godard.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.f1_anglade_godard.MainActivity
import com.example.f1_anglade_godard.R
import com.example.f1_anglade_godard.databinding.FragmentListBinding
import org.json.JSONObject

class ListFragment : Fragment(R.layout.fragment_list) {
    val viewModel: ListViewModel by viewModels()
    private lateinit var adapter: AdapterRecycleList

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listString = arrayOf("")
        var info : String = ""
        val listRecycleView = view.findViewById<RecyclerView>(R.id.MyRecycleView)
        //for (i in 0..5) {
        listString.set(0, info)
        //}
        listRecycleView.layoutManager = LinearLayoutManager(requireContext())
        adapter = AdapterRecycleList(listString)
        listRecycleView.adapter = adapter
    }
}