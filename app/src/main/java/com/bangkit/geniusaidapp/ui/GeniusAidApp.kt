package com.bangkit.geniusaidapp.ui


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.bangkit.geniusaidapp.navigation.Screen
import com.bangkit.geniusaidapp.ui.component.BottomBar
import com.bangkit.geniusaidapp.ui.screen.cekbansos.ContentCekBansos
import com.bangkit.geniusaidapp.ui.screen.cekbansos.ContentHasilCekBansos
import com.bangkit.geniusaidapp.ui.screen.detailprofilebansos.DetailProfileBansos
import com.bangkit.geniusaidapp.ui.screen.home.Home
import com.bangkit.geniusaidapp.ui.screen.login.LoginUserPage
import com.bangkit.geniusaidapp.ui.screen.pengajuan.AskPengajuan
import com.bangkit.geniusaidapp.ui.screen.pengajuan.ContentPengajuan
import com.bangkit.geniusaidapp.ui.screen.profile.ContentProfile



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GeniusAidApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    Scaffold(
        bottomBar = {
            if (currentRoute != Screen.CekBansos.route && currentRoute != Screen.AskPengajuan.route && currentRoute != Screen.LoginUser.route
                && currentRoute != Screen.HasilCekBansos.route && currentRoute != Screen.DetailProfileBansos.route ) {
                BottomBar(navController)
            }
        },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.LoginUser.route) {
                LoginUserPage(navController)
            }

            composable(Screen.Home.route) {
                Home(
                    navigateToDetailProfileBansos = { animalId ->
                        navController.navigate(Screen.DetailProfileBansos.createRoute(animalId))
                    },
                    navController = navController

                )

            }

            composable(
                route = Screen.DetailProfileBansos.route,
                arguments = listOf(
                    navArgument("bansosId") { type = NavType.LongType }
                )
            ) {
                val id = it.arguments?.getLong("bansosId") ?: -1L

                DetailProfileBansos(Id = id, navController = navController)
            }
            composable(Screen.CekBansos.route) {
                ContentCekBansos(navController)

            }
            composable(Screen.HasilCekBansos.route) {
                ContentHasilCekBansos(navController)

            }
            composable(Screen.Pengajuan.route) {
                ContentPengajuan(navController)

            }
            composable(Screen.AskPengajuan.route) {
                AskPengajuan(navController)

            }
            composable(Screen.Profile.route) {
                ContentProfile(navController)
            }

        }

    }

}


