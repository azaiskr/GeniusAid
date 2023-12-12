package com.bangkit.geniusaidapp.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.bangkit.geniusaidapp.R
import com.bangkit.geniusaidapp.model.ProfileBansos

@Composable
fun ItemProfileBansos(
    item: ProfileBansos,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(5.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.tertiary,
        ),
        modifier = modifier
            .padding(10.dp)
            .wrapContentSize()
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .padding(top = 10.dp, bottom = 10.dp)
                .fillMaxWidth()
        ) {
            AsyncImage(
                model = item.photoUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(8.dp)
                    .size(70.dp)
                    .clip(CircleShape)
            )
            Text(
                text = item.nameSigkat,
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = colorResource(id = R.color.black)

            )
        }
    }
}

@Composable
fun MainListProfileBansos(
    listProfilBansos: List<ProfileBansos>,
    navigateToDetailBansos: (Long) -> Unit
) {
    LazyColumn(modifier = Modifier
        .testTag("ListProfieBansos")
        .fillMaxSize()
        .padding(start = 5.dp, end = 5.dp)
    ){
        items(listProfilBansos){
            ItemProfileBansos(item = it, modifier = Modifier.clickable{
                navigateToDetailBansos(it.id)
            })

        }

    }

}