package com.bangkit.geniusaidapp.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.bangkit.geniusaidapp.R
import com.bangkit.geniusaidapp.ui.component.BtnCekBansos
import com.bangkit.geniusaidapp.ui.component.MainListBansosProcess
import com.bangkit.geniusaidapp.ui.theme.GeniusAidAppTheme
import kotlinx.coroutines.launch

@Composable
fun ContentHome(navController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize().padding(8.dp)
                .background(color = colorResource(id = R.color.whiteBlueLight)),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Hallo, Ahkam Putra",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                textAlign = TextAlign.End,
                color = colorResource(id = R.color.black)
            )
            Text(
                text = "Profile Bantuan Sosial",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                textAlign = TextAlign.Start,
                color = colorResource(id = R.color.fontblue)
            )
            Text(
                text = "Berikut adalah Bantuan Sosial yang anda dapatkan maupun yang sedang di proses ",
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                textAlign = TextAlign.Start,
                color = colorResource(id = R.color.black)
            )
            MainListBansosProcess()
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 4.dp),
                horizontalArrangement = Arrangement.End
            ){
                BtnCekBansos(navController= navController)
            }


        }
    }

}

@Composable
fun Menu() {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.navy)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Text(
            text = "Menu",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = colorResource(id = R.color.whiteBlue),
            modifier = Modifier
                .padding(start = 30.dp, bottom = 12.dp)
                .align(Start)

        )

        Button(
            onClick = { /*TODO*/ },
            Modifier
                .width(300.dp)
                .height(50.dp)
                .padding(bottom = 8.dp),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.whiteBlue))

        ) {
            Text(
                text = "Ganti Sandi Akun",
                color = colorResource(id = R.color.navy)
            )
            
        }
        Button(
            onClick = { /*TODO*/ },
            Modifier
                .width(300.dp)
                .height(50.dp)
                .padding(bottom = 8.dp),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.red))

        ) {
            Text(text = "Keluar")
        }

    }
    
}

@Preview
@Composable
fun MenuPrev() {
    GeniusAidAppTheme {
        Menu()
    }
    
}


//@Composable
//fun ModalBottomSheet(onDismissRequest: () -> Unit, content: () -> Unit) {
//    val sheetState = rememberModalBottomSheetState()
//    val scope = rememberCoroutineScope()
//    var showBottomSheet by remember { mutableStateOf(false) }
//    Scaffold(
//        floatingActionButton = {
//            ExtendedFloatingActionButton(
//                text = { Text("Show bottom sheet") },
//                icon = { Icon(Icons.Filled.Add, contentDescription = "") },
//                onClick = {
//                    showBottomSheet = true
//                }
//            )
//        }
//    ) { contentPadding ->
//        // Screen content
//
//        if (showBottomSheet) {
//            ModalBottomSheet(
//                onDismissRequest = {
//                    showBottomSheet = false
//                },
//                sheetState = sheetState
//            ) {
//                // Sheet content
//                Button(onClick = {
//                    scope.launch { sheetState.hide() }.invokeOnCompletion {
//                        if (!sheetState.isVisible) {
//                            showBottomSheet = false
//                        }
//                    }
//                }) {
//                    Text("Hide bottom sheet")
//                }
//            }
//        }
//    }
//
//}
