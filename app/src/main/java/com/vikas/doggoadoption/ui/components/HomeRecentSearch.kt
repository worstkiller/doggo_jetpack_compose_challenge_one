package com.vikas.doggoadoption.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
fun HomeRecentSearch(
    recentSearch: List<DoggoBreedResponseModel>,
    action: (DoggoNavigation) -> Unit,
) {

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = stringResource(id = R.string.home_recent_title),
            color = iconTintColor,
            style = Typography.h6
        )

        Spacer(modifier = Modifier.size(16.dp))

        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            recentSearch.forEach {
                SearchItems(action, it)
                Spacer(modifier = Modifier.size(16.dp))
            }
        }
    }

}

@Composable
fun SearchItems(
    action: (DoggoNavigation) -> Unit,
    doggoBreedResponseModel: DoggoBreedResponseModel
) {

    var bookMarked by remember { mutableStateOf(false) }

    Card(
        elevation = 2.dp,
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .clickable {
                action(DoggoNavigation.HomeDetails(doggoBreedResponseModel))
            }
            .padding(4.dp),
    ) {
        Row(
            modifier = Modifier
                .background(shape = RoundedCornerShape(20.dp), color = Color.White)
                .fillMaxWidth()
                .padding(8.dp)
        ) {

            CoilImage(
                data = doggoBreedResponseModel.image.url,
                contentDescription = doggoBreedResponseModel.name,
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(20.dp))
                    .fillMaxWidth(.30f)
                    .height(120.dp),
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

            Spacer(modifier = Modifier.size(16.dp))

            Column {
                Text(
                    text = doggoBreedResponseModel.name,
                    style = Typography.h6.copy(fontSize = 16.sp),
                    color = iconTintColor,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(.80f),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )

                Text(
                    text = "Breed: ${doggoBreedResponseModel.breed_group ?: "NA"}",
                    style = Typography.body1.copy(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp
                    ),
                    color = iconTintColor.copy(alpha = 0.6f),
                    modifier = Modifier.padding(start = 8.dp, bottom = 4.dp)
                )

                Text(
                    text = "Life span: ${doggoBreedResponseModel.life_span}",
                    style = Typography.body1.copy(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp
                    ),
                    color = iconTintColor.copy(alpha = 0.6f),
                    modifier = Modifier.padding(start = 8.dp, bottom = 4.dp)
                )

                Text(
                    text = "Origin: ${doggoBreedResponseModel.origin ?: doggoBreedResponseModel.country_code ?: "NA"}",
                    style = Typography.body1.copy(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp
                    ),
                    color = iconTintColor.copy(alpha = 0.6f),
                    modifier = Modifier.padding(start = 8.dp, bottom = 4.dp),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
            }

            Spacer(modifier = Modifier.size(16.dp))

            val bookMarkColor =
                animateColorAsState(
                    targetValue = if (bookMarked) Teal200 else iconTintColor.copy(
                        alpha = .6f
                    )
                )

            Icon(
                painter = painterResource(id = R.drawable.ic_bookmark),
                contentDescription = "",
                tint = bookMarkColor.value,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .size(20.dp)
                    .clickable {
                        bookMarked = bookMarked.not()
                    }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeRecentSearchPreview() {
    DoggoAdoptionTheme {
        HomeRecentSearch(DoggoViewModel().sampleBreed()) {
            //do something here
        }
    }
}