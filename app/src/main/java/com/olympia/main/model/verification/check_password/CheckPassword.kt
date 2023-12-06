package com.olympia.main.model.verification.check_password

import javax.inject.Inject

class CheckPassword @Inject constructor() : ICheckPassword {
    override fun check(inf: String): String?  = if (inf.isNotEmpty() && inf.isNotBlank()) inf else null
}