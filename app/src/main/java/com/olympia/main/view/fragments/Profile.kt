package com.olympia.main.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.olympia.databinding.FragmentProfileBinding
import com.olympia.main.view_model.user_dataVM.ProfileVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Profile : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private val viewModel: ProfileVM by activityViewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()
        viewModel.getData()
        binding.UserNameOnProfile.text = viewModel.userDataS.value?.userName
        binding.PasswordOnProfile.text = viewModel.userDataS.value?.password
        binding.GenderOnProfile.text = viewModel.userDataS.value?.gender
        binding.BirthdayOnProfile.text = viewModel.userDataS.value?.dateOfBirth
        binding.EmailOnProfile.text = viewModel.userDataS.value?.email
        binding.BGoBackOnProfile.setOnClickListener { navController.navigateUp() }
    }
}