package com.olympia.main.model.verification.check_gender

import javax.inject.Inject

class CheckGender @Inject constructor() : ICheckGender {
    override fun check(inf: String): String? = if (inf.isNotEmpty() && inf.isNotBlank()) inf else null
}