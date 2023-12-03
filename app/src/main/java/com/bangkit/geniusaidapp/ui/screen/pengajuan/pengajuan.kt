package com.bangkit.geniusaidapp.ui.screen.pengajuan

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.bangkit.geniusaidapp.ui.component.Ask1
import com.bangkit.geniusaidapp.ui.component.Ask10
import com.bangkit.geniusaidapp.ui.component.Ask11
import com.bangkit.geniusaidapp.ui.component.Ask12
import com.bangkit.geniusaidapp.ui.component.Ask2
import com.bangkit.geniusaidapp.ui.component.Ask3
import com.bangkit.geniusaidapp.ui.component.Ask4
import com.bangkit.geniusaidapp.ui.component.Ask5
import com.bangkit.geniusaidapp.ui.component.Ask6
import com.bangkit.geniusaidapp.ui.component.Ask7
import com.bangkit.geniusaidapp.ui.component.Ask8
import com.bangkit.geniusaidapp.ui.component.Ask9
import com.bangkit.geniusaidapp.ui.component.imageCaptureFromCamera

@Composable
fun ContentPengajuan() {
    Column (
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Ask1()
        Ask2()
        Ask3()
        Ask4()
        Ask5()
        Ask6()
        Ask7()
        Ask8()
        Ask9()
        Ask10()
        Ask11()
        Ask12()
        imageCaptureFromCamera()
    }

}