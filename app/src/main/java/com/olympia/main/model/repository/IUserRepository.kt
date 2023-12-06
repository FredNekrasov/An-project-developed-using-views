package com.olympia.main.model.repository

import com.olympia.main.model.UserDataEntity
import kotlinx.coroutines.flow.Flow

interface IUserRepository {
    suspend fun insertOrUpdateUser(user: UserDataEntity)
    suspend fun deleteUser(user: UserDataEntity)
    fun getUsers(): Flow<List<UserDataEntity>>
    suspend fun getUser(userName: String, password: String): UserDataEntity?
}