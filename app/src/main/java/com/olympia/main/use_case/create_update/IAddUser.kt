package com.olympia.main.use_case.create_update

import com.olympia.main.model.UserDataEntity

interface IAddUser {
    suspend fun add(
        id: Int?,
        userName: String,
        password: String,
        gender: String,
        birthday: String,
        email: String
    ): Int
}