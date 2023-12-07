package com.bangkit.geniusaidapp.ui.screen.cekbansos

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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bangkit.geniusaidapp.R
import com.bangkit.geniusaidapp.navigation.Screen
import com.bangkit.geniusaidapp.ui.component.ItemDataOrangDkk
import com.bangkit.geniusaidapp.ui.component.ItemDataProfinsiDkk

@Composable
fun ContentHasilCekBansos() {
    Column (
        modifier = Modifier
            .background(color = colorResource(id = R.color.white))
            .fillMaxWidth(),
    ){
        Text(
            text = "Hasil Pencariaan Data",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp, 16.dp, 16.dp, 8.dp))

        Column {
            ItemDataProfinsiDkk()
        }
        Column (
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .background(color = colorResource(id = R.color.whiteBlueLight))
                .padding(5.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ItemDataOrangDkk()
        }
    }

}