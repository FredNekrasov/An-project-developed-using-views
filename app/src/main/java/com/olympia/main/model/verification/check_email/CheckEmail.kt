package com.olympia.main.model.verification.check_email

import javax.inject.Inject

class CheckEmail @Inject constructor() : ICheckEmail {
    override fun check(inf: String): String? = if (inf.isNotEmpty() && inf.isNotBlank() && (inf.contains("@gmail.com") || inf.contains("@mail.ru"))) inf else null
}