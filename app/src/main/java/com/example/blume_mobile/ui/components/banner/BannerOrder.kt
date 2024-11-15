package com.example.blume_mobile.ui.components.banner

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.blume_mobile.models.market.Market
import com.example.blume_mobile.ui.theme.Gray100
import com.example.blume_mobile.ui.theme.Violet300
import com.example.blume_mobile.ui.theme.poppins

@Composable
fun BannerOrder(market: Market){
    Row(
        Modifier
            .fillMaxWidth(0.9f)
            .fillMaxHeight(0.15f)
            .clip(RoundedCornerShape(10))
            .background(Violet300),
        horizontalArrangement = Arrangement.SpaceAround
    ){
        Column(
            Modifier
                .fillMaxWidth(0.4f)
                .fillMaxHeight(),
            verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(text = "PEÇA DE NOVO!", style = TextStyle(
                fontSize = 20.sp,
                color = Gray100,
                fontFamily = poppins,
                fontWeight = FontWeight.W700
            ))

            Text(text = market., style = TextStyle(
                fontSize = 20.sp,
                color = Gray100,
                fontFamily = poppins,
                fontWeight = FontWeight.W700
            ))
        }


    }

}