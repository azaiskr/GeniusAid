package com.bangkit.geniusaidapp.model


data class ProfileBansosList(
    val bansosProviderId: Int,
    val logoUrl: String,
    val name: String,
    val description: String,
    val alias: String,
    val totalPenerima: Int,
    val totalPeriode: Int,
)
