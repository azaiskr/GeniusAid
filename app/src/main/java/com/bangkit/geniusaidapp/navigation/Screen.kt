package com.bangkit.geniusaidapp.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object DetailProfileBansos : Screen("home/{bansosId}") {
        fun createRoute(bansosId: Long) = "home/$bansosId"
    }
    object Pengajuan : Screen("pengajuan")
    object Profile : Screen("profile")
    object LoginUser : Screen("loginuser")
    object CekBansos : Screen("cekbansos") {
    }

    object HasilCekBansos : Screen("hasilcekbansos") {
    }


    object AskPengajuan : Screen("pengajuan/{Id}") {
        fun createRoute(Id: Long) = "pengajuan/$Id"
    }

    object Menu : Screen("menu/{Id}") {
        fun createRoute(Id: Long) = "pengajuan/$Id"
    }


//    object DetailCrew : Screen("home/{crewId}") {
//        fun createRoute(crewId: Long) = "home/$crewId"
//    }



}