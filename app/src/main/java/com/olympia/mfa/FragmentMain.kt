package com.olympia.mfa

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.fragment.findNavController
import com.olympia.R
import com.olympia.databinding.MfaFragmentMainBinding
import com.olympia.main.view.message
import com.olympia.mfa.data.AccountInf

class FragmentMain : Fragment() {
    private lateinit var binding: MfaFragmentMainBinding
    private val dataModel: AccountInf by activityViewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = MfaFragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val controller = findNavController()
        if (dataModel.userName.value?.isNotEmpty() == true) {
            binding.IVAvatar.visibility = View.VISIBLE
            dataModel.avatarId.observe(activity as LifecycleOwner) {
                binding.IVAvatar.setImageResource(it)
            }
            var textInfo = ""
            dataModel.surname.observe(activity as LifecycleOwner) { textInfo += it }
            dataModel.name.observe(activity as LifecycleOwner) { textInfo += " $it " }
            dataModel.patronymic.observe(activity as LifecycleOwner) { textInfo += it }
            binding.inf.text = textInfo
            binding.status.visibility = View.VISIBLE
            binding.TBMode.visibility = View.VISIBLE
            binding.BNVMenu.visibility = View.VISIBLE
            binding.LIAE.text = getString(R.string.ExitMFA)
            binding.SignUp.visibility = View.GONE
        }
        binding.LIAE.setOnClickListener {
            if (binding.LIAE.text == getString(R.string.ExitMFA)) {
                binding.IVAvatar.visibility = View.GONE
                binding.inf.text = ""
                binding.status.visibility = View.GONE
                binding.TBMode.visibility = View.GONE
                binding.BNVMenu.visibility = View.GONE
                binding.LIAE.text = getString(R.string.log_inMFA)
                binding.SignUp.visibility = View.VISIBLE
            } else controller.navigate(R.id.logIn)
        }
        binding.SignUp.setOnClickListener { controller.navigate(R.id.signUp) }
        binding.TBMode.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.removeTB -> binding.TBMode.visibility = View.GONE
                else -> message("this function hasn't been created yet")
            }
            true
        }
        binding.BNVMenu.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.settings -> binding.MFADL.openDrawer(GravityCompat.END)
                R.id.accountInf -> message("this function hasn't been created yet")
                R.id.removeBNV -> binding.BNVMenu.visibility = View.GONE
            }
            true
        }
        binding.NVMenu.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.returnTB -> binding.TBMode.visibility = View.VISIBLE
                R.id.returnBNV -> binding.BNVMenu.visibility = View.VISIBLE
                R.id.toGames -> controller.navigate(R.id.mainEntertainment)
                R.id.GoBackOnMFANV -> (activity as AppCompatActivity).finish()
                else -> message("this function hasn't been created yet")
            }
            binding.MFADL.closeDrawer(GravityCompat.END)
            true
        }
    }
}