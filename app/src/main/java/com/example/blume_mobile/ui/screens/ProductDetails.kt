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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.blume_mobile.R
import com.example.blume_mobile.models.Aditum.AditumProduct
import com.example.blume_mobile.models.Aditum.PaymentRequest
import com.example.blume_mobile.models.di.UserSession
import com.example.blume_mobile.models.order.OrderRequest
import com.example.blume_mobile.models.product.Product
import com.example.blume_mobile.ui.components.buttons.CustomButton
import com.example.blume_mobile.ui.components.titles.TitleBlume
import com.example.blume_mobile.ui.theme.Gray100
import com.example.blume_mobile.ui.theme.Gray500
import com.example.blume_mobile.ui.theme.Gray700
import com.example.blume_mobile.ui.theme.Violet50
import com.example.blume_mobile.ui.theme.Violet500
import com.example.blume_mobile.ui.theme.poppins
import com.example.blume_mobile.ui.viewModels.ProductDetailsViewModel
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

@Composable
fun ProductDetails(
    product: Product,
    viewModel: ProductDetailsViewModel,
    navController: NavController,
    user: UserSession
){
    val uriHandler = LocalUriHandler.current
    val state by viewModel.uiState.collectAsState()
    var showModal by remember {
        mutableStateOf(false)
    }

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
                        Modifier.fillMaxWidth()
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
                        Modifier.fillMaxWidth()
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
                        Modifier.fillMaxWidth()
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
                        Spacer(modifier = Modifier.width(20.dp))
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
                            val currentInstant: Instant = Instant.now()
                            val millis: Long = currentInstant.toEpochMilli()
                            val date = Instant.ofEpochMilli(millis).atOffset(ZoneOffset.UTC).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                            val formatter = DateTimeFormatter.ofPattern("HH:mm:ss")
                            val time = LocalDateTime.now().format(formatter)
                            val dateTime = date + "T" + time
                            product.id?.let {
                                viewModel.registerOrder(
                                    OrderRequest(
                                        fkStatus = 1,
                                        dateTime = dateTime,
                                        fkClient = user.id
                                    ),
                                    quatity = 1,
                                    productId = it,
                                )
                            }

                            val list = listOf(product.aditumId)

                            viewModel.getAditumToken(PaymentRequest(
                                products = list,
                                maxInstallmentNumber = 1,
                                emailNotification = user.email,
                                phoneNotification = "11933357637",
                                supportMultipleTransactions = true
                            ))
                            showModal = true
//                            navController.navigate("feed")
                        }
                    }

                }

            }
        }
    }

    if (showModal) {
        if (state.aditumUri.isNotEmpty()) {
            Column(
                Modifier
                    .fillMaxSize()
                    .background(Gray500.copy(alpha = 0.5f)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Surface(
                    shape = RoundedCornerShape(8.dp),
                    shadowElevation = 3.dp
                ) {
                    Column(
                        Modifier
                            .size(width = 300.dp, height = 350.dp)
                            .background(Gray100)
                            .padding(20.dp),
                        verticalArrangement = Arrangement.spacedBy(30.dp, Alignment.CenterVertically),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text("Clique no botão abaixo para acessar seu link de pagamento pelo produto!", style = TextStyle(
                            fontWeight = FontWeight.W200,
                            textAlign = TextAlign.Center,
                            color = Gray700,
                            fontSize = 15.sp,
                            fontFamily = poppins,
                        ))
                        CustomButton(text = "Acessar", width = 280) {
                            uriHandler.openUri(state.aditumUri)
                        }
                    }
                }
            }
        }
    }
}

