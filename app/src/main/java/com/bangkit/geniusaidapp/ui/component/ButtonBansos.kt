package com.bangkit.geniusaidapp.ui.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.bangkit.geniusaidapp.R

@Composable
fun BtnBpnt(navController: NavHostController) {
    Button(
        onClick = {navController.navigate("pengajuan/{Id}")
        },
        contentPadding = PaddingValues(20.dp, 12.dp, 20.dp, 12.dp),
        modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
    ) {
        Text(text = "BPNT")

    }

}@Composable
fun BtnPkh(navController: NavHostController) {
    Button(
        onClick = {navController.navigate("pengajuan/{Id}")
        },
        contentPadding = PaddingValues(20.dp, 12.dp, 20.dp, 12.dp),
        modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
    ) {
        Text(text = "PKH")

    }

}
@Composable
fun BtnPbiJk(navController: NavHostController) {
    Button(
        onClick = {navController.navigate("pengajuan/{Id}")
        },
        contentPadding = PaddingValues(20.dp, 12.dp, 20.dp, 12.dp),
        modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
    ) {
        Text(text = "PBI-JK")

    }

}
