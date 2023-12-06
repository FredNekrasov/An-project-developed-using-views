package com.olympia.main.view_model.user_dataVM

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olympia.main.use_case.UserUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddVM @Inject constructor(private val useCases: UserUseCases) : ViewModel() {
    private var result = 0
    fun enterUserData(userName: String, password: String, gender: String, birthday: String, email: String): Int {
        viewModelScope.launch {
            result = useCases.add.add(null, userName, password, gender, birthday, email)
        }
        return result
    }
}