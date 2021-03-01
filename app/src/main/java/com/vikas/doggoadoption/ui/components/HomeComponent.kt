package com.vikas.doggoadoption.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.vikas.doggoadoption.DoggoViewModel
import com.vikas.doggoadoption.data.DoggoBreedResponseModel
import com.vikas.doggoadoption.data.DoggoNavigation
import com.vikas.doggoadoption.ui.theme.DoggoAdoptionTheme

const val HOME_COMPONENT = "HomeComponent"

@Composable
fun HomeComponent(
    observeBreed: List<DoggoBreedResponseModel>?,
    liveRecentSearchItems: List<DoggoBreedResponseModel>,
    action: (DoggoNavigation) -> Unit,
    searchRecent: (String) -> Unit
) {
    LazyColumn {
        item {
            ToolbarHome(searchRecent)
            HomeCarousel(observeBreed, action)
            HomeCategories()
            HomeRecentSearch(liveRecentSearchItems, action)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeComponentPreview() {
    DoggoAdoptionTheme {
        HomeComponent(
            DoggoViewModel().sampleBreed(),
            DoggoViewModel().sampleBreed(), {}, {})
    }
}