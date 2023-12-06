package com.olympia.main.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity
data class UserDataEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val userName: String,
    val password: String,
    val gender: String,
    val dateOfBirth: String,
    val email: String,
    val registerDate: String = LocalDate.now().toString()
)