package com.olympia.main.view.fragments.entrance

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.olympia.R
import com.olympia.databinding.FragmentRegistrationBinding
import com.olympia.main.view.message
import com.olympia.main.view.setData
import com.olympia.main.view_model.user_dataVM.AddVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Registration : Fragment() {
    private lateinit var binding: FragmentRegistrationBinding
    private val viewModel: AddVM by activityViewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()
        var res: Int
        binding.BSaveOnSignUp.setOnClickListener {
            res = viewModel.enterUserData(
                binding.UserNameOnSignUp.text.toString(),
                binding.PasswordOnSignUp.text.toString(),
                binding.GenderOnSignUp.text.toString(),
                binding.BirthdayOnSignUp.text.toString(),
                binding.EmailOnSignUp.text.toString()
            )
            if (res == 0) {
                setData(binding.UserNameOnSignUp.text.toString(), binding.PasswordOnSignUp.text.toString())
                navController.navigate(R.id.mainFragment)
            } else message(onError(res.toString()))
        }
        binding.BGoBackOnSignUp.setOnClickListener { navController.navigateUp() }
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