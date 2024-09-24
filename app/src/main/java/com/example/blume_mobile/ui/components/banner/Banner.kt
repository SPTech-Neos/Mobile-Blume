package com.example.blume_mobile.ui.components.banner

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.blume_mobile.R
import com.example.blume_mobile.ui.theme.Violet50
import com.example.blume_mobile.ui.theme.Violet500
import com.example.blume_mobile.ui.theme.poppins

@Composable
fun Banner(
    title: String,
    icon: Painter,
    color: Color,
    type: String
){
    Row(
        Modifier
            .fillMaxWidth(0.9f)
            .fillMaxHeight(0.15f)
            .clip(RoundedCornerShape(10))
            .background(color)
        ,
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ){
        Column(
            Modifier
                .fillMaxWidth(0.58f)
                .fillMaxHeight(0.8f)
            ,
            verticalArrangement = Arrangement.Top
        ){
            Spacer(modifier = Modifier.height(22.dp))
            Text("PEDIDO EM ANDAMENTO!", style = TextStyle(
                textAlign = TextAlign.Center,
                color = Color(250, 250, 250),
                fontWeight = FontWeight.Bold,
                fontFamily = poppins
            ))
            Spacer(modifier = Modifier.height(8.dp))

            if(type == "andamento"){
                Button(
                    modifier = Modifier.size(
                        width = 130.dp,
                        height = 30.dp
                    ),
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(Violet50),
                    shape = RoundedCornerShape(12)
                ) {
                    Text("VER PEDIDO", style = TextStyle(
                        color = Violet500,
                        fontFamily = poppins,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 11.sp
                    ))
                }
            }

        }


        Image(
            contentDescription = "Cliente",
            painter = icon,
            modifier = Modifier.size(95.dp)
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun BannerPrev(){
    Banner(
        "Teste",
        painterResource(id = R.drawable.messy_bun_cuate),
        Violet500,
        "andamento"
    )
}