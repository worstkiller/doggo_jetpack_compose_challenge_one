package com.vikas.doggoadoption.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Build
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vikas.doggoadoption.R
import com.vikas.doggoadoption.ui.theme.DoggoAdoptionTheme
import com.vikas.doggoadoption.ui.theme.Typography
import com.vikas.doggoadoption.ui.theme.iconTintColor

@Composable
fun DetailsComponent() {

    val temperament = "Stubborn, Curious, Playful, Adventurous, Active, Fun-loving".split(",")

    Column(modifier = Modifier.fillMaxWidth()) {

        Box(contentAlignment = Alignment.BottomCenter) {

            Image(
                alignment = Alignment.TopCenter,
                painter = painterResource(id = R.drawable.sample_image_dog),
                contentDescription = "full screen details",
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(.60f),
                contentScale = ContentScale.Crop,
            )

            Icon(
                imageVector = Icons.Rounded.ArrowBack,
                contentDescription = "back",
                tint = Color.White
            )

            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(
                        shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp),
                        color = MaterialTheme.colors.background
                    )
            ) {

                LazyRow(
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier.padding(16.dp)
                ) {
                    items(temperament) {
                        Card(shape = RoundedCornerShape(10.dp), modifier = Modifier.padding(8.dp)) {
                            Text(text = it, modifier = Modifier.padding(8.dp))
                        }
                    }
                }
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        ) {

            Text(
                text = "Name: Hound",
                color = iconTintColor,
                style = Typography.h6,
                modifier = Modifier.padding(16.dp)
            )

            Text(
                text = "Breed: Toy",
                style = Typography.subtitle2.copy(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp
                ),
                color = iconTintColor.copy(alpha = 0.6f),
                modifier = Modifier.padding(start = 16.dp),
            )

            Text(
                text = "Life span: 10 - 12 years",
                style = Typography.subtitle2.copy(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp
                ),
                color = iconTintColor.copy(alpha = 0.6f),
                modifier = Modifier.padding(start = 16.dp, top = 8.dp),
            )

            Text(
                text = "Origin: Germany, France",
                style = Typography.subtitle2.copy(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp
                ),
                color = iconTintColor.copy(alpha = 0.6f),
                modifier = Modifier.padding(start = 16.dp, top = 8.dp),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
        }

        Spacer(modifier = Modifier.size(30.dp))

        Button(
            onClick = { }, modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(15.dp)
        ) {
            Text(text = stringResource(R.string.button_love_me), modifier = Modifier.padding(8.dp))
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DetailsComponentPreview() {
    DoggoAdoptionTheme {
        DetailsComponent()
    }
}