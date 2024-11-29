package com.example.blume_mobile.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.blume_mobile.R
import com.example.blume_mobile.data.sampleCategories
import com.example.blume_mobile.models.establishment.Establishment
import com.example.blume_mobile.ui.components.cards.BestRated
import com.example.blume_mobile.ui.components.tab.Tab
import com.example.blume_mobile.ui.components.titles.TitleBlume
import com.example.blume_mobile.ui.states.EstablishmentScreenUiState
import com.example.blume_mobile.ui.theme.Gray700
import com.example.blume_mobile.ui.theme.Violet500
import com.example.blume_mobile.ui.theme.poppins
import com.example.blume_mobile.ui.viewModels.EstablishmentDetailsViewModel

@Composable
fun EstablishmentDetails(establishment: Establishment, viewModel: EstablishmentDetailsViewModel) {
    val state by viewModel.uiState.collectAsState()
    Log.i("estab details", "${state.filtered}")


    Column(
        Modifier
            .fillMaxSize(),
        Arrangement.Center,
        Alignment.CenterHorizontally
    ) {
        Column(
            Modifier
                .fillMaxWidth(0.92f)
                .fillMaxHeight(0.98f)
                .padding(top = 6.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(38.dp)
                        .clip(CircleShape)
                        .background(Violet500), contentAlignment = Alignment.Center
                ) {
                    Image(
                        modifier = Modifier,
                        painter = painterResource(
                            id = R.drawable.arrow
                        ),
                        contentDescription = "Retornar página"
                    )
                }
                Spacer(modifier = Modifier.width(77.dp))
                TitleBlume()
            }

            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
                    .height(100.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Row(
                    Modifier
                        .fillMaxWidth(0.9f)
                        .fillMaxHeight()
                ) {
                    if (!establishment.imgUrl.isNullOrEmpty()) {
                        AsyncImage(
                            modifier = Modifier
                                .size(100.dp)
                                .clip(CircleShape),
                            model = establishment.imgUrl,
                            contentDescription = "Imagem de perfil do estabelecimento",
                            placeholder = painterResource(R.drawable.photo_placeholder),
                            contentScale = ContentScale.Crop,

                            )
                    } else {
                        Image(
                            modifier = Modifier
                                .size(100.dp)
                                .clip(CircleShape),
                            painter = painterResource(id = R.drawable.photo_placeholder),
                            contentDescription = "Imagem padrão quando não há imagem"
                        )
                    }

                    Column(
                        Modifier
                            .fillMaxHeight()
                            .fillMaxWidth()
                            .padding(start = 20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = establishment.name, style = TextStyle(
                                fontSize = 20.sp,
                                fontFamily = poppins,
                                fontWeight = FontWeight.W700,
                                color = Gray700,
                                textAlign = TextAlign.Center
                            )
                        )
                    }
                }


            }

            Row(
                Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Tab("Serviços", categorySelected = state.filtered, onClick = state.onClickFilter)
                Tab("Produtos", categorySelected = state.filtered, onClick = state.onClickFilter)
                Tab(
                    "Funcionários",
                    categorySelected = state.filtered,
                    onClick = state.onClickFilter
                )
                Tab("Sobre", categorySelected = state.filtered, onClick = state.onClickFilter)
            }
            if (state.filtered == "Produtos") {
                viewModel.getAllProducts(establishment.id)
                Log.i("estab details", "products: ${state.products}")
                if (state.products.isNotEmpty()) {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        contentPadding = PaddingValues(vertical = 10.dp),
                        modifier = Modifier.padding(bottom = 20.dp, start = 20.dp, end = 20.dp)
                    ) {
                        state.products.forEachIndexed { index, p ->

                            item(span = { GridItemSpan(1) }) {
                                BestRated(
                                    name = p.name,
                                    categories = sampleCategories,
                                    profile = p.imgUrl!!
                                )
                            }

                        }

                    }

                }
            } else if (state.filtered == "Serviços") {
                viewModel.getAllServices(establishment.id)

                Log.i("estab details", "products: ${state.services}")
                if (state.services.isNotEmpty()) {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        contentPadding = PaddingValues(vertical = 10.dp),
                        modifier = Modifier.padding(bottom = 20.dp, start = 20.dp, end = 20.dp)
                    ) {
                        state.services.forEachIndexed { index, s ->

                            item(span = { GridItemSpan(1) }) {
                                BestRated(
                                    name = s.specification,
                                    categories = sampleCategories,
                                    profile = s.imgUrl!!
                                )
                            }

                        }

                    }

                }
            } else if (state.filtered == "Funcionários") {
                viewModel.getAllEmployees(establishment.id)
                Log.i("estab details", "products: ${state.employees}")
                if (state.employees.isNotEmpty()) {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                        contentPadding = PaddingValues(vertical = 10.dp),
                        modifier = Modifier.padding(bottom = 20.dp, start = 20.dp, end = 20.dp)
                    ) {
                        state.employees.forEachIndexed { index, e ->

                            item(span = { GridItemSpan(1) }) {
                                BestRated(
                                    name = e.name,
                                    categories = sampleCategories,
                                    profile = e.imgUrl
                                )
                            }

                        }

                    }

                }
            } else if (state.filtered == "Sobre") {
                viewModel.getAllEmployees(establishment.id)
                if (state.employees.isNotEmpty()) {

                    Column(
                        Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                    ) {
                        Column(
                            Modifier
                                .fillMaxHeight(0.5f),
                            verticalArrangement = Arrangement.spacedBy(20.dp),
                        ) {
                            Text(
                                "Descrição: ", style = TextStyle(
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.W700,
                                    color = Gray700,
                                )
                            )

                            Text(
                                establishment.description, style = TextStyle(
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.W400,
                                    color = Gray700,
                                )
                            )
                        }

                        Row(
                            Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,

                        ) {
                            if (!establishment.imgUrl.isNullOrEmpty()) {
                                AsyncImage(
                                    modifier = Modifier
                                        .size(100.dp)
                                        .clip(CircleShape),
                                    model = state.employees[0].imgUrl,
                                    contentDescription = "Imagem de perfil do estabelecimento",
                                    placeholder = painterResource(R.drawable.photo_placeholder),
                                    contentScale = ContentScale.Crop,

                                    )
                            } else {
                                Image(
                                    modifier = Modifier
                                        .size(100.dp)
                                        .clip(CircleShape),
                                    painter = painterResource(id = R.drawable.photo_placeholder),
                                    contentDescription = "Imagem padrão quando não há imagem"
                                )
                            }

                            Column(
                                Modifier
                                    .fillMaxHeight()
                                    .fillMaxWidth()
                                    .padding(start = 20.dp),
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = state.employees[0].name, style = TextStyle(
                                        fontSize = 20.sp,
                                        fontFamily = poppins,
                                        fontWeight = FontWeight.W700,
                                        color = Gray700,
                                        textAlign = TextAlign.Center
                                    )
                                )

                                Row(
                                    Modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                                ) {

                                    Image(
                                        modifier = Modifier,
                                        painter = painterResource(id = R.drawable.whatsapp_vector),
                                        contentDescription = "Icone de whatsapp"
                                    )


                                    Text(
                                        text = "(${state.employees[0].phone.areaCode}) ${state.employees[0].phone.number}",
                                        style = TextStyle(
                                            fontSize = 14.sp,
                                            fontFamily = poppins,
                                            fontWeight = FontWeight.W700,
                                            color = Gray700,
                                            textAlign = TextAlign.Center
                                        )

                                    )
                                }
                            }
                        }
                    }
                }
            }
        }


    }
}