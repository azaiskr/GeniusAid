package com.bangkit.geniusaidapp.ui.screen.detailprofilebansos

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.bangkit.geniusaidapp.R
import com.bangkit.geniusaidapp.data.di.Injection
import com.bangkit.geniusaidapp.model.ProfileBansos
import com.bangkit.geniusaidapp.navigation.Screen
import com.bangkit.geniusaidapp.ui.screen.ViewModelFactory
import com.bangkit.geniusaidapp.ui.screen.Result


@Composable
fun DetailProfileBansos(
    Id: Long,
    viewModel: DetailBansosViewModel = viewModel(
        factory = ViewModelFactory(
            Injection.provideRepository()
        )
    ),
    navController: NavHostController
) {
    viewModel.result.collectAsState(initial = Result.Loading).value.let { uiStateCrew ->
        when (uiStateCrew) {
            is Result.Loading -> {
                viewModel.getProfileBansosById(Id)
            }

            is Result.Success -> {
                ContentDetailProfileBansos(profileBansos = uiStateCrew.data, modifier = Modifier, navController = navController)
            }

            is Result.Error -> {}
        }
    }
}

@Composable
fun ContentDetailProfileBansos(
    modifier: Modifier,
    navController: NavHostController,
    profileBansos : ProfileBansos
) {

    Column {
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            IconButton(onClick = { navController.navigate("home")} ) {
                Icon(
                    imageVector = Icons.Outlined.KeyboardArrowLeft,
                    contentDescription = null,
                    modifier
                        .size(40.dp)
                        .padding(top = 14.dp)
                )

            }

            Text(
                text = "Detail Bantuan Sosial",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(top = 14.dp)
            )

        }
        Column(modifier = modifier){
            Column(
                modifier = modifier
                    .padding(32.dp, 0.dp, 32.dp, 16.dp)
                    .verticalScroll(rememberScrollState())
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Surface(
                    modifier = modifier
                        .size(154.dp)
                        .padding(5.dp),
                    shape = CircleShape,
                    border = BorderStroke(0.5.dp, Color.LightGray)
                ) {
                    AsyncImage(
                        model = profileBansos.photoUrl,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = modifier
                            .padding(14.dp)
                            .size(150.dp)
                            .clip(CircleShape)
                    )
                }

//
                Text(
                    text = profileBansos.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    modifier = modifier
                        .padding(bottom = 16.dp)
                )
                Divider()
                Text(
                    text = profileBansos.description,
                    modifier = Modifier.padding(bottom = 16.dp),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Justify
                )

            }

        }

    }


}
