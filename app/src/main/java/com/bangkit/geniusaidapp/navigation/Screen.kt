package com.bangkit.geniusaidapp.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Pengajuan : Screen("pengajuan")
    object Profile : Screen("profile")
    object DetailBansos : Screen("cekbansos/{bansos}") {
        fun createRoute(Id: Long) = "home/$Id"
    }
}