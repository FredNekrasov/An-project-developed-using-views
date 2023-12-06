package com.olympia.mfa.view_pager.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.olympia.databinding.MfaFragment1Binding
import com.olympia.mfa.data.DataModelForChat

class Fragment1 : Fragment() {
    private lateinit var binding: MfaFragment1Binding
    private val dataModel: DataModelForChat by activityViewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = MfaFragment1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.SMTF2.setOnClickListener {
            dataModel.messageToFragment2.value = binding.MessageText.text.toString()
        }
        binding.SMTMF.setOnClickListener {
            dataModel.messageToMainFragment.value = binding.MessageText.text.toString()
        }
        dataModel.messageToFragment1.observe(activity as LifecycleOwner) {
            binding.MessageView.text = it
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = Fragment1()
    }
}