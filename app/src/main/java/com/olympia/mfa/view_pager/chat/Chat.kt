package com.olympia.mfa.view_pager.chat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.olympia.R
import com.olympia.databinding.MfaFragmentChatBinding
import com.olympia.main.view.openFragment
import com.olympia.mfa.data.DataModelForChat

class Chat : Fragment() {
    private lateinit var binding: MfaFragmentChatBinding
    private val dataModel: DataModelForChat by activityViewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = MfaFragmentChatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        openFragment(R.id.FLTF1, Fragment1.newInstance())
        openFragment(R.id.FLTF2, Fragment2.newInstance())
        dataModel.messageToMainFragment.observe(activity as LifecycleOwner) { binding.ATitleChat.text = it }
    }

    companion object {
        @JvmStatic
        fun newInstance() = Chat()
    }
}