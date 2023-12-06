package com.olympia.main.di

import com.olympia.main.model.verification.check_date.CheckDateOfBirth
import com.olympia.main.model.verification.check_date.ICheckDateOfBirth
import com.olympia.main.model.verification.check_email.CheckEmail
import com.olympia.main.model.verification.check_email.ICheckEmail
import com.olympia.main.model.verification.check_gender.CheckGender
import com.olympia.main.model.verification.check_gender.ICheckGender
import com.olympia.main.model.verification.check_password.CheckPassword
import com.olympia.main.model.verification.check_password.ICheckPassword
import com.olympia.main.model.verification.check_user_name.CheckUserName
import com.olympia.main.model.verification.check_user_name.ICheckUserName
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface IUserVerificationBinder {
    @Binds
    @Singleton
    fun bindCheckUserName(checkUserName: CheckUserName): ICheckUserName
    @Binds
    @Singleton
    fun bindCheckPassword(checkPassword: CheckPassword): ICheckPassword
    @Binds
    @Singleton
    fun bindCheckGender(checkGender: CheckGender): ICheckGender
    @Binds
    @Singleton
    fun bindCheckDateOfBirth(checkDataOfBirth: CheckDateOfBirth): ICheckDateOfBirth
    @Binds
    @Singleton
    fun bindCheckEmail(checkEmail: CheckEmail): ICheckEmail
}