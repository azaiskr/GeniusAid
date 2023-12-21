//package com.bangkit.geniusaidapp.ui.screen.home
//
//import android.R
//import android.content.Context
//import android.content.res.Resources
//import android.graphics.Bitmap
//import android.graphics.BitmapFactory
//import androidx.activity.compose.rememberLauncherForActivityResult
//import androidx.activity.result.contract.ActivityResultContracts
//import androidx.activity.result.launch
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.border
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.size
//import androidx.compose.foundation.layout.wrapContentSize
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.foundation.shape.CircleShape
//import androidx.compose.material3.Button
//import androidx.compose.material3.CircularProgressIndicator
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.draw.clip
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.asImageBitmap
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.unit.dp
//import androidx.lifecycle.viewmodel.compose.viewModel
//import androidx.navigation.NavHostController
//import coil.compose.AsyncImage
//import com.bangkit.geniusaidapp.data.di.Injection
//import com.bangkit.geniusaidapp.ui.component.ImageAdd
//import com.bangkit.geniusaidapp.ui.component.imageCaptureFromCamera
//import com.bangkit.geniusaidapp.ui.screen.ViewModelFactory
//
//
//@Composable
//fun CobaScreen(
//    context : Context,
////    viewModel: CobaViewModel = viewModel(
////        factory = ViewModelFactory(Injection.provideRepository(context = context )),
////    )
//    navController: NavHostController
//
//) {
//
//    val viewModel: CobaViewModel = viewModel(
//        factory = ViewModelFactory(
//            Injection.provideRepository(context)
//        )
//    )
//
//
////        QuestionerScreen(context = context)
////        BansosScreen(context = context, navController = navController)
////        SubmissionScreen(viewModel = viewModel, context = context)
////    imageCaptureFromCamera()
////    ImageAddCoba(viewModel = viewModel, context = context)
//
//
//}
//
//
//@Composable
//fun ImageAddCoba(
//    context : Context,
//    viewModel: CobaViewModel = viewModel(
//        factory = ViewModelFactory(Injection.provideRepository(context = context )),
//    )
//) {
//    Box {
//
//        val img: Bitmap = BitmapFactory.decodeResource(Resources.getSystem(), R.drawable.ic_menu_report_image)
//        val bitmap = remember {
//            mutableStateOf(img)
//        }
//        val launcherr = rememberLauncherForActivityResult(
//            contract = ActivityResultContracts.TakePicturePreview())
//        {
//            if (it != null) {
//                bitmap.value = it
//            }
//        }
//
//
//
//        Column (
//            horizontalAlignment = Alignment.CenterHorizontally,
//            modifier = Modifier
//                .fillMaxSize()
//        ){
//            viewModel.getUserProfile()
//            viewModel.userProfile.value.let {
//                if (it != null) {
//                    val profilePicUrl = viewModel.userProfile.value?.result?.profilePicUrl?.toString()
//                    AsyncImage(
//                        model = profilePicUrl,
//                        contentDescription = null,
//                        contentScale = ContentScale.Crop,
//                        modifier = Modifier
//                            .clip(CircleShape)
//                            .size(150.dp)
//                            .background(Color.Gray)
//                            .border(
//                                width = 1.dp,
//                                color = Color.White,
//                                shape = CircleShape
//                            )
//                    )
//
//
//                }else{
//                    Image(
//                        bitmap = bitmap.value.asImageBitmap(),
//                        contentDescription = null,
//                        contentScale = ContentScale.Crop,
//                        modifier = Modifier
//                            .clip(CircleShape)
//                            .size(150.dp)
//                            .background(Color.Gray)
//                            .border(
//                                width = 1.dp,
//                                color = Color.White,
//                                shape = CircleShape
//                            )
//                    )
//                }
//            }
//
//
//
//        }
//
//        Box (
//            modifier = Modifier
//                .padding(top = 100.dp, start = 200.dp)
//        ){
//            Image(
//                painter = painterResource(id = com.bangkit.geniusaidapp.R.drawable.baseline_photo_camera_24),
//                contentDescription = null,
//                modifier = Modifier
//                    .clip(CircleShape)
//                    .background(Color.Black)
//                    .padding(10.dp)
//                    .size(20.dp)
//                    .clickable { launcherr.launch() }
//            )
//
//        }
//    }
//}
//
//
//
//@Composable
//fun BansosScreen(
//    context : Context,
//    navController: NavHostController
//) {
//
//    val viewModel: CobaViewModel = viewModel(
//        factory = ViewModelFactory(
//            Injection.provideRepository(context)
//        )
//    )
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//    ) {
//        Button(
//            onClick = {
//                viewModel.getBansos()
//            },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(bottom = 16.dp)
//        ) {
//            Text(text = "Get Bansos Data")
//        }
//
//        if (viewModel.isLoading) {
//            CircularProgressIndicator(
//                modifier = Modifier
//                    .size(24.dp)
//                    .padding(8.dp)
//                    .wrapContentSize(align = Alignment.Center)
//            )
//        } else {
//            // Show result here
//            val bansosResponse = viewModel.bansosResponse
//            if (bansosResponse != null) {
//                LazyColumn {
//                    items(bansosResponse.result.orEmpty()) { resultItem ->
//                        // Display each item here
//                        Text("Bansos Name: ${resultItem?.name}")
//                        Text("Description: ${resultItem?.description}")
//                        Spacer(modifier = Modifier.height(16.dp))
//
//                        // Button to move to Question
//                        Button(
//                            onClick = {
//                                // Assuming there is a bansosId property in ResultBansosItem
//                                resultItem?.bansosProviderId?.let { bansosId ->
//                                    // Navigate to the submission screen with the selected bansosId
//                                    navController.navigate("submission/$bansosId")
//                                }
//                            },
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(bottom = 16.dp)
//                        ) {
//                            Text(text = "Move to Question")
//                        }
//                    }
//                }
//            } else {
//                // Display an error message or handle the case when result is null
//                Text("Error fetching Bansos data")
//            }
//        }
//    }
//}
//
//
//
//@Composable
//fun SubmissionScreen(
//    context: Context,
//    navController: NavHostController,
//    bansosId: Int
//) {
//
//    val viewModel: CobaViewModel = viewModel(
//        factory = ViewModelFactory(
//            Injection.provideRepository(context)
//        )
//    )
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//    ) {
//        Button(
//            onClick = {
//                // Ganti 1 dengan bansosId yang sesuai
//                viewModel.postSubmission(1)
//            },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(bottom = 16.dp)
//        ) {
//            Text(text = "Post Submission")
//        }
//
//        if (viewModel.isLoading) {
//            CircularProgressIndicator(
//                modifier = Modifier
//                    .size(24.dp)
//                    .padding(8.dp)
//                    .wrapContentSize(align = Alignment.Center)
//            )
//        } else {
//            // Show result here
//            val postSubmissionResponse = viewModel.postSubmissionResponse
//            if (postSubmissionResponse != null) {
//                // Display result
//                Text("Submission ID: ${postSubmissionResponse.result?.submissionId}")
//                Text("Status: ${postSubmissionResponse.result?.status}")
//            } else {
//                // Display an error message or handle the case when result is null
//                Text("Error posting submission")
//            }
//        }
//    }
//}
//
//
//@Composable
//fun QuestionerScreen(
//    context : Context,
////    navController: NavHostController
//) {
//
//    val viewModel: CobaViewModel = viewModel(
//        factory = ViewModelFactory(
//            Injection.provideRepository(context)
//        )
//    )
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//    ) {
//        Button(
//            onClick = {
//                viewModel.getQuestioner()
//            },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(bottom = 16.dp)
//        ) {
//            Text(text = "Get Questioner Data")
//        }
//
//        if (viewModel.isLoading) {
//            CircularProgressIndicator(
//                modifier = Modifier
//                    .size(24.dp)
//                    .padding(8.dp)
//                    .wrapContentSize(align = Alignment.Center)
//            )
//        } else {
//            // Show result here
//            val questionResponse = viewModel.questionResponse
//            if (questionResponse != null) {
//                LazyColumn {
//                    items(questionResponse.result.orEmpty()) { resultItem ->
//                        // Display each item here
//                        Text("Question: ${resultItem?.question}")
//                        Text("Type: ${resultItem?.type}")
//                        Spacer(modifier = Modifier.height(16.dp))
//                    }
//                }
//            } else {
//                // Display an error message or handle the case when result is null
//                Text("Error fetching Questioner data")
//            }
//        }
//    }
//}
