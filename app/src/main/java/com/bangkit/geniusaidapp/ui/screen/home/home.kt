package com.bangkit.geniusaidapp.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
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
import com.bangkit.geniusaidapp.model.ProfileBansos
import com.bangkit.geniusaidapp.ui.component.BtnCekBansos
import com.bangkit.geniusaidapp.ui.component.MainListProfileBansos
import com.bangkit.geniusaidapp.ui.screen.ViewModelFactory
import com.bangkit.geniusaidapp.ui.screen.Result


@Composable
fun Home(
    viewModel: HomeViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository()),
    ),
    navController: NavHostController,
    navigateToDetailProfileBansos: (Long) -> Unit,
) {
    viewModel.result.collectAsState(initial = Result.Loading).value.let { uiState ->
        when (uiState) {
            is Result.Loading -> {
                viewModel.getAllProfilBansos()
            }

            is Result.Success -> {
                ContentHome(
                    uiState.data,
                    navigateToDetailBansos = navigateToDetailProfileBansos,
                    navController = navController,
                    viewModel
                )
            }

            is Result.Error -> {}
        }
    }
}


@Composable
fun ContentHome(
    listProfilBansos: List<ProfileBansos>,
    navigateToDetailBansos: (Long) -> Unit,
    navController: NavHostController,
    viewModel: HomeViewModel
) {
    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
                .background(color = colorResource(id = R.color.whiteBlueLight)),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Hallo, Ahkam Putra",
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                textAlign = TextAlign.Center,
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
                text = "Berikut adalah Jenis-jenis Bantuan Sosial yang dapat di dapatkan",
                fontWeight = FontWeight.Normal,
                fontSize = 12.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                textAlign = TextAlign.Start,
                color = colorResource(id = R.color.black)
            )


            BtnCekBansos(navController)




            MainListProfileBansos(
                listProfilBansos = listProfilBansos,
                navigateToDetailBansos = navigateToDetailBansos
            )

        }

    }

}


