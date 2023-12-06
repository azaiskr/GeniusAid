package com.bangkit.geniusaidapp.ui.screen.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginUserPage(navController: NavHostController) {

    var nik = remember { mutableStateOf("")}
    var namaIbu = remember { mutableStateOf("") }
    var ttl = remember { mutableStateOf("") }
    Column (
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxSize()
            .padding(16.dp, 20.dp, 16.dp, 0.dp)
            .background(color = colorResource(id = R.color.whiteBlueLight)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Hallo !",
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            color = colorResource(id = R.color.navy),
            modifier = Modifier.padding(top = 60.dp),
        )

        Text(
            text = "Untuk dapat masuk ke aplikasi, lengapi datamu dulu ya!",
            fontWeight = FontWeight.Normal,
            fontSize = 17.sp,
            color = colorResource(id = R.color.black),
            modifier = Modifier.padding(14.dp),
            textAlign = TextAlign.Center
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
                value = nik.value,
                onValueChange = {nik.value = it},
                placeholder = {
                    Text(text = "Masukkan Nik Anda")
                },
                singleLine = true,
                modifier = Modifier.fillMaxSize(8.8f),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                )
            )

            Spacer(modifier = Modifier.padding(20.dp))

            Text(
                text = "Nama Ibu Kandung",
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                color = colorResource(id = R.color.navy),
            )
            OutlinedTextField(
                value = namaIbu.value,
                onValueChange = {namaIbu.value = it},
                placeholder = {
                    Text(text = "Nama Lengkap")
                },
                singleLine = true,
                modifier = Modifier.fillMaxSize(8.8f),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),

            )

            Spacer(modifier = Modifier.padding(20.dp))
            Text(
                text = "Tanggal Lahir",
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                color = colorResource(id = R.color.navy),
            )
            OutlinedTextField(
                value = ttl.value,
                onValueChange = {ttl.value = it},
                placeholder = {
                    Text(text = "YYYY-MM-DD")
                },
                singleLine = true,
                modifier = Modifier.fillMaxSize(8.8f),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                )
            )
            Spacer(modifier = Modifier.padding(20.dp))

            Button(
                onClick = {navController.navigate("home")},
                Modifier.fillMaxWidth()
                    .padding(top = 8.dp, bottom = 20.dp),
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.navy)),

            ) {
                Text(
                    text = "Submit",
                    color = colorResource(id = R.color.whiteBlue)
                )

            }


        }



    }
    
}