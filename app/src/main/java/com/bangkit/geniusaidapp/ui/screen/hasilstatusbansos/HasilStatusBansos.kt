package com.bangkit.geniusaidapp.ui.screen.statusbansos

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.bangkit.geniusaidapp.ui.component.CardStatusUmur
import com.bangkit.geniusaidapp.ui.component.ItemDataProfinsiDkk
import com.bangkit.geniusaidapp.ui.screen.ViewModelFactory
import com.bangkit.geniusaidapp.ui.screen.hasilstatusbansos.HasilStatusBansosViewModel

@Composable
fun ContentHasilStatusBansos(navController : NavHostController, context: Context) {
    val viewModel: HasilStatusBansosViewModel = viewModel(
        factory = ViewModelFactory(
            Injection.provideRepository(context)
        )
    )

    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            IconButton(onClick = { navController.navigate("home")} ) {
                Icon(
                    imageVector = Icons.Outlined.KeyboardArrowLeft,
                    contentDescription = null,
                    Modifier
                        .size(40.dp)
                        .padding(top = 14.dp)
                )

            }
            Text(
                text = "Hasil Cek Bansos",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(top = 14.dp)
            )

        }

        Column {
            ItemDataProfinsiDkk(viewModel)
        }
        Column (
            modifier = Modifier
                .background(color = colorResource(id = R.color.whiteBlueLight))
                .padding(5.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CardStatusUmur(viewModel)
        }
    }

}