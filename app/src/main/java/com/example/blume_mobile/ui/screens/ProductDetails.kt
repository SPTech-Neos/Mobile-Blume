package com.example.blume_mobile.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.blume_mobile.R
import com.example.blume_mobile.models.product.Product
import com.example.blume_mobile.ui.components.buttons.CustomButton
import com.example.blume_mobile.ui.components.titles.TitleBlume
import com.example.blume_mobile.ui.theme.Gray700
import com.example.blume_mobile.ui.theme.Violet50
import com.example.blume_mobile.ui.theme.Violet500
import com.example.blume_mobile.ui.theme.poppins

@Composable
fun ProductDetails(product: Product){
    Column(
        Modifier
            .fillMaxSize(),
        Arrangement.Center,
        Alignment.CenterHorizontally   ){
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
                    ,contentAlignment = Alignment.Center
                ){
                    Image(
                        modifier = Modifier,
                        painter = painterResource(id = R.drawable.arrow),
                        contentDescription = "Retornar página"
                    )
                }
                Spacer(modifier = Modifier.width(77.dp))
                TitleBlume()
            }

            Column(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(top = 50.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ){
                if(product.imgUrl != null){
                    AsyncImage(
                        modifier = Modifier
                            .size(
                                width = 300.dp,
                                height = 200.dp
                            )
                            .clip(RoundedCornerShape(10.dp)),
                        model = product.imgUrl,
                        contentDescription = "Imagem de perfil do estabelecimento",
                        placeholder = painterResource(R.drawable.photo_placeholder),
                        contentScale = ContentScale.Crop,
                    )
                }else{
                    Image(
                        modifier = Modifier
                            .size(
                                width = 200.dp,
                                height = 400.dp
                            )
                            .clip(CircleShape),
                        painter = painterResource(id = R.drawable.photo_placeholder),
                        contentDescription = "Imagem padrão quando não há escolha do usuário"
                    )
                }

                Column(
                    Modifier.fillMaxWidth(0.8f),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(text = product.name, style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = poppins,
                        fontWeight = FontWeight.W700,
                        color = Gray700,
                        textAlign = TextAlign.Center
                    ))

                    Text(text = "R$${product.value}", style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = poppins,
                        fontWeight = FontWeight.W400,
                        color = Gray700,
                        textAlign = TextAlign.Center
                    ))
                }

                Column(
                    Modifier.fillMaxWidth(0.8f),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(text = "Informações do produto: ", style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = poppins,
                        fontWeight = FontWeight.W700,
                        color = Gray700,
                        textAlign = TextAlign.Center
                    ))

                    Row(
                        Modifier.fillMaxWidth(0.8f)
                    ){
                        Text(text = "Marca: ", style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = poppins,
                            fontWeight = FontWeight.W700,
                            color = Gray700,
                            textAlign = TextAlign.Center
                        ))

                        Text(text = product.brand, style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = poppins,
                            fontWeight = FontWeight.W400,
                            color = Gray700,
                            textAlign = TextAlign.Center
                        ))
                    }

                    Row(
                        Modifier.fillMaxWidth(0.8f)
                    ){
                        Text(text = "Categoria: ", style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = poppins,
                            fontWeight = FontWeight.W700,
                            color = Gray700,
                            textAlign = TextAlign.Center
                        ))

                        Text(text = product.type.specification, style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = poppins,
                            fontWeight = FontWeight.W400,
                            color = Gray700,
                            textAlign = TextAlign.Center
                        ))
                    }

                    Row(
                        Modifier.fillMaxWidth(0.8f)
                    ){
                        Text(text = "Vendido por: ", style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = poppins,
                            fontWeight = FontWeight.W700,
                            color = Gray700,
                            textAlign = TextAlign.Center
                        ))

                        Text(text = product.name, style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = poppins,
                            fontWeight = FontWeight.W400,
                            color = Gray700,
                            textAlign = TextAlign.Center
                        ))
                    }

                }

                Surface(
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Row(
                        Modifier
                            .fillMaxWidth(0.9f)
                            .height(80.dp)
                            .background(Violet50)
                            .padding(horizontal = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Column(
                            Modifier.fillMaxWidth(0.5f),
                            verticalArrangement = Arrangement.spacedBy(10.dp),
                            horizontalAlignment = Alignment.Start
                        ) {
                            Text(
                                text = product.name, style = TextStyle(
                                    fontSize = 14.sp,
                                    fontFamily = poppins,
                                    fontWeight = FontWeight.W700,
                                    color = Gray700,
                                    textAlign = TextAlign.Center
                                )
                            )

                            Text(
                                text = "R$${product.value}", style = TextStyle(
                                    fontSize = 12.sp,
                                    fontFamily = poppins,
                                    fontWeight = FontWeight.W400,
                                    color = Gray700,
                                    textAlign = TextAlign.Center
                                )
                            )
                        }

                        CustomButton("Comprar", 300) {

                        }
                    }

                }

            }
        }
    }
}

