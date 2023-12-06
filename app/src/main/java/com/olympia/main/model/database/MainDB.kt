package com.olympia.main.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.olympia.main.model.UserDataEntity
import javax.inject.Singleton

@Singleton
@Database(entities = [UserDataEntity::class], version = 1)
abstract class MainDB : RoomDatabase() {
    abstract val userDAO: IUserDao
    companion object {
        const val DB_NAME = "MainDB.db"
    }
}