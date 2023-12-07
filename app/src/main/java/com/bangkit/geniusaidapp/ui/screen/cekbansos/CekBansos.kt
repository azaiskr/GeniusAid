package com.bangkit.geniusaidapp.ui.screen.cekbansos

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.bangkit.geniusaidapp.R

//@Composable
//fun ContentCekBansos(
//
//) {
//
//
//
//}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContentCekBansos(navController: NavHostController) {

    var provinsi = remember { mutableStateOf("") }
    var kabupaten = remember { mutableStateOf("") }
    var kecamatan = remember { mutableStateOf("") }
    var kelurahan = remember { mutableStateOf("") }
    var namaKtp = remember { mutableStateOf("") }


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

        Column (
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .background(color = colorResource(id = R.color.whiteBlueLight))
                .padding(5.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "Cek Bansos",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = colorResource(id = R.color.navy),
                modifier = Modifier.align(Start)
            )

            Text(
                text = "Untuk dapat masuk ke aplikasi, lengapi datamu dulu ya!",
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp,
                color = colorResource(id = R.color.black),
                modifier = Modifier.align(Start),
                textAlign = TextAlign.Start
            )


            Column {
                Spacer(modifier = Modifier.padding(top = 4.dp))
                Text(
                    text = "NIK",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    color = colorResource(id = R.color.navy),
                )
                OutlinedTextField(
                    value = provinsi.value,
                    onValueChange = {provinsi.value = it},
                    placeholder = {
                        Text(text = "Pilih Profinsi")
                    },
                    singleLine = true,
                    modifier = Modifier.fillMaxSize(8.8f),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    )
                )

                Spacer(modifier = Modifier.padding(10.dp))

                Text(
                    text = "Kabupaten/Kota",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    color = colorResource(id = R.color.navy),
                )
                OutlinedTextField(
                    value = kabupaten.value,
                    onValueChange = {kabupaten.value = it},
                    placeholder = {
                        Text(text = "Pilih Kabupaten/Kota")
                    },
                    singleLine = true,
                    modifier = Modifier.fillMaxSize(8.8f),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    ),

                    )

                Spacer(modifier = Modifier.padding(10.dp))
                Text(
                    text = "Kacamatan",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    color = colorResource(id = R.color.navy),
                )
                OutlinedTextField(
                    value = kecamatan.value,
                    onValueChange = {kecamatan.value = it},
                    placeholder = {
                        Text(text = "Pilih Kelurahan/Desa")
                    },
                    singleLine = true,
                    modifier = Modifier.fillMaxSize(8.8f),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    )
                )
                Spacer(modifier = Modifier.padding(10.dp))

                Text(
                    text = "Kelurahan/Desa",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    color = colorResource(id = R.color.navy),
                )
                OutlinedTextField(
                    value = kelurahan.value,
                    onValueChange = {kelurahan.value = it},
                    placeholder = {
                        Text(text = "Pilih Keurahan/Desa")
                    },
                    singleLine = true,
                    modifier = Modifier.fillMaxSize(8.8f),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    )
                )
                Spacer(modifier = Modifier.padding(10.dp))

                Text(
                    text = "Nama Sesuai KTP",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    color = colorResource(id = R.color.navy),
                )
                OutlinedTextField(
                    value = namaKtp.value,
                    onValueChange = {namaKtp.value = it},
                    placeholder = {
                        Text(text = "Maukkan Nama Sesuai KTP")
                    },
                    singleLine = true,
                    modifier = Modifier.fillMaxSize(8.8f),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    )
                )
                Spacer(modifier = Modifier.padding(10.dp))

                Button(
                    onClick = {navController.navigate("hasilcekbansos")},
                    Modifier.fillMaxWidth()
                        .padding(top = 8.dp, bottom = 20.dp),
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.navy)),

                    ) {
                    Text(
                        text = "Cari Data",
                        color = colorResource(id = R.color.whiteBlue)
                    )
                }
            }
        }

    }



}
    
