package com.olympia.mfa.entrance

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.olympia.R
import com.olympia.databinding.MfaFragmentSignUpBinding
import com.olympia.mfa.data.AccountInf

class SignUp : Fragment() {
    private lateinit var binding: MfaFragmentSignUpBinding
    private val dataModel: AccountInf by activityViewModels()
    private val imageArray = arrayOf(
        R.drawable.kotik_i_sneg,
        R.drawable.kot,
        R.drawable.shavermik,
        R.drawable.cat_and_bread,
        R.drawable.cat_on_halloween,
        R.drawable.zhivotnoe_koshka_dom,
        R.drawable.winter_snow_animals_cat,
        R.drawable.kot_spit
    )
    private var i = 0
    private var imageId = R.drawable.kot_spit
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = MfaFragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val controller = findNavController()
        binding.ChooseAvatar.setOnClickListener {
            if(binding.AvatarIV.visibility == View.VISIBLE){
                if (i > imageArray.size - 1) i = 0
                imageId = imageArray[i]
                i++
                binding.AvatarIV.setImageResource(imageId)
            } else {
                binding.AvatarIV.visibility = View.VISIBLE
                binding.ChooseAvatar.text = getString(R.string.ChooseMFA)
            }
        }
        binding.SaveData2.setOnClickListener {
            dataModel.userName.value = binding.UNText2.text.toString()
            dataModel.password.value = binding.UserPass2.text.toString()
            dataModel.surname.value = binding.Surname.text.toString()
            dataModel.name.value = binding.Name.text.toString()
            dataModel.patronymic.value = binding.Patronymic.text.toString()
            dataModel.avatarId.value = imageId
            controller.navigateUp()
        }
        binding.GoBackOnSignUp.setOnClickListener { controller.navigateUp() }
    }
    companion object {
        @JvmStatic
        fun newInstance() = SignUp()
    }
}