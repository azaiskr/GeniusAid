package com.bangkit.geniusaidapp.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bangkit.geniusaidapp.R
import com.bangkit.geniusaidapp.model.ListBansosProcess
import com.bangkit.geniusaidapp.model.dammyListBansosProcess
import com.bangkit.geniusaidapp.ui.theme.GeniusAidAppTheme
import com.bangkit.geniusaidapp.ui.theme.navyLight


@Composable
fun ComponentListBansosProcess(
    modifier: Modifier,
    listBansosProcess: ListBansosProcess
) {
    Column(
        modifier = modifier.padding(4.dp)
            .background(
                color = colorResource(id = R.color.whiteBlue),
                shape = RoundedCornerShape(5.dp)
            )
    ){
        Image(
            painter = painterResource(id = listBansosProcess.image),
            contentDescription = null,
            modifier
                .size(120.dp)
                .padding(16.dp)

        )
        Text(
            text = listBansosProcess.title,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            textAlign = TextAlign.End,
            modifier = modifier
                .padding(start = 4.dp, bottom = 8.dp, end = 16.dp),
            color = colorResource(id = R.color.fontblue)
        )
        Text(
            text = listBansosProcess.status,
            fontWeight = FontWeight.Normal,
            fontSize = 17.sp,
            textAlign = TextAlign.Start,
            modifier = modifier
                .padding(start = 4.dp, bottom = 8.dp, end = 16.dp),
            color = colorResource(id = R.color.fontblue)
        )
        Text(
            text = listBansosProcess.statusNilai,
            fontWeight = FontWeight.Light,
            fontSize = 15.sp,
            textAlign = TextAlign.Start,
            modifier = modifier
                .padding(start = 4.dp, bottom = 8.dp, end = 16.dp),
            color = colorResource(id = R.color.black)
        )
        Text(
            text = listBansosProcess.keterangan,
            fontWeight = FontWeight.Normal,
            fontSize = 15.sp,
            textAlign = TextAlign.Start,
            modifier = modifier
                .padding(start = 4.dp, bottom = 8.dp, end = 16.dp),
            color = colorResource(id = R.color.fontblue)
        )
        Text(
            text = listBansosProcess.keteranganNilai,
            fontWeight = FontWeight.Light,
            fontSize = 15.sp,
            textAlign = TextAlign.Start,
            modifier = modifier
                .padding(start = 4.dp, bottom = 8.dp, end = 16.dp),
            color = colorResource(id = R.color.black)
        )
        Text(
            text = listBansosProcess.priode,
            fontWeight = FontWeight.Normal,
            fontSize = 15.sp,
            textAlign = TextAlign.Start,
            modifier = modifier
                .padding(start = 4.dp, bottom = 8.dp, end = 16.dp),
            color = colorResource(id = R.color.fontblue)
        )
        Text(
            text = listBansosProcess.priodeNilai,
            fontWeight = FontWeight.Light,
            fontSize = 15.sp,
            textAlign = TextAlign.Start,
            modifier = modifier
                .padding(start = 4.dp, bottom = 8.dp, end = 16.dp),
            color = colorResource(id = R.color.black)
        )

    }





}

@Preview
@Composable
fun prec() {
    GeniusAidAppTheme {
        ComponentListBansosProcess(
            modifier = Modifier,
            listBansosProcess = ListBansosProcess(
                R.drawable.pbi_jk,
                "PBI-JK",
                "Status",
                "-",
                "Keterangan",
                "-",
                "Priode",
                "-")
        )
    }
}

@Composable
fun MainListBansosProcess() {
    LazyRow(modifier = Modifier.padding(4.dp)){
        items(dammyListBansosProcess.listBansosProcess){
            ComponentListBansosProcess(modifier = Modifier, listBansosProcess = it)

        }
    }
    
}