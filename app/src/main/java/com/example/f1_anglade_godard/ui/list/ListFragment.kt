package com.example.f1_anglade_godard.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.f1_anglade_godard.R
import com.example.f1_anglade_godard.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private lateinit var listViewModel: ListViewModel
    private lateinit var adapter: AdapterRecycleList
    private var _binding: FragmentListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        listViewModel =
                ViewModelProvider(this).get(ListViewModel::class.java)

        _binding = FragmentListBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val listRecycleView = root.findViewById<RecyclerView>(R.id.MyRecycleView)
        listRecycleView.layoutManager = LinearLayoutManager(requireContext())
        adapter = AdapterRecycleList(arrayOf<String>("4 :_JeanGodard","10 :_raveen","12020 :_Sathya","22 :_Yogesh","20 :_Ram"))
        listRecycleView.adapter = adapter

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}