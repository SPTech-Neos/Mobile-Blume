package com.example.blume_mobile.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.blume_mobile.R
import com.example.blume_mobile.ui.components.titles.TitleBlume
import com.example.blume_mobile.ui.states.ProfileScreenUiState
import com.example.blume_mobile.ui.theme.Gray100
import com.example.blume_mobile.ui.theme.Gray700
import com.example.blume_mobile.ui.theme.Violet300
import com.example.blume_mobile.ui.theme.Violet50
import com.example.blume_mobile.ui.theme.Violet500
import com.example.blume_mobile.ui.theme.poppins
import com.example.blume_mobile.ui.viewModels.ProfileScreenViewModel

@Composable
fun Profile(viewModel: ProfileScreenViewModel = ProfileScreenViewModel()) {
    val state by viewModel.uiState.collectAsState()
    Profile(state = state)
}

@Composable
fun Profile(state: ProfileScreenUiState) {
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Gray100)
                .padding(top = 50.dp),
            verticalArrangement = Arrangement.spacedBy(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.15f),
                verticalArrangement = Arrangement.spacedBy(25.dp, alignment = Alignment.Top),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TitleBlume()
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .background(Violet50),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(20.dp, Alignment.CenterHorizontally)
            ) {
                Image(
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape),
                    painter = painterResource(id = R.drawable.photo_placeholder),
                    contentDescription = "Imagem padrão quando não há escolha do usuário"
                )

                Column(
                    Modifier
                        .fillMaxWidth(0.65f)
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Nome", style = TextStyle(
                            fontFamily = poppins,
                            fontWeight = FontWeight.W700,
                            fontSize = 20.sp,
                            color = Gray700
                        )
                    )

                    Text(
                        text = "(11) 93335-7627", style = TextStyle(
                            fontFamily = poppins,
                            fontWeight = FontWeight.W700,
                            fontSize = 16.sp,
                            color = Gray700
                        )
                    )
                }

            }
            Surface(
                shape = RoundedCornerShape(8.dp),
                shadowElevation = 3.dp
            ) {
                Column(
                    Modifier
                        .fillMaxWidth(0.8f)
                        .height(500.dp)
                        .background(Gray100)
                        .padding(top = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Dados pessoais: ", style = TextStyle(
                            fontWeight = FontWeight.W700,
                            fontSize = 20.sp,
                            fontFamily = poppins,
                            color = Violet500,
                            textAlign = TextAlign.Center
                        )
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.4f)
                            .padding(start = 20.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Text(
                            text = "Nome: ", style = TextStyle(
                                color = Violet300,
                                fontSize = 15.sp,
                                fontFamily = poppins,
                                fontWeight = FontWeight.W700,
                            )
                        )

                        Text(
                            text = "Kevin Rodrigues da Silva ", style = TextStyle(
                                color = Gray700,
                                fontSize = 12.sp,
                                fontFamily = poppins,
                                fontWeight = FontWeight.W700,
                            )
                        )

                        Text(
                            text = "Telefone: ", style = TextStyle(
                                color = Violet300,
                                fontSize = 15.sp,
                                fontFamily = poppins,
                                fontWeight = FontWeight.W700,
                            )
                        )

                        Text(
                            text = "11933357637", style = TextStyle(
                                color = Gray700,
                                fontSize = 12.sp,
                                fontFamily = poppins,
                                fontWeight = FontWeight.W700,
                            )
                        )

                        Text(
                            text = "Email: ", style = TextStyle(
                                color = Violet300,
                                fontSize = 15.sp,
                                fontFamily = poppins,
                                fontWeight = FontWeight.W700,
                            )
                        )

                        Text(
                            text = "kevin.rsilva07@gmail.com", style = TextStyle(
                                color = Gray700,
                                fontSize = 12.sp,
                                fontFamily = poppins,
                                fontWeight = FontWeight.W700,
                            )
                        )
                    }
                    Text(
                        text = "Dados de endereço: ", style = TextStyle(
                            fontWeight = FontWeight.W700,
                            fontSize = 20.sp,
                            fontFamily = poppins,
                            color = Violet500,
                            textAlign = TextAlign.Center
                        )
                    )

                    Column(
                        Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(start = 20.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Text(
                            text = "CEP: ", style = TextStyle(
                                color = Violet300,
                                fontSize = 15.sp,
                                fontFamily = poppins,
                                fontWeight = FontWeight.W700,
                            )
                        )

                        Text(
                            text = "08474-230 ", style = TextStyle(
                                color = Gray700,
                                fontSize = 12.sp,
                                fontFamily = poppins,
                                fontWeight = FontWeight.W700,
                            )
                        )

                        Text(
                            text = "Endereço: ", style = TextStyle(
                                color = Violet300,
                                fontSize = 15.sp,
                                fontFamily = poppins,
                                fontWeight = FontWeight.W700,
                            )
                        )

                        Text(
                            text = "Rua Coração de Maçã, 211", style = TextStyle(
                                color = Gray700,
                                fontSize = 12.sp,
                                fontFamily = poppins,
                                fontWeight = FontWeight.W700,
                            )
                        )

                        Text(
                            text = "Complemento: ", style = TextStyle(
                                color = Violet300,
                                fontSize = 15.sp,
                                fontFamily = poppins,
                                fontWeight = FontWeight.W700,
                            )
                        )

                        Text(
                            text = "Sem complemento", style = TextStyle(
                                color = Gray700,
                                fontSize = 12.sp,
                                fontFamily = poppins,
                                fontWeight = FontWeight.W700,
                            )
                        )

                        Text(
                            text = "Estado: ", style = TextStyle(
                                color = Violet300,
                                fontSize = 15.sp,
                                fontFamily = poppins,
                                fontWeight = FontWeight.W700,
                            )
                        )

                        Text(
                            text = "São Paulo   ", style = TextStyle(
                                color = Gray700,
                                fontSize = 12.sp,
                                fontFamily = poppins,
                                fontWeight = FontWeight.W700,
                            )
                        )
                    }

                }
            }

            Surface(
                shape = RoundedCornerShape(8.dp),
                shadowElevation = 3.dp
            ) {
                Column(
                    Modifier
                        .fillMaxWidth(0.8f)
                        .height(200.dp)
                        .background(Gray100)
                        .padding(top = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Últimos pedidos: ", style = TextStyle(
                            fontWeight = FontWeight.W700,
                            fontSize = 20.sp,
                            fontFamily = poppins,
                            color = Violet500,
                            textAlign = TextAlign.Center
                        )
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(start = 20.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Row(
                            Modifier.fillMaxWidth(0.9f),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ){
                            Text(
                                text = "PEDIDO 123456XYZ", style = TextStyle(
                                    color = Violet300,
                                    fontSize = 15.sp,
                                    fontFamily = poppins,
                                    fontWeight = FontWeight.W700,
                                )
                            )

                            Text(
                                text = "A Pagar", style = TextStyle(
                                    color = Gray700,
                                    fontSize = 12.sp,
                                    fontFamily = poppins,
                                    fontWeight = FontWeight.W700,
                                )
                            )
                        }

                        Row(
                            Modifier.fillMaxWidth(0.9f),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ){
                            Text(
                                text = "PEDIDO 123456XYZ", style = TextStyle(
                                    color = Violet300,
                                    fontSize = 15.sp,
                                    fontFamily = poppins,
                                    fontWeight = FontWeight.W700,
                                )
                            )

                            Text(
                                text = "Em andamento", style = TextStyle(
                                    color = Gray700,
                                    fontSize = 12.sp,
                                    fontFamily = poppins,
                                    fontWeight = FontWeight.W700,
                                )
                            )
                        }


                        Row(
                            Modifier.fillMaxWidth(0.9f),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ){
                            Text(
                                text = "PEDIDO 123456XYZ", style = TextStyle(
                                    color = Violet300,
                                    fontSize = 15.sp,
                                    fontFamily = poppins,
                                    fontWeight = FontWeight.W700,
                                )
                            )

                            Text(
                                text = "Concluido", style = TextStyle(
                                    color = Gray700,
                                    fontSize = 12.sp,
                                    fontFamily = poppins,
                                    fontWeight = FontWeight.W700,
                                )
                            )
                        }


                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
    }
}
