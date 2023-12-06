package com.olympia.main.model.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.olympia.main.model.UserDataEntity
import com.olympia.main.model.verification.check_password.ICheckPassword
import kotlinx.coroutines.flow.Flow

@Dao
interface IUserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdateUser(user: UserDataEntity)
    @Delete
    suspend fun deleteUser(user: UserDataEntity)
    @Query("SELECT * FROM UserDataEntity")
    fun getUsers(): Flow<List<UserDataEntity>>
    @Query("SELECT * FROM UserDataEntity WHERE userName = :userName AND password = :password")
    suspend fun getUser(userName: String, password: String): UserDataEntity?
}