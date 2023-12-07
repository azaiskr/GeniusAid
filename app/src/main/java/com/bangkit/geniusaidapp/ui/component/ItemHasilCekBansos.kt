package com.bangkit.geniusaidapp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bangkit.geniusaidapp.R

@Composable
fun ItemDataProfinsiDkk() {
    Row (
        Modifier
            .background(color = colorResource(id = R.color.whiteBlue))
            .fillMaxWidth()
            .padding(8.dp)
    ){
        Column {
            Text(
                text = "Provinsi",
                color = colorResource(id = R.color.fontblue),
                fontWeight = FontWeight.SemiBold,
                fontSize = 17.sp,
                modifier = Modifier.padding(4.dp)
            )

            Text(
                text = "Sulawesi Tenggara",
                color = colorResource(id = R.color.black),
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                modifier = Modifier.padding(4.dp)
            )
            Spacer(modifier = Modifier.padding(8.dp))

            Text(
                text = "Kecamatan",
                color = colorResource(id = R.color.fontblue),
                fontWeight = FontWeight.SemiBold,
                fontSize = 17.sp,
                modifier = Modifier.padding(4.dp)
            )
            Text(
                text = "Murhum",
                color = colorResource(id = R.color.black),
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                modifier = Modifier.padding(4.dp)
            )

        }
        Column (modifier = Modifier.padding(start = 60.dp)){
            Text(
                text = "Kabupaten",
                color = colorResource(id = R.color.fontblue),
                fontWeight = FontWeight.SemiBold,
                fontSize = 17.sp,
                modifier = Modifier.padding(4.dp)
            )

            Text(
                text = "Kota Baubau",
                color = colorResource(id = R.color.black),
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                modifier = Modifier.padding(4.dp)
            )

            Spacer(modifier = Modifier.padding(8.dp))
            Text(
                text = "Kelurahan",
                color = colorResource(id = R.color.fontblue),
                fontWeight = FontWeight.SemiBold,
                fontSize = 17.sp,
                modifier = Modifier.padding(4.dp)
            )

            Text(
                text = "Tanganapada",
                color = colorResource(id = R.color.black),
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                modifier = Modifier.padding(4.dp)
            )

        }

    }

}

@Composable
fun ItemDataOrangDkk() {

    Card(
        elevation = CardDefaults.cardElevation(5.dp),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.whiteBlue),
        ),
        modifier = Modifier
            .padding(10.dp)
            .wrapContentSize()
    ){
        Row (
            Modifier
                .background(color = colorResource(id = R.color.whiteBlue))
                .fillMaxWidth()
                .padding(8.dp)
        ){
            Column {
                Text(
                    text = "Nama",
                    color = colorResource(id = R.color.fontblue),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 17.sp,
                    modifier = Modifier.padding(4.dp)
                )

                Text(
                    text = "Ario",
                    color = colorResource(id = R.color.black),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(4.dp)
                )
                Spacer(modifier = Modifier.padding(8.dp))

                Text(
                    text = "BPNT",
                    color = colorResource(id = R.color.fontblue),
                    fontWeight = FontWeight.Medium,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(4.dp)
                )

                Row {

                    Text(
                        text = "Status : ",
                        color = colorResource(id = R.color.black),
                        fontWeight = FontWeight.Normal,
                        fontSize = 11.sp,
                        modifier = Modifier.padding(4.dp),

                        )
                    Text(
                        text = "Ya",
                        color = colorResource(id = R.color.black),
                        fontWeight = FontWeight.Normal,
                        fontSize = 11.sp,
                        modifier = Modifier.padding(4.dp),
                    )
                }



                Text(
                    text = "Periode : ",
                    color = colorResource(id = R.color.black),
                    fontWeight = FontWeight.Normal,
                    fontSize = 11.sp,
                    modifier = Modifier.padding(4.dp),

                    )


                Text(
                    text = "SEMBBAKO NOV - DES 2023",
                    color = colorResource(id = R.color.black),
                    fontWeight = FontWeight.Normal,
                    fontSize = 11.sp,
                    modifier = Modifier.padding(4.dp),
                )

                Spacer(modifier = Modifier.padding(8.dp))

                Text(
                    text = "BST",
                    color = colorResource(id = R.color.fontblue),
                    fontWeight = FontWeight.Medium,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(4.dp)
                )

                Row {

                    Text(
                        text = "Status : ",
                        color = colorResource(id = R.color.black),
                        fontWeight = FontWeight.Normal,
                        fontSize = 11.sp,
                        modifier = Modifier.padding(4.dp),

                        )
                    Text(
                        text = "TIDAK",
                        color = colorResource(id = R.color.black),
                        fontWeight = FontWeight.Normal,
                        fontSize = 11.sp,
                        modifier = Modifier.padding(4.dp),
                    )
                }

                Text(
                    text = "Periode : ",
                    color = colorResource(id = R.color.black),
                    fontWeight = FontWeight.Normal,
                    fontSize = 11.sp,
                    modifier = Modifier.padding(4.dp),

                    )

                Text(
                    text = " ",
                    color = colorResource(id = R.color.black),
                    fontWeight = FontWeight.Normal,
                    fontSize = 11.sp,
                    modifier = Modifier.padding(4.dp),
                )


                Spacer(modifier = Modifier.padding(8.dp))

                Text(
                    text = "BLT",
                    color = colorResource(id = R.color.fontblue),
                    fontWeight = FontWeight.Medium,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(4.dp)
                )

                Row {

                    Text(
                        text = "Status : ",
                        color = colorResource(id = R.color.black),
                        fontWeight = FontWeight.Normal,
                        fontSize = 11.sp,
                        modifier = Modifier.padding(4.dp),

                        )
                    Text(
                        text = "TIDAK",
                        color = colorResource(id = R.color.black),
                        fontWeight = FontWeight.Normal,
                        fontSize = 11.sp,
                        modifier = Modifier.padding(4.dp),
                    )
                }


                Text(
                    text = "Periode : ",
                    color = colorResource(id = R.color.black),
                    fontWeight = FontWeight.Normal,
                    fontSize = 11.sp,
                    modifier = Modifier.padding(4.dp),

                    )


                Text(
                    text = " ",
                    color = colorResource(id = R.color.black),
                    fontWeight = FontWeight.Normal,
                    fontSize = 11.sp,
                    modifier = Modifier.padding(4.dp),
                )

                Spacer(modifier = Modifier.padding(8.dp))

                Text(
                    text = "RST",
                    color = colorResource(id = R.color.fontblue),
                    fontWeight = FontWeight.Medium,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(4.dp)
                )

                Row {

                    Text(
                        text = "Status : ",
                        color = colorResource(id = R.color.black),
                        fontWeight = FontWeight.Normal,
                        fontSize = 11.sp,
                        modifier = Modifier.padding(4.dp),

                        )
                    Text(
                        text = "TIDAK",
                        color = colorResource(id = R.color.black),
                        fontWeight = FontWeight.Normal,
                        fontSize = 11.sp,
                        modifier = Modifier.padding(4.dp),
                    )
                }


                Text(
                    text = "Periode : ",
                    color = colorResource(id = R.color.black),
                    fontWeight = FontWeight.Normal,
                    fontSize = 11.sp,
                    modifier = Modifier.padding(4.dp),

                    )


                Text(
                    text = " ",
                    color = colorResource(id = R.color.black),
                    fontWeight = FontWeight.Normal,
                    fontSize = 11.sp,
                    modifier = Modifier.padding(4.dp),
                )

                Spacer(modifier = Modifier.padding(8.dp))

                Text(
                    text = "SEMBAKO ADAPTIF",
                    color = colorResource(id = R.color.fontblue),
                    fontWeight = FontWeight.Medium,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(4.dp)
                )

                Row {

                    Text(
                        text = "Status : ",
                        color = colorResource(id = R.color.black),
                        fontWeight = FontWeight.Normal,
                        fontSize = 11.sp,
                        modifier = Modifier.padding(4.dp),

                        )
                    Text(
                        text = "TIDAK",
                        color = colorResource(id = R.color.black),
                        fontWeight = FontWeight.Normal,
                        fontSize = 11.sp,
                        modifier = Modifier.padding(4.dp),
                    )
                }

                Text(
                    text = "Periode : ",
                    color = colorResource(id = R.color.black),
                    fontWeight = FontWeight.Normal,
                    fontSize = 11.sp,
                    modifier = Modifier.padding(4.dp),

                    )

                Text(
                    text = " ",
                    color = colorResource(id = R.color.black),
                    fontWeight = FontWeight.Normal,
                    fontSize = 11.sp,
                    modifier = Modifier.padding(4.dp),
                )
            }
            Column (modifier = Modifier.padding(4.dp)){
                Text(
                    text = "Umur",
                    color = colorResource(id = R.color.fontblue),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 17.sp,
                    modifier = Modifier.padding(4.dp)
                )

                Text(
                    text = "32",
                    color = colorResource(id = R.color.black),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(4.dp)
                )

                Spacer(modifier = Modifier.padding(8.dp))
                Text(
                    text = "PKH",
                    color = colorResource(id = R.color.fontblue),
                    fontWeight = FontWeight.Medium,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(4.dp)
                )

                Row {
                    Text(
                        text = "Status : ",
                        color = colorResource(id = R.color.black),
                        fontWeight = FontWeight.Normal,
                        fontSize = 11.sp,
                        modifier = Modifier.padding(4.dp),

                        )
                    Text(
                        text = "-",
                        color = colorResource(id = R.color.black),
                        fontWeight = FontWeight.Normal,
                        fontSize = 11.sp,
                        modifier = Modifier.padding(4.dp),
                    )
                }

                Text(
                    text = "Periode : ",
                    color = colorResource(id = R.color.black),
                    fontWeight = FontWeight.Normal,
                    fontSize = 11.sp,
                    modifier = Modifier.padding(4.dp),

                    )

                Text(
                    text = " ",
                    color = colorResource(id = R.color.black),
                    fontWeight = FontWeight.Normal,
                    fontSize = 11.sp,
                    modifier = Modifier.padding(4.dp),
                )
                Spacer(modifier = Modifier.padding(8.dp))
                Text(
                    text = "PBI-JK",
                    color = colorResource(id = R.color.fontblue),
                    fontWeight = FontWeight.Medium,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(4.dp)
                )

                Row {
                    Text(
                        text = "Status : ",
                        color = colorResource(id = R.color.black),
                        fontWeight = FontWeight.Normal,
                        fontSize = 11.sp,
                        modifier = Modifier.padding(4.dp),

                        )
                    Text(
                        text = "YA",
                        color = colorResource(id = R.color.black),
                        fontWeight = FontWeight.Normal,
                        fontSize = 11.sp,
                        modifier = Modifier.padding(4.dp),
                    )
                }

                Text(
                    text = "Periode : ",
                    color = colorResource(id = R.color.black),
                    fontWeight = FontWeight.Normal,
                    fontSize = 11.sp,
                    modifier = Modifier.padding(4.dp),

                    )

                Text(
                    text = "NOV 2023",
                    color = colorResource(id = R.color.black),
                    fontWeight = FontWeight.Normal,
                    fontSize = 11.sp,
                    modifier = Modifier.padding(4.dp),
                )

                Spacer(modifier = Modifier.padding(8.dp))
                Text(
                    text = "BANTUAN YATIM PIATU",
                    color = colorResource(id = R.color.fontblue),
                    fontWeight = FontWeight.Medium,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(4.dp)
                )

                Row {
                    Text(
                        text = "Status : ",
                        color = colorResource(id = R.color.black),
                        fontWeight = FontWeight.Normal,
                        fontSize = 11.sp,
                        modifier = Modifier.padding(4.dp),

                        )
                    Text(
                        text = "TIDAK",
                        color = colorResource(id = R.color.black),
                        fontWeight = FontWeight.Normal,
                        fontSize = 11.sp,
                        modifier = Modifier.padding(4.dp),
                    )
                }

                Text(
                    text = "Periode : ",
                    color = colorResource(id = R.color.black),
                    fontWeight = FontWeight.Normal,
                    fontSize = 11.sp,
                    modifier = Modifier.padding(4.dp),

                    )

                Text(
                    text = " ",
                    color = colorResource(id = R.color.black),
                    fontWeight = FontWeight.Normal,
                    fontSize = 11.sp,
                    modifier = Modifier.padding(4.dp),
                )
                Spacer(modifier = Modifier.padding(8.dp))
                Text(
                    text = "PEMAKAMAN",
                    color = colorResource(id = R.color.fontblue),
                    fontWeight = FontWeight.Medium,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(4.dp)
                )

                Row {
                    Text(
                        text = "Status : ",
                        color = colorResource(id = R.color.black),
                        fontWeight = FontWeight.Normal,
                        fontSize = 11.sp,
                        modifier = Modifier.padding(4.dp),

                        )
                    Text(
                        text = "TIDAK",
                        color = colorResource(id = R.color.black),
                        fontWeight = FontWeight.Normal,
                        fontSize = 11.sp,
                        modifier = Modifier.padding(4.dp),
                    )
                }

                Text(
                    text = "Periode : ",
                    color = colorResource(id = R.color.black),
                    fontWeight = FontWeight.Normal,
                    fontSize = 11.sp,
                    modifier = Modifier.padding(4.dp),

                    )

                Text(
                    text = " ",
                    color = colorResource(id = R.color.black),
                    fontWeight = FontWeight.Normal,
                    fontSize = 11.sp,
                    modifier = Modifier.padding(4.dp),
                )
                Spacer(modifier = Modifier.padding(8.dp))
                Text(
                    text = "PENA",
                    color = colorResource(id = R.color.fontblue),
                    fontWeight = FontWeight.Medium,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(4.dp)
                )

                Row {
                    Text(
                        text = "Status : ",
                        color = colorResource(id = R.color.black),
                        fontWeight = FontWeight.Normal,
                        fontSize = 11.sp,
                        modifier = Modifier.padding(4.dp),

                        )
                    Text(
                        text = "TIDAK",
                        color = colorResource(id = R.color.black),
                        fontWeight = FontWeight.Normal,
                        fontSize = 11.sp,
                        modifier = Modifier.padding(4.dp),
                    )
                }

                Text(
                    text = "Periode : ",
                    color = colorResource(id = R.color.black),
                    fontWeight = FontWeight.Normal,
                    fontSize = 11.sp,
                    modifier = Modifier.padding(4.dp),

                    )

                Text(
                    text = " ",
                    color = colorResource(id = R.color.black),
                    fontWeight = FontWeight.Normal,
                    fontSize = 11.sp,
                    modifier = Modifier.padding(4.dp),
                )





            }

        }

    }



}