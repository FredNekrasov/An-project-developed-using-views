package com.olympia.main.use_case.read

import com.olympia.main.model.UserDataEntity
import kotlinx.coroutines.flow.Flow

interface IGetUsers {
    fun getDataOfAllUsers(): Flow<List<UserDataEntity>>
}