package com.bangkit.geniusaidapp.ui.screen.home

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.bangkit.geniusaidapp.R
import com.bangkit.geniusaidapp.data.di.Injection
import com.bangkit.geniusaidapp.ui.component.BtnCekBansos
import com.bangkit.geniusaidapp.ui.component.ItemProfileBansos
import com.bangkit.geniusaidapp.ui.screen.ViewModelFactory



@Composable
fun ContentHome(
    context: Context,
    navigateToDetailBansos: (String) -> Unit,
    navController: NavHostController,
    viewModel: HomeViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository(context = context )),
    )

) {
    val groupedBansos by viewModel.groupedBansos.collectAsState()

    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
                .background(color = colorResource(id = R.color.whiteBlueLight)),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            viewModel.getUserProfile()
            viewModel.userProfile.value.let {

                if (it != null) {
                    Text(
                        text ="Welcome " + it.result?.name ?: "",
                        fontWeight = FontWeight.Bold,
                        fontSize = 25.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        textAlign = TextAlign.Center,
                        color = colorResource(id = R.color.black)
                    )
                }
            }

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
                text = "Berikut adalah Jenis-jenis Bantuan Sosial yang dapat di dapatkan",
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                textAlign = TextAlign.Start,
                color = colorResource(id = R.color.black)
            )


            LazyColumn(modifier = Modifier
                .fillMaxSize()
                .padding(start = 5.dp, end = 5.dp)
            ) {
                groupedBansos.forEach { (init, data) ->

                    items(data, key = { it.name }) { data ->
                        ItemProfileBansos(
                            name = data.name,
                            photo = data.logoUrl,
                            navigateToDetail = navigateToDetailBansos
                        )
                    }

                }
            }


        }
        Box (modifier = Modifier
            .align(Alignment.BottomEnd)
            .padding(8.dp, 8.dp, 20.dp, 8.dp)){

            BtnCekBansos(navController)
        }
    }

}


