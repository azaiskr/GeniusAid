package com.bangkit.geniusaidapp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.bangkit.geniusaidapp.R
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.painterResource

@Composable
fun ImageAdd() {
    Box {

        val img: Bitmap = BitmapFactory.decodeResource(Resources.getSystem(), android.R.drawable.ic_menu_report_image)
        val bitmap = remember {
            mutableStateOf(img)
        }
        val launcherr = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.TakePicturePreview())
        {
            if (it != null) {
                bitmap.value = it
            }
        }
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ){
            Image(
                bitmap = bitmap.value.asImageBitmap(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(CircleShape)
                    .size(150.dp)
                    .background(Color.Gray)
                    .border(
                        width = 1.dp,
                        color = Color.White,
                        shape = CircleShape
                    )
            )

        }

        Box (
            modifier = Modifier
                .padding(top = 100.dp, start = 200.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.baseline_photo_camera_24),
                contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.Black)
                    .padding(10.dp)
                    .size(20.dp)
                    .clickable { launcherr.launch() }
            )

        }
    }
}


@Composable
fun Info(
    modifier: Modifier = Modifier,  navController: NavHostController
) {
    Card(
        elevation = CardDefaults.cardElevation(5.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.whiteBlue),
        ),
        modifier = modifier
            .wrapContentSize()
            .padding(top = 12.dp)
    ) {
        Column(
            modifier = modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Info",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = colorResource(id = R.color.navy),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = modifier.padding(bottom = 16.dp)

            )

            Text(
                text = "Kewarganegaraan",
                color = colorResource(id = R.color.fontblue),
                fontWeight = FontWeight.SemiBold,
                fontSize = 17.sp,
                modifier = modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Warga negara indonesia",
                color = colorResource(id = R.color.black),
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                modifier = modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Nama lengkap",
                color = colorResource(id = R.color.fontblue),
                fontWeight = FontWeight.SemiBold,
                fontSize = 17.sp,
                modifier = modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Ahkam Putra",
                color = colorResource(id = R.color.black),
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                modifier = modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Tanggal Lahir",
                color = colorResource(id = R.color.fontblue),
                fontWeight = FontWeight.SemiBold,
                fontSize = 17.sp,
                modifier = modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "03/02/1992",
                color = colorResource(id = R.color.black),
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                modifier = modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "NIK",
                color = colorResource(id = R.color.fontblue),
                fontWeight = FontWeight.SemiBold,
                fontSize = 17.sp,
                modifier = modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "7472787655360031",
                color = colorResource(id = R.color.black),
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                modifier = modifier.padding(bottom = 8.dp)
            )

        }
    }
}

@Composable
fun Email(
    modifier: Modifier = Modifier,  navController: NavHostController
) {
    Card(
        elevation = CardDefaults.cardElevation(5.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.whiteBlue),
        ),
        modifier = modifier
            .wrapContentSize()
            .padding(top = 12.dp)
    ) {
        Column(
            modifier = modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Row (
                modifier = modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = "Email",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = colorResource(id = R.color.navy),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                IconButton(onClick = { navController.navigate("cekbansos")} ) {
                    Icon(
                        imageVector = Icons.Outlined.Edit,
                        contentDescription = null,
                        modifier.size(20.dp),
                        colorResource(id = R.color.black)

                    )

                }

            }
            Text(
                text = "ahkanputra@gmail,com",
                color = colorResource(id = R.color.black),
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                modifier = modifier.padding(bottom = 8.dp)
            )

        }
    }
}

@Composable
fun NoTlp(
    modifier: Modifier = Modifier,  navController: NavHostController
) {
    Card(
        elevation = CardDefaults.cardElevation(5.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.whiteBlue),
        ),
        modifier = modifier
            .wrapContentSize()
            .padding(top = 12.dp)
    ) {
        Column(
            modifier = modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Row (
                modifier = modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = "Nomor Telepon",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = colorResource(id = R.color.navy),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                IconButton(onClick = { navController.navigate("cekbansos")} ) {
                    Icon(
                        imageVector = Icons.Outlined.Edit,
                        contentDescription = null,
                        modifier.size(20.dp),
                        colorResource(id = R.color.black)

                    )

                }

            }
            Text(
                text = "+628235673787",
                color = colorResource(id = R.color.black),
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                modifier = modifier.padding(bottom = 8.dp)
            )

        }
    }
}

