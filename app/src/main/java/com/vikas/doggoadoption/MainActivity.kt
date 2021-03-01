package com.vikas.doggoadoption

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.tooling.preview.Preview
import com.vikas.doggoadoption.data.DoggoNavigation
import com.vikas.doggoadoption.ui.components.DetailsComponent
import com.vikas.doggoadoption.ui.components.HomeComponent
import com.vikas.doggoadoption.ui.theme.DoggoAdoptionTheme
import com.vikas.doggoadoption.ui.theme.backGroundColor

class MainActivity : AppCompatActivity() {

    lateinit var doggoViewModel: DoggoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        doggoViewModel = defaultViewModelProviderFactory.create(DoggoViewModel::class.java)

        doggoViewModel.fetchBreed()

        setContent {
            DoggoAdoptionTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = backGroundColor) {
                    Column {

                        var screenName by remember { mutableStateOf(doggoViewModel.observeScreen().value) }
                        val breedItems by doggoViewModel.liveBreedData().observeAsState()
                        val liveSearchItems by doggoViewModel.liveRecentSearchData()
                            .observeAsState()

                        when (screenName) {
                            DoggoNavigation.HOME -> {
                                HomeComponent(
                                    breedItems,
                                    liveSearchItems ?: listOf(), { doggoNavigation ->
                                        screenName = doggoNavigation
                                    }, {
                                        doggoViewModel.searchRecentData(it)
                                    })
                            }
                            is DoggoNavigation.HomeDetails -> {
                                val screenHomeDetails = screenName as DoggoNavigation.HomeDetails
                                DetailsComponent(screenHomeDetails.doggoBreedResponseModel) {
                                    screenName = it
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    DoggoAdoptionTheme {
        HomeComponent(DoggoViewModel().sampleBreed(), DoggoViewModel().sampleBreed(), {}, {})
    }
}