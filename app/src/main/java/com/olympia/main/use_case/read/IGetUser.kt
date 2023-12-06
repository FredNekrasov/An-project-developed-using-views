package com.olympia.main.use_case.read

import com.olympia.main.model.UserDataEntity

interface IGetUser {
    suspend fun getUserData(userName: String, password: String): UserDataEntity?
}