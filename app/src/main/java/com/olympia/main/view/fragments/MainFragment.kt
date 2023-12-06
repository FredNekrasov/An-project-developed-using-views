package com.olympia.main.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.olympia.R
import com.olympia.databinding.FragmentMainBinding
import com.olympia.main.view.message
import com.olympia.main.view.openFragment
import com.olympia.main.view_model.user_dataVM.DeleteVM
import dagger.hilt.android.AndroidEntryPoint
import java.util.Locale

@AndroidEntryPoint
class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val viewModel: DeleteVM by activityViewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        openFragment(R.id.MyHealthFrame, Health.newInstance())
        openFragment(R.id.TrainingFrame, Training.newInstance())
        openFragment(R.id.HomeFrame, Home.newInstance())
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()
        binding.Navigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> {
                    if (binding.HomeFrame.visibility == View.GONE){
                        binding.MyHealthFrame.visibility = View.GONE
                        binding.TrainingFrame.visibility = View.GONE
                        binding.HomeFrame.visibility = View.VISIBLE
                    }
                }
                R.id.training -> {
                    if (binding.TrainingFrame.visibility == View.GONE) {
                        binding.MyHealthFrame.visibility = View.GONE
                        binding.HomeFrame.visibility = View.GONE
                        binding.TrainingFrame.visibility = View.VISIBLE
                    }
                }
                R.id.my_health -> {
                    if (binding.MyHealthFrame.visibility == View.GONE){
                        binding.TrainingFrame.visibility = View.GONE
                        binding.HomeFrame.visibility = View.GONE
                        binding.MyHealthFrame.visibility = View.VISIBLE
                    }
                }
                R.id.profile -> binding.MainDL.openDrawer(GravityCompat.END)
            }
            true
        }
        binding.NVMenu.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.personalData -> navController.navigate(R.id.profile2)
                R.id.editingData -> navController.navigate(R.id.editFragment)
                R.id.deleteAccount -> {
                    viewModel.deleteUserData()
                    navController.popBackStack(R.id.authorization, false)
                }
                R.id.changeLanguage -> {
                    val newLocale = if (resources.configuration.locales[0] == Locale("en")) Locale("ru") else Locale("en")
                    resources.configuration.setLocale(newLocale)
                    @Suppress("DEPRECATION")
                    resources.updateConfiguration(resources.configuration, resources.displayMetrics)
                    (activity as AppCompatActivity).recreate()
                }
                R.id.appInfo -> message(getString(R.string.app_name))
                R.id.exitFromAccount -> navController.popBackStack(R.id.authorization, false)
            }
            binding.MainDL.closeDrawer(GravityCompat.END)
            true
        }
    }
}