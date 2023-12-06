package com.bangkit.geniusaidapp.ui.component

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
import coil.compose.AsyncImage
import com.bangkit.geniusaidapp.R



@Composable
fun ImageProfile() {
    Surface(
        modifier = Modifier
            .size(154.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray)
    ) {
        AsyncImage(
            model = "https://scontent.fupg6-1.fna.fbcdn.net/v/t39.30808-6/294175906_1661555460870347_816313342043149933_n.jpg?_nc_cat=104&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeE8FrUsc9B4eYhoXC-okj1GOTbC20WGfrY5NsLbRYZ-tlfOfqzEcE0btQC-_GlVsruq7HnSXA6PGpwdx19YSL9b&_nc_ohc=yjNfiCx8LmkAX-shWoE&_nc_ht=scontent.fupg6-1.fna&oh=00_AfB98HnJ1H1dGeHpgVA5uuxYGsQ3DMH6qYuMAD_cieXVTg&oe=6559DC71",
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(100.dp)
                .clip(CircleShape)
        )
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

