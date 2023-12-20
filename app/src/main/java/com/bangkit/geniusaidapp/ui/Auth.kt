package com.bangkit.geniusaidapp.ui

import android.content.Context
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bangkit.geniusaidapp.navigation.Screen
//import com.bangkit.geniusaidapp.ui.screen.login.LoginUser
import com.bangkit.geniusaidapp.ui.screen.login.LoginUserPage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Auth(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    context: Context
) {
    Scaffold (
        modifier = modifier,
    ){innerPadding ->
        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            startDestination = Screen.LoginUser.route,
        ){
            composable(Screen.LoginUser.route) {
                LoginUserPage(
                    navController = navController,
                    context = context)
            }


        }
    }

}