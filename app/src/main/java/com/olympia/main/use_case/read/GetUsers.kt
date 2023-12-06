package com.olympia.main.use_case.read

import com.olympia.main.model.UserDataEntity
import com.olympia.main.model.repository.IUserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUsers @Inject constructor(private val repository: IUserRepository) : IGetUsers {
    override fun getDataOfAllUsers(): Flow<List<UserDataEntity>> {
        return repository.getUsers()
    }
}