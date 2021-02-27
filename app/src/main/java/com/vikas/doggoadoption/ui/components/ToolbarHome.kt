package com.vikas.doggoadoption.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vikas.doggoadoption.R
import com.vikas.doggoadoption.ui.theme.DoggoAdoptionTheme
import com.vikas.doggoadoption.ui.theme.iconTintColor
import com.vikas.doggoadoption.ui.theme.searchBackground

@Composable
fun ToolbarHome() {
    var searchText by remember { mutableStateOf("") }
    Row(
        modifier = Modifier
            .padding(16.dp)
            .height(45.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            painter = painterResource(id = R.drawable.ic_drawer),
            contentDescription = "drawer",
            modifier = Modifier.size(20.dp),
            tint = iconTintColor
        )

        Spacer(modifier = Modifier.size(16.dp))

        BasicTextField(
            value = searchText,
            onValueChange = { searchText = it },
            modifier = Modifier
                .background(shape = RoundedCornerShape(10.dp), color = searchBackground)
                .border(width = 2.dp, shape = RoundedCornerShape(10.dp), color = Color.White)
                .fillMaxWidth(.90f)
                .padding(12.dp),
            decorationBox = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = "search",
                        modifier = Modifier.size(18.dp),
                        tint = iconTintColor
                    )

                    Spacer(modifier = Modifier.size(16.dp))

                    val textColor =
                        animateColorAsState(targetValue = if (searchText.isEmpty()) Color.LightGray else iconTintColor)

                    val label = if (searchText.isEmpty()) "Search" else searchText

                    Text(text = label, color = textColor.value)
                }
            }
        )

        Spacer(modifier = Modifier.size(8.dp))

        Icon(
            painter = painterResource(id = R.drawable.ic_bell),
            contentDescription = "search",
            modifier = Modifier.size(20.dp),
            tint = iconTintColor
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ToolbarHomePreview() {
    DoggoAdoptionTheme {
        ToolbarHome()
    }
}