package com.olympia.main.use_case.delete

import com.olympia.main.model.UserDataEntity

interface IDeleteUser {
    suspend fun delete(user: UserDataEntity)
}