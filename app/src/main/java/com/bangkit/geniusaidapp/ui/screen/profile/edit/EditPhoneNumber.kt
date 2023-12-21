package com.bangkit.geniusaidapp.ui.screen.profile.edit

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.bangkit.geniusaidapp.R
import com.bangkit.geniusaidapp.data.di.Injection
import com.bangkit.geniusaidapp.data.remote.response.PutResult
import com.bangkit.geniusaidapp.navigation.Screen
import com.bangkit.geniusaidapp.ui.screen.Result
import com.bangkit.geniusaidapp.ui.screen.ViewModelFactory



@Composable
fun EditPhoneNumberScreen(
    context: Context,
    viewModel: EditViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository(context = context )),
    ),
    navController: NavHostController
) {
    val userProfileResult by viewModel.updateResult.observeAsState()


    when (val result = userProfileResult) {
        is Result.Loading -> {
            // Show loading indicator
            CircularProgressIndicator()
        }
        is Result.Success -> {
            val userProfile = result.data?.result
            if (userProfile != null) {
                UpdatePhoneNumber(userProfile, viewModel, navController)
            } else {
                Text("User profile data is null")
            }
        }
        is Result.Error -> {
            // Display error message
            Text("Error: ${result.message}")
        }

        else -> {
            Text(text = "No data")}
    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdatePhoneNumber(
    userProfile: PutResult,
    viewModel: EditViewModel,
    navController: NavHostController
) {
    var newPhoneNumber by remember { mutableStateOf(userProfile.phoneNumber.orEmpty()) }



    Column {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            IconButton(onClick = { navController.navigate(Screen.Profile.route)} ) {
                Icon(
                    imageVector = Icons.Outlined.KeyboardArrowLeft,
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .padding(top = 14.dp)
                )

            }

            Text(
                text = "Edit Nomor Telepon",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(top = 14.dp)
            )

        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {



            Spacer(modifier = Modifier.padding(top = 4.dp))
            Text(
                text = "Nomor Telepon",
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                color = colorResource(id = R.color.navy),
            )
            OutlinedTextField(
                value = newPhoneNumber,
                onValueChange = {newPhoneNumber = it},
                placeholder = {
                    Text(text = "Masukkan Nomor Telepon")
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done
                ),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_phone_24),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )

                }

            )

            // Button to update user profile
            Button(
                onClick = {
                    // Call the ViewModel function to update user profile
                viewModel.updatePhoneNumber(newPhoneNumber)
                    navController.navigate(Screen.Profile.route)
                },
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth()
            ) {
                Text("Update")
            }
        }
    }
}