package com.bangkit.geniusaidapp.navigation

sealed class Screen(val route: String) {

    //    Main
    object Home : Screen("home")
    object DetailProfileBansos : Screen("home/{id}") {
        fun createRoute(id: Int) = "home/$id"
    }

    //////////
    object Pengajuan : Screen("pengajuan")
    object Question : Screen("pengajuan/{id}") {
        fun createRoute(id: Int) = "pengajuan/$id"
    }





    object Profile : Screen("profile")






//    Login
    object LoginUser : Screen("loginuser")




    object HasilStatusBansos : Screen("hasilcekbansos")
    object Coba : Screen("coba")



    object Menu : Screen("menu/{Id}") {
        fun createRoute(Id: Long) = "pengajuan/$Id"
    }


//    object DetailCrew : Screen("home/{crewId}") {
//        fun createRoute(crewId: Long) = "home/$crewId"
//    }



}