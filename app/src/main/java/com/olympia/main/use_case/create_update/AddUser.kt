package com.olympia.main.use_case.create_update

import com.olympia.main.model.UserDataEntity
import com.olympia.main.model.repository.IUserRepository
import com.olympia.main.model.verification.check_date.ICheckDateOfBirth
import com.olympia.main.model.verification.check_email.ICheckEmail
import com.olympia.main.model.verification.check_gender.ICheckGender
import com.olympia.main.model.verification.check_password.ICheckPassword
import com.olympia.main.model.verification.check_user_name.ICheckUserName
import javax.inject.Inject

class AddUser @Inject constructor(
    private val repository: IUserRepository,
    private val checkUserName: ICheckUserName,
    private val checkPassword: ICheckPassword,
    private val checkGender: ICheckGender,
    private val checkDateOfBirth: ICheckDateOfBirth,
    private val checkEmail: ICheckEmail
) : IAddUser {
    private var int = 0
    override suspend fun add(id: Int?, userName: String, password: String, gender: String, birthday: String, email: String): Int {
        int = 0
        if (checkUserName.check(userName) == null) int += 5
        if (checkPassword.check(password) == null) int += 40
        if (checkGender.check(gender) == null) int += 300
        if (checkDateOfBirth.check(birthday) == null) int += 2000
        if (checkEmail.check(email) == null) int += 10000
        if (int != 0) return int
        val user = UserDataEntity(id, userName, password, gender, birthday, email)
        repository.insertOrUpdateUser(user)
        return int
    }
}