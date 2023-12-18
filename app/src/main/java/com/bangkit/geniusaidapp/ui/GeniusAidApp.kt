package com.bangkit.geniusaidapp.ui


import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.bangkit.geniusaidapp.AuthActivity
import com.bangkit.geniusaidapp.navigation.Screen
import com.bangkit.geniusaidapp.ui.component.BottomBar
import com.bangkit.geniusaidapp.ui.screen.detailprofilebansos.DetailProfileBansos
import com.bangkit.geniusaidapp.ui.screen.home.ContentHome
import com.bangkit.geniusaidapp.ui.screen.pengajuan.AskPengajuan
import com.bangkit.geniusaidapp.ui.screen.pengajuan.ContentPengajuan
import com.bangkit.geniusaidapp.ui.screen.profile.ContentProfile
import com.bangkit.geniusaidapp.ui.screen.statusbansos.ContentHasilStatusBansos


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GeniusAidApp(
    context : Context,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
){
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val sharedPreferences =
        LocalContext.current.getSharedPreferences("login_status", Context.MODE_PRIVATE)
    val isLoggedIn =
        remember { mutableStateOf(sharedPreferences.getBoolean("is_logged_in", false)) }

    if (!isLoggedIn.value) {
        // Jika sudah login, langsung arahkan ke MainActivity atau halaman setelah login
        val intent = Intent(LocalContext.current, AuthActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        LocalContext.current.startActivity(intent)
    } else {
        Scaffold(
            bottomBar = {
                if (currentRoute != Screen.AskPengajuan.route && currentRoute != Screen.HasilStatusBansos.route
                    && currentRoute != Screen.DetailProfileBansos.route ) {
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

                composable(Screen.Home.route) {
                    ContentHome(
                        context = context,
                        navigateToDetailBansos = { name ->
                            navController.navigate(Screen.DetailProfileBansos.createRoute(name))
                        },
                        navController = navController,
                    )

                }

                composable(
                    route = Screen.DetailProfileBansos.route,
                    arguments = listOf(
                        navArgument("name") { type = NavType.StringType }
                    )
                ) {
                    val name = it.arguments?.getString("name") ?: ""

                    DetailProfileBansos(name = name, navController = navController, context = context)
                }
                composable(Screen.HasilStatusBansos.route) {
                    ContentHasilStatusBansos(navController, context)

                }
                composable(Screen.Pengajuan.route) {
                    ContentPengajuan(navController)

                }
                composable(Screen.AskPengajuan.route) {
                    AskPengajuan(navController)

                }
                composable(Screen.Profile.route) {
                    ContentProfile(navController, context)
                }

            }

        }

    }

}


