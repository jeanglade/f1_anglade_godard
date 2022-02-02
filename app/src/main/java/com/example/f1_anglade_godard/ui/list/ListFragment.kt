package com.example.f1_anglade_godard.ui.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.f1_anglade_godard.R


class ListFragment : Fragment(R.layout.fragment_list), AdapterRecycleList.StringCallback {
    val viewModel: ListViewModel by viewModels()
    private lateinit var adapter: AdapterRecycleList

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listString = arrayOfNulls<String>(232)
        val listRecycleView = view.findViewById<RecyclerView>(R.id.MyRecycleView)
        //231 = valeur max de l'api avec un funfact
        for (i in 0..231) {
        listString[i] = i.toString()
        }
        listRecycleView.layoutManager = LinearLayoutManager(requireContext())
        adapter = AdapterRecycleList(listString, this)
        listRecycleView.adapter = adapter

        viewModel.liveData.observe(viewLifecycleOwner, Observer<String> { newStringResult ->
            val dialogFragment: DialogFragment = DetailDialogFragment()

            val fragmentManager = this.fragmentManager
            val args = Bundle()
            args.putString("num", newStringResult)
            dialogFragment.arguments = args
            // Show:
            dialogFragment.show(fragmentManager!!, "Dialog")
        })
    }

    override fun onStringClicked(s: String) {
        viewModel.getNumber(s)
    }

}