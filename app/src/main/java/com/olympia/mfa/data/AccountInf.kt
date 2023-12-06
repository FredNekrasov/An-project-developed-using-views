package com.olympia.mfa.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AccountInf: ViewModel() {
    val userName: MutableLiveData<String?> by lazy { MutableLiveData<String?>() }
    val password: MutableLiveData<String?> by lazy { MutableLiveData<String?>() }
    val surname: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val name: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val patronymic: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val avatarId: MutableLiveData<Int> by lazy { MutableLiveData<Int>() }
}