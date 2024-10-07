package com.example.blume_mobile.ui.components.titles

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.blume_mobile.ui.theme.poppins

@Composable
fun Title(text: String){
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth(0.8f),

    ){
        Box(
            modifier = Modifier
                .width(45.dp)
                .height(2.dp)
                .background(Color(150, 154, 255))
        ){}

        Text(
            text = text.uppercase(),
            style = TextStyle(
                fontSize = 25.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontFamily = poppins
            ),
        )

        Box(
            modifier = Modifier
                .width(45.dp)
                .height(2.dp)
                .background(Color(150, 154, 255))
        ){}
    }
}