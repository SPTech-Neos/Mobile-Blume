package com.example.blume_mobile.ui.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.blume_mobile.R
import com.example.blume_mobile.models.market.Market
import com.example.blume_mobile.models.schedule.Scheduling
import com.example.blume_mobile.ui.components.Star
import com.example.blume_mobile.ui.theme.Gray100
import com.example.blume_mobile.ui.theme.Gray700
import com.example.blume_mobile.ui.theme.Violet300
import com.example.blume_mobile.ui.theme.poppins

@Composable
fun OrderCard(
    market: Market? = null,
    scheduling: Scheduling? = null
){
    val profile = market?.product?.imgUrl ?: (scheduling?.service?.imgUrl ?: "teste")
    val name = market?.product?.name ?: (scheduling?.service?.specification ?: "teste")
    val category = market?.product?.brand ?: (scheduling?.service?.serviceType?.serviceCategory?.name  ?: "teste")

    Surface(
        shape = RoundedCornerShape(8.dp),
        shadowElevation = 3.dp
    ) {
        Row(
            Modifier
                .width(344.dp)
                .height(65.dp)
                .background(Gray100)
                .padding(end = 10.dp)
            ,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ){
            if(profile != null){
                AsyncImage(
                    modifier = Modifier
                        .size(35.dp)
                        .clip(CircleShape),
                    model = profile,
                    contentDescription = "Imagem de perfil do estabelecimento",
                    placeholder = painterResource(R.drawable.photo_placeholder),
                    contentScale = ContentScale.Crop,
                )
            }else{
                Image(
                    modifier = Modifier
                        .size(35.dp)
                        .clip(CircleShape),
                    painter = painterResource(id = R.drawable.photo_placeholder),
                    contentDescription = "Imagem padrão quando não há escolha do usuário"
                )
            }

            Box(
                Modifier.width(80.dp),
                contentAlignment = Alignment.Center
            ){
                Text(name!!, style = TextStyle(
                    fontFamily = poppins,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 10.sp,
                    color = Gray700
                )
                )
            }

            Box(
                Modifier.width(80.dp),
                contentAlignment = Alignment.Center
            ){
                Text(category!!, style = TextStyle(
                    fontFamily = poppins,
                    fontWeight = FontWeight.Light,
                    fontSize = 10.sp,
                    color = Gray700,
                ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Star(20, true)
        }
    }

}
