package com.vikas.doggoadoption

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.vikas.doggoadoption.ui.components.DetailsComponent
import com.vikas.doggoadoption.ui.components.HomeComponent
import com.vikas.doggoadoption.ui.theme.DoggoAdoptionTheme
import com.vikas.doggoadoption.ui.theme.backGroundColor

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DoggoAdoptionTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = backGroundColor) {
                    Column {
                        DetailsComponent()
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
        HomeComponent()
    }
}