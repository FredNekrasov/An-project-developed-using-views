package com.olympia.main.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olympia.main.model.UserDataEntity
import com.olympia.main.use_case.UserUseCases
import com.olympia.main.view.Info
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDataVM @Inject constructor(private val useCases: UserUseCases) : ViewModel() {
/*    private var result = 0
    private val userDataSF = MutableStateFlow<UserDataEntity?>(null)
    val userDataS = userDataSF.asStateFlow()
    fun enterUserData(userName: String, password: String, gender: String, birthday: String, email: String): Int {
        result = 0
        viewModelScope.launch {
            val info = useCases.get.getUserData(userName, password)
            result = if (info?.userName == Info.userName || info == null) useCases.add.add(userDataS.value?.id, userName, password, gender, birthday, email) else 9
        }
        return result
    }
    fun deleteUserData() {
        viewModelScope.launch {
            if (userDataS.value == null) return@launch
            useCases.delete.delete(userDataS.value!!)
        }
    }
    fun checkData(userName: String, password: String): Int {
        result = 0
        viewModelScope.launch {
            val acc = useCases.get.getUserData(userName, password)
            if (acc != null) useCases.add.logIn(acc) else result = 1
        }
        return result
    }
    fun getData(){
        viewModelScope.launch {
            val data = useCases.get.getUserData(Info.userName, Info.password) ?: return@launch
            userDataSF.emit(data)
        }
    }*/
}