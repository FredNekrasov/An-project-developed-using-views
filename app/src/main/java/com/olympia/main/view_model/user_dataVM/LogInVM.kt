package com.olympia.main.view_model.user_dataVM

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olympia.main.model.UserDataEntity
import com.olympia.main.use_case.UserUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LogInVM @Inject constructor(private val useCases: UserUseCases) : ViewModel() {
    private var result = 0
    private var userList = MutableStateFlow<List<UserDataEntity>>(emptyList())
    init {
        viewModelScope.launch {
            useCases.getUsers.getDataOfAllUsers().collect{
                userList.value = it
            }
        }
    }
    fun checkData(userName: String, password: String): Int {
        result = 0
        val acc = userList.value.find { it.userName == userName && it.password == password }
        viewModelScope.launch {
            result = if (acc != null) useCases.add.add(
                acc.id,
                acc.userName,
                acc.password,
                acc.gender,
                acc.dateOfBirth,
                acc.email
            ) else 1
        }
        return result
    }
}