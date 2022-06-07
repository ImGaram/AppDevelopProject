package com.example.appdevelopproject.intentdata

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.appdevelopproject.R

class GreenFragment : Fragment() {

    private var mOnListenerGreen: OnListenerGreen? = null

    interface OnListenerGreen {
        fun onReceivedData(name: String)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mOnListenerGreen = activity as OnListenerGreen
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_green, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnSendToMain = view.findViewById<Button>(R.id.btnSendToMain)
        btnSendToMain.setOnClickListener {
            mOnListenerGreen?.onReceivedData("FragmentGreen -> MainActivity")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mOnListenerGreen = null
    }
}