package com.bangkit.geniusaidapp.ui.component

import android.content.Context
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
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.core.content.FileProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.bangkit.geniusaidapp.data.di.Injection
import com.bangkit.geniusaidapp.ui.screen.ViewModelFactory
import com.bangkit.geniusaidapp.ui.screen.profile.ProfileViewModel
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Objects



@Composable
fun ImageAdd(
    context : Context,
    viewModel: ProfileViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository(context = context )),
    )
) {
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
            viewModel.getUserProfile()
            viewModel.userProfile.value.let {
                if (it != null) {
                    val profilePicUrl = viewModel.userProfile.value?.result?.profilePicUrl?.toString()
                    AsyncImage(
                        model = profilePicUrl,
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


                }else{
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
            }



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
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel : ProfileViewModel
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
            viewModel.getUserProfile()
            viewModel.userProfile.value.let {
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
                if (it != null) {
                    Text(
                        text = it.result?.kewarganegaraan?: "",
                        color = colorResource(id = R.color.black),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp,
                        modifier = modifier.padding(bottom = 8.dp)
                    )
                }
                Text(
                    text = "Nama lengkap",
                    color = colorResource(id = R.color.fontblue),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 17.sp,
                    modifier = modifier.padding(bottom = 8.dp)
                )

                if (it != null) {
                    Text(
                        text = it.result?.name ?: "",
                        color = colorResource(id = R.color.black),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp,
                        modifier = modifier.padding(bottom = 8.dp)
                    )
                }

                Text(
                    text = "Tanggal Lahir",
                    color = colorResource(id = R.color.fontblue),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 17.sp,
                    modifier = modifier.padding(bottom = 8.dp)
                )
                if (it != null) {
                    Text(
                        text = it.result?.birthDate?: "",
                        color = colorResource(id = R.color.black),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp,
                        modifier = modifier.padding(bottom = 8.dp)
                    )
                }
                Text(
                    text = "NIK",
                    color = colorResource(id = R.color.fontblue),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 17.sp,
                    modifier = modifier.padding(bottom = 8.dp)
                )
                if (it != null) {
                    Text(
                        text = it.result?.nik?: "",
                        color = colorResource(id = R.color.black),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp,
                        modifier = modifier.padding(bottom = 8.dp)
                    )
                }

            }



        }
    }
}

@Composable
fun Email(
    modifier: Modifier = Modifier,  navController: NavHostController, viewModel : ProfileViewModel
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
            viewModel.getUserProfile()
            viewModel.userProfile.value.let {

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

                    IconButton(onClick = { } ) {
                        Icon(
                            imageVector = Icons.Outlined.Edit,
                            contentDescription = null,
                            modifier.size(20.dp),
                            colorResource(id = R.color.black)

                        )

                    }

                }
                if (it != null) {
                    Text(
                        text = it.result?.email?: "",
                        color = colorResource(id = R.color.black),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp,
                        modifier = modifier.padding(bottom = 8.dp)
                    )
                }

            }


        }
    }
}

@Composable
fun NoTlp(
    modifier: Modifier = Modifier,  navController: NavHostController, viewModel : ProfileViewModel
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

                IconButton(onClick = { } ) {
                    Icon(
                        imageVector = Icons.Outlined.Edit,
                        contentDescription = null,
                        modifier.size(20.dp),
                        colorResource(id = R.color.black)

                    )

                }

            }

            viewModel.getUserProfile()
            viewModel.userProfile.value.let {
                if (it != null) {
                    Text(
                        text = it.result?.phoneNumber?: "",
                        color = colorResource(id = R.color.black),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp,
                        modifier = modifier.padding(bottom = 8.dp)
                    )
                }
            }


        }
    }
}

