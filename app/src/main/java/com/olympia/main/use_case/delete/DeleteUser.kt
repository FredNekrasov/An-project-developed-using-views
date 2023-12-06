package com.olympia.main.use_case.delete

import com.olympia.main.model.UserDataEntity
import com.olympia.main.model.repository.IUserRepository
import javax.inject.Inject

class DeleteUser @Inject constructor(private val repository: IUserRepository) : IDeleteUser {
    override suspend fun delete(user: UserDataEntity) {
        repository.deleteUser(user)
    }
}