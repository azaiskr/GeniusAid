package com.bangkit.geniusaidapp.ui.screen.pengajuan

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.bangkit.geniusaidapp.R
import com.bangkit.geniusaidapp.ui.component.AddImage
import com.bangkit.geniusaidapp.ui.component.Ask1
import com.bangkit.geniusaidapp.ui.component.Ask10
import com.bangkit.geniusaidapp.ui.component.Ask11
import com.bangkit.geniusaidapp.ui.component.Ask12
import com.bangkit.geniusaidapp.ui.component.Ask2
import com.bangkit.geniusaidapp.ui.component.Ask3
import com.bangkit.geniusaidapp.ui.component.Ask4
import com.bangkit.geniusaidapp.ui.component.Ask5
import com.bangkit.geniusaidapp.ui.component.Ask6
import com.bangkit.geniusaidapp.ui.component.Ask7
import com.bangkit.geniusaidapp.ui.component.Ask8
import com.bangkit.geniusaidapp.ui.component.Ask9
import com.bangkit.geniusaidapp.ui.component.AskImage
import com.bangkit.geniusaidapp.ui.component.BtnBpnt
import com.bangkit.geniusaidapp.ui.component.BtnPbiJk
import com.bangkit.geniusaidapp.ui.component.BtnPkh
import com.bangkit.geniusaidapp.ui.component.BtnSubmitTaks
import com.bangkit.geniusaidapp.ui.component.ItemPengajuan
import com.bangkit.geniusaidapp.ui.component.imageCaptureFromCamera

@Composable
fun ContentPengajuan(navController: NavHostController) {


    Column (
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize().padding(8.dp)
            .background(color = colorResource(id = R.color.whiteBlueLight)),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        BtnBpnt(navController)
        BtnPkh(navController)
        BtnPbiJk(navController)
        ItemPengajuan()
    }

}

@Composable
fun AskPengajuan(navController: NavHostController) {
    Column (
        modifier = Modifier.background(color = colorResource(id = R.color.white)),
    ){
        Text(
            text = "ASK Pengajuan",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp, 16.dp, 16.dp, 8.dp))
        Column (
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .background(color = colorResource(id = R.color.whiteBlueLight))
                .padding(5.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "BPNT",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
            )
            Text(
                text = "Isilah data dibawah ini secara jujur dan benar",
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
            )


            Ask1()
            Ask2()
            Ask3()
            Ask4()
            Ask5()
            Ask6()
            Ask7()
            Ask8()
            Ask9()
            Ask10()
            Ask11()
            Ask12()
            AskImage()
            BtnSubmitTaks(navController = navController)
        }

    }



}