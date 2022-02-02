package com.example.f1_anglade_godard.ui.list

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.example.f1_anglade_godard.R


class DetailDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val args = arguments
        val n = args!!.getString("num")
        return AlertDialog.Builder(activity)
            .setTitle(n.toString().split(" ").first())
            .setMessage(n)
            .create()
    }
}
