package com.olympia.main.view_model.user_dataVM

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olympia.main.model.UserDataEntity
import com.olympia.main.use_case.UserUseCases
import com.olympia.main.view.Info
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DeleteVM @Inject constructor(private val useCases: UserUseCases) : ViewModel() {
    private var userList = MutableStateFlow<List<UserDataEntity>>(emptyList())
    init {
        useCases.getUsers.getDataOfAllUsers().onEach{
            userList.value = it
        }.launchIn(viewModelScope)
    }
    fun deleteUserData() {
        val data = userList.value.find { it.userName == Info.userName && it.password == Info.password }
        viewModelScope.launch {
            if (data == null) return@launch
            useCases.delete.delete(data)
        }
    }
}