package com.example.appdevelopproject.intentdata

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.appdevelopproject.R

class RedFragment : Fragment() {

    private var mOnListenerRed: OnListenerRed? = null

    interface OnListenerRed {
        fun onReceivedData(name: String)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mOnListenerRed = activity as OnListenerRed
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_red, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val btnSendToMain = view.findViewById<Button>(R.id.btnSendToMain)
        btnSendToMain.setOnClickListener {
            mOnListenerRed?.onReceivedData("FragmentRed -> MainActivity")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mOnListenerRed = null
    }
}