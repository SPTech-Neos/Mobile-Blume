package com.example.blume_mobile.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.blume_mobile.models.product.Product
import com.example.blume_mobile.ui.components.titles.TitleBlume
import com.example.blume_mobile.ui.theme.Gray700
import com.example.blume_mobile.ui.theme.Violet500

@Composable
fun ProductDetails(product: Product){
    Column(
        Modifier
            .fillMaxSize(),
        Arrangement.Center,
        Alignment.CenterHorizontally
    ){
        Column(
            Modifier
                .fillMaxSize(0.92f)
                .padding(top = 6.dp)
        ){
            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment =  Alignment.CenterVertically
            ){
                Box(
                    modifier = Modifier
                        .size(38.dp)
                        .clip(CircleShape)
                        .background(Violet500)
                ){

                }
                Spacer(modifier = Modifier.width(77.dp))
                TitleBlume()
            }
        }
    }
}

