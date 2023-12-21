package com.bangkit.geniusaidapp.ui.screen.question

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.bangkit.geniusaidapp.R
import com.bangkit.geniusaidapp.data.di.Injection
import com.bangkit.geniusaidapp.data.remote.response.OptionsItem
import com.bangkit.geniusaidapp.data.remote.response.ResultItem
import com.bangkit.geniusaidapp.model.ProfileBansosList
import com.bangkit.geniusaidapp.ui.screen.ViewModelFactory
import com.bangkit.geniusaidapp.ui.theme.black1
import com.bangkit.geniusaidapp.ui.theme.navy


@Composable
fun Question(
    Id: Int,
    context: Context,
    navController: NavHostController
) {

    val viewModel: QuestionViewModel = viewModel(
        factory = ViewModelFactory(
            Injection.provideRepository(context)
        )
    )

    var bansosState by remember { mutableStateOf<List<ProfileBansosList>>(emptyList()) }

    LaunchedEffect(Id) {
        // Menggunakan viewModel untuk mendapatkan data produk berdasarkan ID
        bansosState = viewModel.getBansosById(Id)
    }

    bansosState.forEach { selectedBansos ->
        ContentQuestion(
            context = context,
            navController = navController,
            id = selectedBansos.bansosProviderId,
            nama = selectedBansos.name,
        )
    }

}

@Composable
fun ContentQuestion (
    id : Int,
    nama : String,
    navController: NavHostController,
    context: Context
) {

    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            IconButton(onClick = { navController.navigate("pengajuan")} ) {
                Icon(
                    imageVector = Icons.Outlined.KeyboardArrowLeft,
                    contentDescription = null,
                    Modifier
                        .size(40.dp)
                        .padding(top = 14.dp)
                )

            }
            Text(
                text = "Question",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(top = 14.dp)
            )

        }

        Column (
            modifier = Modifier
                .background(color = colorResource(id = R.color.whiteBlueLight))
                .padding(5.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = nama,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
            )
            Text(
                text = "Isilah data dibawah ini secara jujur dan benar",
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                modifier = Modifier.padding(bottom = 5.dp)
            )
            QuostionScreen(context = context)
//            BtnSubmitTaks(navController = navController)
        }

    }

}


@Composable
fun QuostionScreen(context: Context) {

    val viewModel: QuestionViewModel = viewModel(
        factory = ViewModelFactory(
            Injection.provideRepository(context)
        )
    )

    // Replace with your actual API call trigger
    LaunchedEffect(true) {
        viewModel.getQuestions()
    }

    // Replace "YourComposable" with the actual composable you want to display
    QuestionLazy(
        results = viewModel.questionResponse.value?.result ?: emptyList(),
        onSaveButtonClick = {
            // Handle save button click
            // You may want to save the answers or perform other actions
        }
    )
}


@Composable
fun QuestionLazy(
    results: List<ResultItem?>,
    onSaveButtonClick: () -> Unit // Fungsi untuk menangani klik tombol simpan
) {
    LazyColumn {
        items(results) { resultItem ->
            resultItem?.let {
                QuestionItem(it)
            }
        }

        item {
            Spacer(modifier = Modifier.height(16.dp))
            // Tambahkan tombol untuk menyimpan keseluruhan data
            Button(
                onClick = onSaveButtonClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("Simpan Keseluruhan Data")
            }
        }
    }
}

@Composable
fun QuestionItem(
    resultItem: ResultItem,
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


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = resultItem.question ?: "",
                style = MaterialTheme.typography.titleMedium,
                color = navy
            )


            Spacer(modifier = Modifier.height(20.dp))

            when (resultItem.type) {
                "choice" -> {
                    Options(resultItem.options ?: emptyList())
                }
                "continuous" -> {
                    ContinuousOptions()
                }
                "image" -> {
                    ImageQuestion()
                }
                // Add more cases if needed for other types
            }


        }
    }
}



@Composable
fun Options(options: List<OptionsItem?>) {
    var selectedOption by remember { mutableStateOf<OptionsItem?>(null) }

    Column {
        options.forEach { option ->
            option?.let {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable {
                            selectedOption = option
                        }
                ) {
                    RadioButton(
                        selected = option == selectedOption,
                        onClick = {
                            selectedOption = option
                        }
                    )
                    Text(text = option.alias ?: "", color = black1)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContinuousOptions() {
    var inputValue by remember { mutableStateOf("") }

    OutlinedTextField(
        value = inputValue,
        onValueChange = {
            // Handle the input value (you may want to add validation)
            inputValue = it
        },
        label = { Text("Enter a value") },
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    )

    // You can use the entered value for further processing or validation
    val parsedValue = inputValue.toIntOrNull()
    if (parsedValue != null) {
        Text("Jumlah Raangan rumah: $parsedValue")
    } else {
        // Handle invalid input
        Text("Input tidak valid", color = Color.Red)
    }
}

@Composable
fun ImageQuestion() {
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
                .padding(8.dp)
        ){
            Image(
                bitmap = bitmap.value.asImageBitmap(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(150.dp)
                    .background(Color.Gray)
                    .border(
                        width = 1.dp,
                        color = Color.White,
                    )
                    .clickable { launcherr.launch() }
            )

        }

        Box (
            modifier = Modifier.align(Alignment.BottomEnd)
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