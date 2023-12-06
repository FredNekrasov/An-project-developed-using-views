package com.olympia.main.model.repository

import com.olympia.main.model.UserDataEntity
import com.olympia.main.model.database.IUserDao
import kotlinx.coroutines.flow.Flow

class UserRepository (private val dao: IUserDao) : IUserRepository {
    override suspend fun insertOrUpdateUser(user: UserDataEntity) {
        dao.insertOrUpdateUser(user)
    }

    override suspend fun deleteUser(user: UserDataEntity) {
        dao.deleteUser(user)
    }

    override fun getUsers(): Flow<List<UserDataEntity>> {
        return dao.getUsers()
    }

    override suspend fun getUser(userName: String, password: String): UserDataEntity? {
        return dao.getUser(userName, password)
    }
}