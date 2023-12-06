package com.olympia.main.use_case.read

import com.olympia.main.model.UserDataEntity
import com.olympia.main.model.repository.IUserRepository
import javax.inject.Inject

class GetUser @Inject constructor(private val repository: IUserRepository) : IGetUser {
    override suspend fun getUserData(userName: String, password: String): UserDataEntity? {
        return repository.getUser(userName, password)
    }
}