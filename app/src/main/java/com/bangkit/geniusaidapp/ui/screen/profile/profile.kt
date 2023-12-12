package com.bangkit.geniusaidapp.ui.screen.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.bangkit.geniusaidapp.R
import com.bangkit.geniusaidapp.ui.component.Email
import com.bangkit.geniusaidapp.ui.component.ImageAdd
import com.bangkit.geniusaidapp.ui.component.Info
import com.bangkit.geniusaidapp.ui.component.NoTlp

@Composable
fun ContentProfile(navHostController: NavHostController){
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Text(
                text = "Profile",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(14.dp)
            )

        }
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
            Button(
                onClick = {navHostController.navigate("loginuser")},
                Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 20.dp),
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.red)),

                ) {
                Text(
                    text = "LogOut",
                )
            }

        }
    }

}