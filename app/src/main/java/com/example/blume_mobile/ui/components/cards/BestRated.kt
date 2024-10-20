package com.example.blume_mobile.ui.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.blume_mobile.R
import com.example.blume_mobile.ui.theme.poppins
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.blume_mobile.ui.badge.CategoryBadge
import com.example.blume_mobile.ui.theme.Gray100
import com.example.blume_mobile.ui.theme.Gray700

@Composable
fun BestRated(
    name: String,
    categories: List<String>,
    profile: String
){
    Surface(
        shape = RoundedCornerShape(8.dp),
        shadowElevation = 3.dp
    ) {
        Column(
            Modifier
                .width(155.dp)
                .height(130.dp)
                .background(Gray100)
                .padding(vertical = 10.dp)
            ,
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                    modifier = Modifier
                        .size(45.dp)
                        .clip(CircleShape),
                model = profile,
                contentDescription = "Imagem de perfil do estabelecimento $name",
                placeholder = painterResource(R.drawable.photo_placeholder),
                contentScale = ContentScale.Crop,
            )
            Text(
                text = name,
                style = TextStyle(
                    fontFamily = poppins,
                    fontSize = 12.sp,
                    fontWeight = FontWeight(700),
                    color = Gray700,
                    textAlign = TextAlign.Center
                )
            )

            LazyRow(
                Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                ,
                contentPadding = PaddingValues(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                items(categories){ c ->
                    CategoryBadge(name = c, width = 60, height = 20)
                }
            }
        }
    }
}