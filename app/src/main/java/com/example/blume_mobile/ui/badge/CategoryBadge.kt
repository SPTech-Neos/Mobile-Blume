package com.example.blume_mobile.ui.badge

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.blume_mobile.ui.theme.Gray200
import com.example.blume_mobile.ui.theme.Gray700
import com.example.blume_mobile.ui.theme.Violet300
import com.example.blume_mobile.ui.theme.Violet50
import com.example.blume_mobile.ui.theme.poppins

@Composable
fun CategoryBadge(
    name: String,
    width: Int,
    height: Int,
    clickable: Boolean = false,
    onClick: (String) -> Unit = {},
    categorySelected: String = ""
){

    val background = if(categorySelected == name) Violet300 else Gray200

    Surface(
        shape = RoundedCornerShape(8.dp),
        shadowElevation = 3.dp
    ) {
        Box(
            Modifier.size(
                width = width.dp,
                height = height.dp
            )
                .background(background)
                .padding(horizontal = 6.dp)
                .clickable(clickable){
                    onClick(name)
                }
            , contentAlignment = Alignment.Center
        ) {
            Text(
                text = name,
                style = TextStyle(
                    fontSize = 8.sp,
                    fontFamily = poppins,
                    fontWeight = FontWeight(700),
                    textAlign = TextAlign.Center,
                    color = Gray700
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }

}