package com.olympia.main.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.olympia.R
import com.olympia.databinding.FragmentEditBinding
import com.olympia.main.view.message
import com.olympia.main.view.setData
import com.olympia.main.view_model.user_dataVM.EditVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditFragment : Fragment() {
    private lateinit var binding: FragmentEditBinding
    private val viewModel: EditVM by activityViewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentEditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()
        viewModel.getData()
        var res: Int
        binding.UserNameOnEdit.setText(viewModel.userDataS.value?.userName)
        binding.PasswordOnEdit.setText(viewModel.userDataS.value?.password)
        binding.GenderOnEdit.setText(viewModel.userDataS.value?.gender)
        binding.BirthdayOnEdit.setText(viewModel.userDataS.value?.dateOfBirth)
        binding.EmailOnEdit.setText(viewModel.userDataS.value?.email)
        binding.BSaveOnEdit.setOnClickListener {
            res = viewModel.enterUserData(
                binding.UserNameOnEdit.text.toString(),
                binding.PasswordOnEdit.text.toString(),
                binding.GenderOnEdit.text.toString(),
                binding.BirthdayOnEdit.text.toString(),
                binding.EmailOnEdit.text.toString()
            )
            if (res == 0) {
                setData(binding.UserNameOnEdit.text.toString(), binding.PasswordOnEdit.text.toString())
                navController.navigateUp()
            } else message(onError(res.toString()))
        }
        binding.BGoBackOnEdit.setOnClickListener { navController.navigateUp() }
    }
    private fun onError(res: String): String {
        var errors = ""
        if (res.contains("9")) errors += "${getString(R.string.existing_user_name)}\n"
        if (res.contains("5")) errors += "${getString(R.string.invalid_user_name)}\n"
        if (res.contains("4")) errors += "${getString(R.string.invalid_password)}\n"
        if (res.contains("3")) errors += "${getString(R.string.invalid_gender)}\n"
        if (res.contains("2")) errors += "${getString(R.string.incorrect_date_of_birth_data)}\n"
        if (res.contains("1")) errors += getString(R.string.invalid_email)
        return errors
    }
}