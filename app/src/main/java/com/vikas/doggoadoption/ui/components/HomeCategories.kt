package com.vikas.doggoadoption.ui.components

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vikas.doggoadoption.R
import com.vikas.doggoadoption.data.CategoriesModel
import com.vikas.doggoadoption.ui.theme.*

@Composable
fun HomeCategories() {
    val categoriesList = arrayListOf<CategoriesModel>().apply {
        add(CategoriesModel("Sporting", R.drawable.ic_dog_1, redLight, redDark))
        add(CategoriesModel("Hound", R.drawable.ic_dog_2, yellowLight, yellowDark))
        add(CategoriesModel("Working", R.drawable.ic_dog_3, greenLight, greenDark))
        add(CategoriesModel("Terrier", R.drawable.ic_dog_4, blueLight, blueDark))
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = stringResource(id = R.string.home_categories_title),
            color = iconTintColor,
            style = Typography.h6
        )

        Spacer(modifier = Modifier.size(16.dp))

        LazyRow(
            state = rememberLazyListState(),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround

        ) {
            item {
                categoriesList.forEach {
                    HomeCategoriesItem(it)
                    Spacer(modifier = Modifier.size(32.dp))
                }
            }
        }
    }
}

@Composable
fun HomeCategoriesItem(categoriesModel: CategoriesModel) {
    val context = LocalContext.current
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = categoriesModel.icon),
            contentDescription = categoriesModel.title,
            modifier = Modifier
                .background(
                    shape = RoundedCornerShape(15.dp),
                    color = categoriesModel.backGroundColor
                )
                .padding(16.dp)
                .clickable {
                    Toast
                        .makeText(context, categoriesModel.title, Toast.LENGTH_LONG)
                        .show()
                },
            tint = categoriesModel.accent
        )
        Spacer(modifier = Modifier.size(16.dp))
        Text(
            text = categoriesModel.title,
            color = iconTintColor,
            textAlign = TextAlign.Center,
            style = Typography.caption
        )
    }

}

@Preview(showBackground = true)
@Composable
fun HomeCategoriesPreview() {
    HomeCategories()
}