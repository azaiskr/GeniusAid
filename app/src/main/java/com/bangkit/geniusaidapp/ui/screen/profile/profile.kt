package com.bangkit.geniusaidapp.ui.screen.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.bangkit.geniusaidapp.R
import com.bangkit.geniusaidapp.ui.component.Email
import com.bangkit.geniusaidapp.ui.component.ImageAdd
import com.bangkit.geniusaidapp.ui.component.Info
import com.bangkit.geniusaidapp.ui.component.NoTlp

@Composable
fun ContentProfile(navHostController: NavHostController){
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
            .background(colorResource(id = R.color.whiteBlueLight)),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        ImageAdd()
        Info(navController = navHostController)
        Email(navController = navHostController)
        NoTlp(navController = navHostController)


    }

}