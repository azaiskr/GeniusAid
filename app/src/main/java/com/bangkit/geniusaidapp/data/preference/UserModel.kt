package com.bangkit.geniusaidapp.data.preference

data class UserModel(
    val token: String,
    val name: String,
    val nik: String,
    val isLogin: Boolean = false
)