package com.example.blume_mobile.ui.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.blume_mobile.ui.theme.Gray100
import com.example.blume_mobile.ui.theme.Gray700
import com.example.blume_mobile.ui.theme.poppins

@Composable
fun EstablishmentCard(){
    Surface(
        shape = RoundedCornerShape(8.dp),
        shadowElevation = 3.dp
    ) {
        Row(
            Modifier
                .width(344.dp)
                .height(65.dp)
                .background(Gray100)
            ,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ){
            Box(
                Modifier
                    .size(35.dp)
                    .clip(RoundedCornerShape(100.dp))
            ){
                Box(
                    Modifier
                        .size(50.dp)
                        .background(Color.Gray)
                        .clip(RoundedCornerShape(100.dp))
                ){
                }
            }
    
            Text("Nome estabelecimento", style = TextStyle(
                fontFamily = poppins,
                fontWeight = FontWeight.SemiBold,
                fontSize = 10.sp,
                color = Gray700
    
            )
            )
    
            Text("Categoria", style = TextStyle(
                fontFamily = poppins,
                fontWeight = FontWeight.Light,
                fontSize = 10.sp,
                color = Gray700
    
            ))
    
            Icon(Icons.Rounded.Star, contentDescription = "Avaliação", tint = Gray700)
        }
    }

}

@Preview
@Composable
fun CardEstabPreview(){
    EstablishmentCard()
}