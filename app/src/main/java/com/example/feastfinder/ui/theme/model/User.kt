package com.example.feastfinder.ui.theme.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @PrimaryKey val id: Int,
    val email: String,
    val password: String
)