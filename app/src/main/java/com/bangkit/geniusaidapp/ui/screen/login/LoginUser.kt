package com.bangkit.geniusaidapp.ui.screen.login

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.bangkit.geniusaidapp.R
import com.bangkit.geniusaidapp.ui.theme.GeniusAidAppTheme
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginUserPage(navController: NavHostController) {

    var nik by remember { mutableStateOf("")}
    var namaIbu by remember { mutableStateOf("") }
    var ttl by remember { mutableStateOf("") }

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
                value = nik,
                onValueChange = {nik = it},
                placeholder = {
                    Text(text = "Masukkan Nik Anda")
                },
                singleLine = true,
                modifier = Modifier.fillMaxSize(8.8f),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                leadingIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.barcode_scanner),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }
                
            )

            Spacer(modifier = Modifier.padding(20.dp))

            Text(
                text = "Nama Ibu Kandung",
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                color = colorResource(id = R.color.navy),
            )
            OutlinedTextField(
                value = namaIbu,
                onValueChange = {namaIbu = it},
                placeholder = {
                    Text(text = "Nama Lengkap")
                },
                singleLine = true,
                modifier = Modifier.fillMaxSize(8.8f),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                leadingIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.face_4),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                }

            )

            Spacer(modifier = Modifier.padding(20.dp))
            Text(
                text = "Tanggal Lahir",
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                color = colorResource(id = R.color.navy),
            )
            OutlinedTextField(
                value = ttl,
                onValueChange = {ttl = it},
                placeholder = {
                    Text(text = "YYYY-MM-DD")
                },
                singleLine = true,
                modifier = Modifier.fillMaxSize(8.8f),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                leadingIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.event_note),
                            contentDescription = null,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                },
            )
            Spacer(modifier = Modifier.padding(20.dp))

            Button(
                onClick = {navController.navigate("home")},
                Modifier
                    .fillMaxWidth()
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
