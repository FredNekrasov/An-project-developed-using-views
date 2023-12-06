package com.olympia.main.model.verification.check_user_name

import javax.inject.Inject

class CheckUserName @Inject constructor() : ICheckUserName {
    override fun check(inf: String): String? = if (inf.isNotEmpty() && inf.isNotBlank()) inf else null
}