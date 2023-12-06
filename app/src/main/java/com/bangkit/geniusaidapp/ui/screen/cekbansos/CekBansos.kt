package com.bangkit.geniusaidapp.ui.screen.cekbansos

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bangkit.geniusaidapp.R

@Composable
fun ContentCekBansos(

) {

    Column(
       modifier = Modifier.fillMaxWidth().background(color = colorResource(id = R.color.white)),
    ){


        Text(
            text = "Cek Bansos",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp, 16.dp, 16.dp, 8.dp)
        )

    }

}


    
