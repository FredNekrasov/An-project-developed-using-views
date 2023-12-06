package com.olympia.mfa.view_pager.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.olympia.databinding.MfaFragment2Binding
import com.olympia.mfa.data.DataModelForChat

class Fragment2 : Fragment() {
    private lateinit var binding: MfaFragment2Binding
    private val dataModel: DataModelForChat by activityViewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = MfaFragment2Binding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.SMTF1.setOnClickListener {
            dataModel.messageToFragment1.value = binding.MessageText2.text.toString()
        }
        binding.SMTMF2.setOnClickListener {
            dataModel.messageToMainFragment.value = binding.MessageText2.text.toString()
        }
        dataModel.messageToFragment2.observe(activity as LifecycleOwner) {
            binding.MessageView2.text = it
        }
    }
    companion object {
        @JvmStatic
        fun newInstance() = Fragment2()
    }
}