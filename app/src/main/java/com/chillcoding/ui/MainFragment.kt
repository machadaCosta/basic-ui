package com.chillcoding.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.chillcoding.ui.databinding.FragmentMainBinding
import splitties.alertdialog.appcompat.*
import splitties.alertdialog.material.materialAlertDialog

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.mainAlertBtn.setOnClickListener { showAlertDialog() }
        binding.mainBtn.setOnClickListener {
            findNavController().navigate(R.id.action_MainFragment_to_SecondFragment)
        }
    }

    private fun showAlertDialog() {
        context?.materialAlertDialog {
            messageResource = R.string.text_alert_dialog
            okButton { showAlertDialog() }
            cancelButton()
        }?.onShow {
            positiveButton.setText(R.string.show)
        }?.show()
    }
}