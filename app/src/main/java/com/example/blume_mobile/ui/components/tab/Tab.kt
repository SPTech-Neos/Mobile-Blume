package com.example.blume_mobile.ui.components.tab

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.blume_mobile.ui.theme.Gray100
import com.example.blume_mobile.ui.theme.Gray200
import com.example.blume_mobile.ui.theme.Gray500
import com.example.blume_mobile.ui.theme.Gray700
import com.example.blume_mobile.ui.theme.Violet300
import com.example.blume_mobile.ui.theme.poppins

@Composable
fun Tab(
    text: String,
    onClick: (String) -> Unit = {},
    categorySelected: String = ""
){
    val background = if(categorySelected == text) Violet300 else Gray500
    Column(
        Modifier
            .height(20.dp).clickable(true){
                onClick(text)
            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text, style = TextStyle(
            fontFamily = poppins,
            fontSize = 12.sp,
            fontWeight = FontWeight.W700,
            textAlign = TextAlign.Center,
            color = background
        ))

        Box(modifier = Modifier
            .width(85.dp)
            .height(2.dp)
            .background(background)
            .clip(RoundedCornerShape(10)
        ))
    }
}