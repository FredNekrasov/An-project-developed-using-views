package com.olympia.main.model.verification.check_date

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import javax.inject.Inject

class CheckDateOfBirth @Inject constructor() : ICheckDateOfBirth {
    override fun check(inf: String): String? {
        return try {
            if (inf.isNotEmpty() && inf.isNotBlank() && (inf.contains(Regex("""^\d{2}\.\d{2}\.\d{4}$""")))) {
                val date = LocalDate.parse(inf, DateTimeFormatter.ofPattern("dd.MM.yyyy"))
                if (date < LocalDate.now()) inf else null
            } else null
        } catch (e: DateTimeParseException) {
            null
        }
    }
}