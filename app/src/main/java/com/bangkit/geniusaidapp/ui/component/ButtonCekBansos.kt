package com.bangkit.geniusaidapp.ui.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bangkit.geniusaidapp.R
import com.bangkit.geniusaidapp.ui.theme.GeniusAidAppTheme

@Composable
fun BtnCekBansos(modifier : Modifier) {
    Button(
        onClick = { /*TODO*/ },
        contentPadding = PaddingValues(20.dp, 12.dp, 20.dp, 12.dp),
    ) {
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = null,
            modifier.size(ButtonDefaults.IconSize))
        Spacer(modifier = modifier.size(ButtonDefaults.IconSpacing))
        Text(text = stringResource(id = R.string.cekbansos))

    }

}

@Preview
@Composable
fun BtnCariBansosPrev() {
    GeniusAidAppTheme {
        BtnCekBansos(modifier = Modifier)
    }

}