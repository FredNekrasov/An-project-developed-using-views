package com.olympia.main.view.fragments.entrance

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.olympia.R
import com.olympia.databinding.FragmentAuthorizationBinding
import com.olympia.main.view.message
import com.olympia.main.view.setData
import com.olympia.main.view_model.user_dataVM.LogInVM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Authorization : Fragment() {
    private lateinit var binding: FragmentAuthorizationBinding
    private val viewModel: LogInVM by activityViewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAuthorizationBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()
        val errors = "${getString(R.string.invalid_user_name)}\n${getString(R.string.invalid_password)}\n"
        binding.BLogInOnMain.setOnClickListener {
            val res = viewModel.checkData(binding.UserNameOnLogIn.text.toString(), binding.PasswordOnLogIn.text.toString())
            if (res == 0){
                setData(binding.UserNameOnLogIn.text.toString(), binding.PasswordOnLogIn.text.toString())
                navController.navigate(R.id.mainFragment)
            } else message(errors)
        }
        binding.BSignUpOnMain.setOnClickListener { navController.navigate(R.id.registration) }
    }
}