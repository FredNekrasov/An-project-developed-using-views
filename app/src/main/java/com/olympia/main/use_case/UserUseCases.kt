package com.olympia.main.use_case

import com.olympia.main.use_case.create_update.IAddUser
import com.olympia.main.use_case.delete.IDeleteUser
import com.olympia.main.use_case.read.IGetUser
import com.olympia.main.use_case.read.IGetUsers

data class UserUseCases(
    val add: IAddUser,
    val get: IGetUser,
    val getUsers: IGetUsers,
    val delete: IDeleteUser
)