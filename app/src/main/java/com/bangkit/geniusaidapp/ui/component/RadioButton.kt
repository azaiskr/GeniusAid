package com.bangkit.geniusaidapp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bangkit.geniusaidapp.R
import com.bangkit.geniusaidapp.ui.theme.GeniusAidAppTheme


@Composable
fun Ask1() {
    var selectedOption by remember { mutableStateOf("Option 1") }

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
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Status bantuan dengan beras",
                color = colorResource(id = R.color.fontblue),
                fontWeight = FontWeight.SemiBold,
                fontSize = 17.sp,
            )
            RadioGroup(
                options = listOf("Tidak menerima", "Menerima"),
                selectedOption = selectedOption,
                onOptionSelected = { option ->
                    selectedOption = option
                }
            )
        }

    }

}

@Composable
fun Ask2() {
    var selectedOption by remember { mutableStateOf("Option 1") }

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
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Pendidikan tertinggi kepala keluarga",
                color = colorResource(id = R.color.fontblue),
                fontWeight = FontWeight.SemiBold,
                fontSize = 17.sp,
            )
            RadioGroup(
                options = listOf(
                    "Tidak sekolah",
                    "Setara SD",
                    "Setara SMP",
                    "Setara SMA",
                    "Diploma",
                    "S-1",
                    "S-2",
                    "S-3",
                ),
                selectedOption = selectedOption,
                onOptionSelected = { option ->
                    selectedOption = option
                }
            )
        }

    }


}
@Composable
fun Ask3() {
    var selectedOption by remember { mutableStateOf("Option 1") }

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
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Kepemilikan rumah",
                color = colorResource(id = R.color.fontblue),
                fontWeight = FontWeight.SemiBold,
                fontSize = 17.sp,
            )
            RadioGroup(
                options = listOf(
                    "Milik sendiri",
                    "Menempati",
                    "Kontrak",
                    "Lainnya",
                    "Diploma"
                ),
                selectedOption = selectedOption,
                onOptionSelected = { option ->
                    selectedOption = option
                }
            )
        }
    }

}
@Composable
fun Ask4() {
    var selectedOption by remember { mutableStateOf("Option 1") }

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
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Penggunaan listrik",
                color = colorResource(id = R.color.fontblue),
                fontWeight = FontWeight.SemiBold,
                fontSize = 17.sp,
            )
            RadioGroup(
                options = listOf(
                    "Tidak menggunakan listrik",
                    "Menggunakan Listrik"
                ),
                selectedOption = selectedOption,
                onOptionSelected = { option ->
                    selectedOption = option
                }
            )
        }

    }

}
@Composable
fun Ask5() {
    var selectedOption by remember { mutableStateOf("Option 1") }

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
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Pembuangan air besar" ,
                color = colorResource(id = R.color.fontblue),
                fontWeight = FontWeight.SemiBold,
                fontSize = 17.sp,
            )
            RadioGroup(
                options = listOf(
                    "Jamban sendiri",
                    "Jamban bersama atau umum",
                    "Sungai selokan",
                    "Kebun atau sawah",
                    "Kolam atau empang",
                    "Kandang ternak",
                    "Laut atau danau",
                    "Lainnya"
                ),
                selectedOption = selectedOption,
                onOptionSelected = { option ->
                    selectedOption = option
                }
            )
        }

    }

}
@Composable
fun Ask6() {
    var selectedOption by remember { mutableStateOf("Option 1") }

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
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Sumber air minum utama",
                color = colorResource(id = R.color.fontblue),
                fontWeight = FontWeight.SemiBold,
                fontSize = 17.sp,
            )
            RadioGroup(
                options = listOf(
                    "Air kemasan",
                    "Ledeng atau pipa",
                    "Sumur",
                    "Mata air",
                    "Air hujan",
                    "Sungai",
                    "Kolam",
                    "Bak penampungan",
                    "Lainnya"
                ),
                selectedOption = selectedOption,
                onOptionSelected = { option ->
                    selectedOption = option
                }
            )
        }

    }

}
@Composable
fun Ask7() {
    var selectedOption by remember { mutableStateOf("Option 1") }

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
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Bahan bakar untuk memasak",
                color = colorResource(id = R.color.fontblue),
                fontWeight = FontWeight.SemiBold,
                fontSize = 17.sp,
            )
            RadioGroup(
                options = listOf(
                    "Listrik",
                    "Gas elpiji",
                    "Minyak tanah",
                    "Kayu atau arang",
                    "Lainnya"
                ),
                selectedOption = selectedOption,
                onOptionSelected = { option ->
                    selectedOption = option
                }
            )
        }

    }

}
@Composable
fun Ask8() {
    var selectedOption by remember { mutableStateOf("Option 1") }

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
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Kepemilikan Asuransi",
                color = colorResource(id = R.color.fontblue),
                fontWeight = FontWeight.SemiBold,
                fontSize = 17.sp,
            )
            RadioGroup(
                options = listOf(
                    "Tidak memiliki asuransi",
                    "Memiliki asuransi"
                ),
                selectedOption = selectedOption,
                onOptionSelected = { option ->
                    selectedOption = option
                }
            )
        }

    }

}
@Composable
fun Ask9() {
    var selectedOption by remember { mutableStateOf("Option 1") }

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
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Jumlah ruangan rumah",
                color = colorResource(id = R.color.fontblue),
                fontWeight = FontWeight.SemiBold,
                fontSize = 17.sp,
            )
            RadioGroup(
                options = listOf(
                    "1 ruangan",
                    "Kurang dari 5 ruangan",
                    "Kurang dari 10 ruangan",
                    "Kurang dari 20 ruangan",
                    "Lebih dari 20 ruangan",
                ),
                selectedOption = selectedOption,
                onOptionSelected = { option ->
                    selectedOption = option
                }
            )
        }

    }


}
@Composable
fun Ask10() {
    var selectedOption by remember { mutableStateOf("Option 1") }

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
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Jenis lantai rumah",
                color = colorResource(id = R.color.fontblue),
                fontWeight = FontWeight.SemiBold,
                fontSize = 17.sp
            )
            RadioGroup(
                options = listOf(
                    "Keramik, marmer, ubin, grani, tegel, atau teraso",
                    "Semen atau bata merah",
                    "Kayu atau bambu",
                    "Tanah",
                    "Lainnya",
                ),
                selectedOption = selectedOption,
                onOptionSelected = { option ->
                    selectedOption = option
                }
            )
        }

    }

}
@Composable
fun Ask11() {
    var selectedOption by remember { mutableStateOf("Option 1") }

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
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Jenis dinding luar rumah",
                color = colorResource(id = R.color.fontblue),
                fontWeight = FontWeight.SemiBold,
                fontSize = 17.sp
            )
            RadioGroup(
                options = listOf(
                    "Tembok",
                    "Kayu, papan, atau triplek",
                    "Bambu",
                    "Lainnya"
                ),
                selectedOption = selectedOption,
                onOptionSelected = { option ->
                    selectedOption = option
                }
            )
        }

    }

}
@Composable
fun Ask12() {
    var selectedOption by remember { mutableStateOf("Option 1") }

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
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Jenis atap rumah",
                color = colorResource(id = R.color.fontblue),
                fontWeight = FontWeight.SemiBold,
                fontSize = 17.sp
            )
            RadioGroup(
                options = listOf(
                    "Genteng",
                    "Kayu",
                    "Seng",
                    "Asbes",
                    "Daun",
                    "Lainnya",
                ),
                selectedOption = selectedOption,
                onOptionSelected = { option ->
                    selectedOption = option
                }
            )
        }

    }

}



@Composable
fun RadioGroup(
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    Column {
        options.forEach { option ->
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                RadioButton(
                    selected = option == selectedOption,
                    onClick = { onOptionSelected(option) },
                )
                Text(text = option,
                    color = colorResource(id = R.color.black),
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp)
            }
        }
    }
}




@Preview(showBackground = true)
@Composable
fun PreviewRadioGroupExample() {
    GeniusAidAppTheme {
        Ask1()
    }
}