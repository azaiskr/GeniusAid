package com.bangkit.geniusaidapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.bangkit.geniusaidapp.R
import com.bangkit.geniusaidapp.ui.theme.GeniusAidAppTheme

@Composable
fun TopBar(modifier: Modifier, navController: NavHostController) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = colorResource(id = R.color.white)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Item ",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .size(70.dp)
                .padding(10.dp, 10.dp, 10.dp, 10.dp),
        )

        Text(
            text = "Genius aid",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )



    }
    Row (
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ){
        IconButton(onClick = { navController.navigate("loginuser")} ) {
            Icon(
                imageVector = Icons.Outlined.ExitToApp,
                contentDescription = null,
                modifier
                    .size(40.dp)
                    .padding(top = 14.dp)
            )
            
        }

    }

}

