package com.bangkit.geniusaidapp.ui.screen.pengajuan

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.bangkit.geniusaidapp.R
import com.bangkit.geniusaidapp.data.di.Injection
import com.bangkit.geniusaidapp.ui.screen.ViewModelFactory
import com.bangkit.geniusaidapp.ui.theme.navy
import com.bangkit.geniusaidapp.ui.theme.whiteBlue

@Composable
fun ContentPengajuan(
    navController: NavHostController,
    context: Context,
    navigateToQuestion: (Int) -> Unit,
    viewModel: PengajuanViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository(context = context )),
    )
) {



    val groupedBansos by viewModel.groupedBansos.collectAsState()

    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Text(
                text = "Pengajuan",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(14.dp)
            )

        }
        Column (
            modifier = Modifier
//                .verticalScroll(rememberScrollState())
//                .fillMaxSize()
                .padding(8.dp)
                .background(color = colorResource(id = R.color.whiteBlueLight)),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "Pilih Jenis Bansos",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(20.dp)
            )

//            BtnPengajuan(navController = navController, label = "BPNT")
//            BtnPengajuan(navController = navController, label = "PKH")
//            BtnPengajuan(navController = navController, label = "PBI-JK")
//            BtnPengajuanItem(context = context)

            LazyColumn(modifier = Modifier
                .fillMaxSize()
                .padding(start = 5.dp, end = 5.dp)
            ) {
                groupedBansos.forEach { (init, data) ->
                    items(data, key = { it.bansosProviderId }) { data ->
                        BansosItem(
                            id = data.bansosProviderId,
                            name = data.name,
                            navigateToQuestion = navigateToQuestion
                        )
//
                    }

                }
            }
        }
    }

}






@Composable
fun BansosItem(
    id : Int,
    name: String,
    navigateToQuestion: (Int) -> Unit
) {
    // You can customize this part based on your UI requirements
    Column {
        Button(
            onClick = {navigateToQuestion(id)},
            contentPadding = PaddingValues(20.dp, 12.dp, 20.dp, 12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = navy,
                contentColor = whiteBlue
            )
        ) {
            Text(text = name, color =  colorResource(id = R.color.white))
        }

    }



}

//@Composable
//fun BtnPengajuanItem(context: Context) {
//    val viewModel: PengajuanViewModel = viewModel(
//        factory = ViewModelFactory(
//            Injection.provideRepository(context)
//        )
//    )
//
//    val bansosData = viewModel.bansosData.value
//
//    // Fetch data when the screen is first launched
//    LaunchedEffect(viewModel) {
//        viewModel.fetchData()
//    }
//
//    Column {
//        if (bansosData != null) {
//            LazyColumn {
//                items(bansosData.size) { index ->
//                    BansosItem(bansosData[index])
//                }
//            }
//        } else {
//            Text("Loading...")
//        }
//    }
//}



