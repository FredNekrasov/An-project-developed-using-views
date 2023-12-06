package com.olympia.main.model.verification.check_password

interface ICheckPassword {
    fun check(inf: String): String?
}