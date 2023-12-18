package com.bangkit.geniusaidapp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bangkit.geniusaidapp.R
import com.bangkit.geniusaidapp.ui.screen.hasilstatusbansos.HasilStatusBansosViewModel

@Composable
fun ItemDataProfinsiDkk(
    viewModel: HasilStatusBansosViewModel
) {
    Row(
        Modifier
            .background(color = colorResource(id = R.color.whiteBlue))
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        viewModel.getUserAlamat()
        viewModel.userAlamat.value.let {

            Column {
                Text(
                    text = "Provinsi",
                    color = colorResource(id = R.color.fontblue),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 17.sp,
                    modifier = Modifier.padding(4.dp)
                )

                if (it != null) {
                    Text(
                        text = it.result?.prov ?: "",
                        color = colorResource(id = R.color.black),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(4.dp)
                    )
                }
                Spacer(modifier = Modifier.padding(8.dp))

                Text(
                    text = "Kecamatan",
                    color = colorResource(id = R.color.fontblue),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 17.sp,
                    modifier = Modifier.padding(4.dp)
                )
                if (it != null) {
                    Text(
                        text = it.result?.kec ?: "",
                        color = colorResource(id = R.color.black),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(4.dp)
                    )
                }

            }
            Column(modifier = Modifier.padding(start = 60.dp)) {
                Text(
                    text = "Kabupaten",
                    color = colorResource(id = R.color.fontblue),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 17.sp,
                    modifier = Modifier.padding(4.dp)
                )

                if (it != null) {
                    Text(
                        text = it.result?.kab ?: "",
                        color = colorResource(id = R.color.black),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(4.dp)
                    )
                }

                Spacer(modifier = Modifier.padding(8.dp))
                Text(
                    text = "Kelurahan",
                    color = colorResource(id = R.color.fontblue),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 17.sp,
                    modifier = Modifier.padding(4.dp)
                )

                if (it != null) {
                    Text(
                        text = it.result?.desa ?: "",
                        color = colorResource(id = R.color.black),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(4.dp)
                    )
                }

            }

        }


    }

}


@Composable
fun CardStatusUmur(
    viewModel: HasilStatusBansosViewModel
) {


    Card(
        elevation = CardDefaults.cardElevation(5.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.whiteBlue),
        ),
        modifier = Modifier
            .padding(10.dp)
            .wrapContentSize()
    ){

        Column {

            viewModel.getStatusName()
            viewModel.userStatusName.value.let {
                Row (
                    Modifier
                        .background(color = colorResource(id = R.color.whiteBlue))
                        .fillMaxWidth()
                        .padding(8.dp)
                ){
                    Column (modifier = Modifier.padding(4.dp)){
                        Text(
                            text = "Nama",
                            color = colorResource(id = R.color.fontblue),
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 17.sp,
                            modifier = Modifier.padding(4.dp)
                        )

                        if (it != null) {
                            Text(
                                text = it.result?.name?: "",
                                color = colorResource(id = R.color.black),
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 14.sp,
                                modifier = Modifier.padding(4.dp)
                            )
                        }
                    }

                    Column (modifier = Modifier.padding(4.dp)){
                        Text(
                            text = "Umur",
                            color = colorResource(id = R.color.fontblue),
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 17.sp,
                            modifier = Modifier.padding(45.dp, 4.dp, 4.dp, 4.dp)
                        )

                        if (it != null) {
                            Text(
                                text = it.result?.age.toString(),
                                color = colorResource(id = R.color.black),
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 14.sp,
                                modifier = Modifier.padding(45.dp, 4.dp, 4.dp, 4.dp)
                            )
                        }
                    }

                }

            }
            CardStatusBansos(viewModel = viewModel)

        }


    }



}

@Composable
fun CardStatusBansos(
    viewModel: HasilStatusBansosViewModel
) {
    val statusListBansos = viewModel.statusListBansos.value

    LaunchedEffect(viewModel) {
        viewModel.fetchStatusList()
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(4.dp)
    ) {
        items(statusListBansos) { statusListItem ->
            statusListItem?.let { item ->
                // Display each StatusListItem in the grid

                // Tambahkan padding di sekitar elemen-elemen UI untuk meningkatkan estetika
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = item.bansosName ?: "",
                        color = colorResource(id = R.color.fontblue),
                        fontWeight = FontWeight.Medium,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(4.dp)
                    )

                    // ...

                    // Gunakan Column untuk menyusun elemen-elemen UI secara vertikal
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(4.dp)
                    ) {
                        Text(
                            text = "Status : ${item.status}",
                            color = colorResource(id = R.color.black),
                            fontWeight = FontWeight.Normal,
                            fontSize = 11.sp
                        )

                        Text(
                            text = "Periode : ${item.periode}",
                            color = colorResource(id = R.color.black),
                            fontWeight = FontWeight.Normal,
                            fontSize = 11.sp
                        )
                    }
                }
            }
        }
    }
}


