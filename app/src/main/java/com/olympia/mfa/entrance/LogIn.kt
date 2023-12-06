package com.olympia.mfa.entrance

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.olympia.databinding.MfaFragmentLogInBinding
import com.olympia.mfa.data.AccountInf

class LogIn : Fragment() {
    private lateinit var binding: MfaFragmentLogInBinding
    private val dataModel: AccountInf by activityViewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = MfaFragmentLogInBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val controller = findNavController()
        binding.SaveData.setOnClickListener {
            dataModel.userName.value = binding.UNText.text.toString()
            dataModel.password.value = binding.UserPass.text.toString()
            controller.navigateUp()
        }
        binding.GoBackOnLogIn.setOnClickListener { controller.navigateUp() }
    }
    companion object {
        @JvmStatic
        fun newInstance() = LogIn()
    }
}