package com.example.blume_mobile.ui.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.blume_mobile.R
import com.example.blume_mobile.ui.theme.Gray700
import com.example.blume_mobile.ui.theme.Green50
import com.example.blume_mobile.ui.theme.Violet50
import com.example.blume_mobile.ui.theme.Violet500
import com.example.blume_mobile.ui.theme.Yellow50
import com.example.blume_mobile.ui.theme.poppins

@Composable
fun CategoryCard(
    title: String,
    color: Color
){
    Box(
        Modifier.size(100.dp)
    ){
        Box(
            Modifier
                .size(
                    width = 50.dp,
                    height = 60.dp
                )
                .offset(40.dp, (-15).dp)
                .zIndex(1f)
                .paint(
                    // Replace with your image id
                    painterResource(id = R.drawable.polygon),
                    contentScale = ContentScale.FillBounds,

                )
        ){}

        Box(
            Modifier
                .size(
                    width = 100.dp,
                    height = 90.dp
                )
                .clip(RoundedCornerShape(15))
                .background(color)
                .padding(bottom = 20.dp, start = 10.dp)
            ,

            contentAlignment = Alignment.BottomStart
        ){
            Text(title, style = TextStyle(
                fontFamily = poppins,
                fontWeight = FontWeight.SemiBold

            ))
        }


    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CardPreview(){
    Row(

    ){
        CategoryCard("Cabelos", Violet50)
        CategoryCard("Unhas", Green50)
        CategoryCard("Barba", Yellow50)
    }
}