package com.vikas.doggoadoption.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
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
import com.vikas.doggoadoption.ui.uiutils.horizontalGradientBackground

@Composable
fun HomeCarousel() {
    val widthSize by remember { mutableStateOf(320.dp) }
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = stringResource(id = R.string.home_carousel_title),
            color = iconTintColor,
            style = Typography.h6
        )

        Spacer(modifier = Modifier.size(16.dp))

        LazyRow(
            state = rememberLazyListState(),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            item {
                repeat(5) {
                    CarouselItem(widthSize)
                    Spacer(modifier = Modifier.size(16.dp))
                }
            }
        }
    }
}

@Composable
fun CarouselItem(widthSize: Dp) {
    Box(contentAlignment = Alignment.CenterStart, modifier = Modifier.width(widthSize)) {

        Image(
            painter = painterResource(R.drawable.sample_image_dog),
            contentDescription = null,
            modifier = Modifier
                .height(160.dp)
                .width(widthSize)
                .clip(shape = RoundedCornerShape(20.dp)),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .height(160.dp)
                .width(widthSize)
                .clip(shape = RoundedCornerShape(20.dp))
                .horizontalGradientBackground(
                    listOf(
                        Color.Black.copy(alpha = .6f),
                        Color.Transparent
                    )
                ),
        )

        Column {
            Text(
                text = "Afghan Hound",
                color = Color.White,
                style = Typography.subtitle2,
                modifier = Modifier.padding(start = 16.dp)
            )

            Spacer(modifier = Modifier.size(16.dp))

            Text(
                text = "37.48 Min",
                color = Color.White,
                style = Typography.caption,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

    }
}


@Preview(showBackground = true)
@Composable
fun HomeCarouselPreview() {
    DoggoAdoptionTheme {
        HomeCarousel()
    }
}