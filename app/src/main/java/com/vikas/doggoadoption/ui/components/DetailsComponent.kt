package com.vikas.doggoadoption.ui.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vikas.doggoadoption.DoggoViewModel
import com.vikas.doggoadoption.R
import com.vikas.doggoadoption.data.DoggoBreedResponseModel
import com.vikas.doggoadoption.data.DoggoNavigation
import com.vikas.doggoadoption.ui.theme.DoggoAdoptionTheme
import com.vikas.doggoadoption.ui.theme.Teal200
import com.vikas.doggoadoption.ui.theme.Typography
import com.vikas.doggoadoption.ui.theme.iconTintColor
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun DetailsComponent(
    doggoBreedResponseModel: DoggoBreedResponseModel,
    action: (screen: DoggoNavigation) -> Unit
) {
    val context = LocalContext.current
    val temperament = doggoBreedResponseModel.temperament.split(",")

    Column(modifier = Modifier.fillMaxWidth()) {

        Box {

            Box(contentAlignment = Alignment.BottomCenter) {

                CoilImage(
                    data = doggoBreedResponseModel.image.url,
                    contentDescription = doggoBreedResponseModel.name,
                    alignment = Alignment.TopCenter,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(.60f),
                    contentScale = ContentScale.Crop,
                    loading = {
                        Box(
                            modifier = Modifier.background(
                                shape = RoundedCornerShape(20.dp),
                                color = Teal200
                            )
                        )
                    },
                    error = {
                        Box(
                            modifier = Modifier.background(
                                shape = RoundedCornerShape(20.dp),
                                color = Teal200
                            )
                        )
                    }
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
                            Card(
                                shape = RoundedCornerShape(10.dp),
                                modifier = Modifier.padding(8.dp)
                            ) {
                                Text(text = it, modifier = Modifier.padding(8.dp))
                            }
                        }
                    }
                }
            }

            Icon(
                imageVector = Icons.Rounded.ArrowBack,
                contentDescription = "back",
                tint = Color.White,
                modifier = Modifier
                    .padding(16.dp)
                    .clickable {
                        action(DoggoNavigation.HOME)
                    }
            )
        }


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        ) {

            Text(
                text = "Name: ${doggoBreedResponseModel.name}",
                color = iconTintColor,
                style = Typography.h6,
                modifier = Modifier.padding(16.dp)
            )

            Text(
                text = "Breed: ${doggoBreedResponseModel.breed_group ?: "NA"}",
                style = Typography.subtitle2.copy(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp
                ),
                color = iconTintColor.copy(alpha = 0.6f),
                modifier = Modifier.padding(start = 16.dp),
            )

            Text(
                text = "Life span: ${doggoBreedResponseModel.life_span}",
                style = Typography.subtitle2.copy(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp
                ),
                color = iconTintColor.copy(alpha = 0.6f),
                modifier = Modifier.padding(start = 16.dp, top = 8.dp),
            )

            Text(
                text = "Origin: ${doggoBreedResponseModel.origin ?: doggoBreedResponseModel.country_code ?: "NA"}",
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
            onClick = {
                Toast.makeText(
                    context, "Thanks for your interest ❤️\u200D\uD83D\uDD25",
                    Toast.LENGTH_LONG
                ).show()
            }, modifier = Modifier
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
        DetailsComponent(doggoBreedResponseModel = DoggoViewModel().sampleBreed().first()) {}
    }
}