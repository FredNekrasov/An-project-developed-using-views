package com.olympia.mfa.data

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class DataModelForChat: ViewModel() {
    val messageToFragment1: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val messageToFragment2: MutableLiveData<String> by lazy { MutableLiveData<String>() }
    val messageToMainFragment: MutableLiveData<String> by lazy { MutableLiveData<String>() }
}