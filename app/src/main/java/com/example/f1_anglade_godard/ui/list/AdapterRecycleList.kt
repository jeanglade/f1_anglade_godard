package com.example.f1_anglade_godard.ui.list
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.f1_anglade_godard.R


class AdapterRecycleList(private val dataSet: Array<String?>, val stringCallback: StringCallback) :
    RecyclerView.Adapter<AdapterRecycleList.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textCell: TextView

        init {
            // Define click listener for the ViewHolder's View.
            textCell = view.findViewById(R.id.textCell)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cell_number, viewGroup, false)
        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.textCell.text = dataSet[position];
        viewHolder.textCell.setOnClickListener {
            stringCallback.onStringClicked(dataSet[position].toString())
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

    interface StringCallback {
        fun onStringClicked(s:String)
    }

}


