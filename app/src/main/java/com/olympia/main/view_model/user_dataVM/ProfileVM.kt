package com.olympia.main.view_model.user_dataVM

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olympia.main.model.UserDataEntity
import com.olympia.main.use_case.UserUseCases
import com.olympia.main.view.Info
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileVM @Inject constructor(private val useCases: UserUseCases) : ViewModel() {
    private val userDataSF = MutableStateFlow<UserDataEntity?>(null)
    val userDataS = userDataSF.asStateFlow()
    init {
        getData()
    }
    fun getData() {
        viewModelScope.launch {
            useCases.getUsers.getDataOfAllUsers().onEach { list ->
                val user = list.find { it.userName == Info.userName && it.password == Info.password }
                if (user != null) userDataSF.emit(user)
            }.launchIn(viewModelScope)
        }
    }
}