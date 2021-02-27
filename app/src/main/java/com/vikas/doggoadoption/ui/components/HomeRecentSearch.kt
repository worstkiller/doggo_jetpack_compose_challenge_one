package com.vikas.doggoadoption.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.vikas.doggoadoption.R
import com.vikas.doggoadoption.ui.theme.DoggoAdoptionTheme
import com.vikas.doggoadoption.ui.theme.Typography
import com.vikas.doggoadoption.ui.theme.iconTintColor

@Composable
fun HomeRecentSearch() {
    val widthSize by remember { mutableStateOf(320.dp) }
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = stringResource(id = R.string.home_recent_title),
            color = iconTintColor,
            style = Typography.h6
        )

        Spacer(modifier = Modifier.size(16.dp))

        LazyColumn(
            state = rememberLazyListState(),
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            item {
                repeat(10) {
                    SearchItems(widthSize)
                    Spacer(modifier = Modifier.size(16.dp))
                }
            }
        }
    }

}

@Composable
fun SearchItems(widthSize: Dp) {
    Card(
        elevation = 4.dp,
        shape = RoundedCornerShape(20.dp)
    ) {
        Row(
            modifier = Modifier
                .background(shape = RoundedCornerShape(20.dp), color = Color.White)
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.sample_image_dog),
                contentDescription = "recent image",
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(20.dp))
                    .fillMaxWidth(.40f)
                    .height(150.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.size(16.dp))
            Column {
                Text(
                    text = "Affenpinscher",
                    style = Typography.h6,
                    color = iconTintColor,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeRecentSearchPreview() {
    DoggoAdoptionTheme {
        HomeRecentSearch()
    }
}