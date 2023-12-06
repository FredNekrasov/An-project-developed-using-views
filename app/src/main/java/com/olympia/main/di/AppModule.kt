package com.olympia.main.di

import android.app.Application
import androidx.room.Room
import com.olympia.main.model.database.MainDB
import com.olympia.main.model.repository.IUserRepository
import com.olympia.main.model.repository.UserRepository
import com.olympia.main.use_case.UserUseCases
import com.olympia.main.use_case.create_update.AddUser
import com.olympia.main.use_case.delete.DeleteUser
import com.olympia.main.use_case.read.GetUser
import com.olympia.main.use_case.read.GetUsers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDatabase(app: Application): MainDB {
        return Room.databaseBuilder(app, MainDB::class.java, MainDB.DB_NAME).build()
    }
    @Provides
    @Singleton
    fun provideUserRepository(dao: MainDB): IUserRepository {
        return UserRepository(dao.userDAO)
    }
    @Provides
    @Singleton
    fun provideUserUseCases(
        add: AddUser,
        get: GetUser,
        getUsers: GetUsers,
        delete: DeleteUser
    ): UserUseCases {
        return UserUseCases(add, get, getUsers, delete)
    }
}