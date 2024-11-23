package com.example.blume_mobile.ui.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.blume_mobile.R
import com.example.blume_mobile.models.establishment.Establishment
import com.example.blume_mobile.models.product.Product
import com.example.blume_mobile.models.service.Service
import com.example.blume_mobile.ui.components.Star
import com.example.blume_mobile.ui.theme.Gray700
import com.example.blume_mobile.ui.theme.poppins
import com.google.gson.Gson
import java.math.BigDecimal

@Composable
fun ServiceRatedCard(
    avaliation: Double? = null,
    service: Service,
    navController: NavController
) {
    val avaliationInt = avaliation?.toInt() ?: 0
    val serviceJson = Gson().toJson(service)
    Surface(
        modifier = Modifier.clickable(true){
            navController.navigate("service_details?service=${serviceJson}")
        },
        shape = RoundedCornerShape(8.dp),
        shadowElevation = 3.dp
    ) {
        Row(
            Modifier
                .size(
                    width = 153.dp,
                    height = 65.dp
                )
                .background(Color(250, 250, 250))

        ) {
            Column(
                Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.45f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                if(service.imgUrl != null){
                    AsyncImage(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape),
                        model = service.imgUrl,
                        contentDescription = "Imagem de perfil do estabelecimento",
                        placeholder = painterResource(R.drawable.photo_placeholder),
                        contentScale = ContentScale.Crop,
                    )
                }else{
                    Image(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape),
                        painter = painterResource(id = R.drawable.photo_placeholder),
                        contentDescription = "Imagem padrão quando não há escolha do usuário"
                    )
                }
            }

            Column(
                Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .padding(end = 5.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    service.specification, style = TextStyle(
                        fontFamily = poppins,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 10.sp,
                        color = Gray700

                    )
                )
                if (avaliation == null) {
                    Text(
                        service.serviceType.serviceCategory.name, style = TextStyle(
                            fontFamily = poppins,
                            fontWeight = FontWeight.Light,
                            fontSize = 10.sp,
                            color = Gray700
                        ),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                } else {
                    LazyRow(

                    ) {
                        items(5){ index ->
                            if(index < avaliationInt){
                                Star(10, true)
                            }else{
                                Star(10)
                            }
                        }

                    }
                }
            }

        }

    }
}

@Composable
fun ProductRatedCard(
    avaliation: Double? = null,
    navController: NavController,
    product: Product
) {
    val avaliationInt = avaliation?.toInt() ?: 0
    val productJson = Gson().toJson(product)

    Surface(
        modifier = Modifier.clickable(true){
            navController.navigate("product_details?product=${productJson}")
        },
        shape = RoundedCornerShape(8.dp),
        shadowElevation = 3.dp
    ) {
        Row(
            Modifier
                .size(
                    width = 153.dp,
                    height = 65.dp
                )
                .background(Color(250, 250, 250))

        ) {
            Column(
                Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.45f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                if(product.imgUrl != null){
                    AsyncImage(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape),
                        model = product.imgUrl,
                        contentDescription = "Imagem de perfil do estabelecimento",
                        placeholder = painterResource(R.drawable.photo_placeholder),
                        contentScale = ContentScale.Crop,
                    )
                }else{
                    Image(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape),
                        painter = painterResource(id = R.drawable.photo_placeholder),
                        contentDescription = "Imagem padrão quando não há escolha do usuário"
                    )
                }
            }

            Column(
                Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .padding(end = 5.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    product.name, style = TextStyle(
                        fontFamily = poppins,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 10.sp,
                        color = Gray700

                    )
                )
                if (avaliation == null) {
                    Text(
                        product.brand, style = TextStyle(
                            fontFamily = poppins,
                            fontWeight = FontWeight.Light,
                            fontSize = 10.sp,
                            color = Gray700
                        ),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                } else {
                    LazyRow(

                    ) {
                        items(5){ index ->
                            if(index < avaliationInt){
                                Star(10, true)
                            }else{
                                Star(10)
                            }
                        }

                    }
                }
            }

        }

    }
}

@Composable
fun EstablishmentRatedCard(
    avaliation: Double? = null,
    navController: NavController,
    establishment: Establishment
) {
    val avaliationInt = avaliation?.toInt() ?: 0
    val establishmentJson = Gson().toJson(establishment)

    Surface(
        modifier = Modifier.clickable(true){
            navController.navigate("establishment_details?establishment=${establishmentJson}")
        },
        shape = RoundedCornerShape(8.dp),
        shadowElevation = 3.dp
    ) {
        Row(
            Modifier
                .size(
                    width = 153.dp,
                    height = 65.dp
                )
                .background(Color(250, 250, 250))

        ) {
            Column(
                Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.45f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround
            ) {
                if(establishment.imgUrl != null){
                    AsyncImage(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape),
                        model = establishment.imgUrl,
                        contentDescription = "Imagem de perfil do estabelecimento",
                        placeholder = painterResource(R.drawable.photo_placeholder),
                        contentScale = ContentScale.Crop,
                    )
                }else{
                    Image(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape),
                        painter = painterResource(id = R.drawable.photo_placeholder),
                        contentDescription = "Imagem padrão quando não há escolha do usuário"
                    )
                }
            }

            Column(
                Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .padding(end = 5.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    establishment.name, style = TextStyle(
                        fontFamily = poppins,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 10.sp,
                        color = Gray700

                    )
                )
                if (avaliation == null) {
                    Text(
                        establishment.description, style = TextStyle(
                            fontFamily = poppins,
                            fontWeight = FontWeight.Light,
                            fontSize = 10.sp,
                            color = Gray700
                        ),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                } else {
                    LazyRow(

                    ) {
                        items(5){ index ->
                            if(index < avaliationInt){
                                Star(10, true)
                            }else{
                                Star(10)
                            }
                        }

                    }
                }
            }

        }

    }
}

