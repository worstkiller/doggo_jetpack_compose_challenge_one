package com.vikas.doggoadoption.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.vikas.doggoadoption.ui.theme.DoggoAdoptionTheme

const val HOME_COMPONENT = "HomeComponent"

@Composable
fun HomeComponent() {
    Column() {
        ToolbarHome()
        HomeCarousel()
        HomeCategories()
        HomeRecentSearch()
    }
}

@Preview(showBackground = true)
@Composable
fun HomeComponentPreview() {
    DoggoAdoptionTheme {
        HomeComponent()
    }
}