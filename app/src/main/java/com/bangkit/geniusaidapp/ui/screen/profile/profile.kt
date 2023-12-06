package com.bangkit.geniusaidapp.ui.screen.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.bangkit.geniusaidapp.R
import com.bangkit.geniusaidapp.ui.component.Email
import com.bangkit.geniusaidapp.ui.component.ImageProfile
import com.bangkit.geniusaidapp.ui.component.Info
import com.bangkit.geniusaidapp.ui.component.NoTlp
import com.bangkit.geniusaidapp.ui.component.imageCaptureFromCamera
import com.bangkit.geniusaidapp.ui.theme.GeniusAidAppTheme

@Composable
fun ContentProfile(navHostController: NavHostController){
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .padding(8.dp)
            .background(colorResource(id = R.color.whiteBlueLight)),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        ImageProfile()
        Info(navController = navHostController)
        Email(navController = navHostController)
        NoTlp(navController = navHostController)


    }

}