package com.example.blume_mobile.ui.screens

import android.app.appsearch.SearchResult
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.example.blume_mobile.R
import com.example.blume_mobile.data.sampleCategories
import com.example.blume_mobile.data.sampleEstablishments
import com.example.blume_mobile.ui.components.titles.TitleBlume
import com.example.blume_mobile.ui.components.banner.Banner
import com.example.blume_mobile.ui.components.cards.BestRated
import com.example.blume_mobile.ui.components.cards.CategoryCard
import com.example.blume_mobile.ui.components.cards.RatedCard
import com.example.blume_mobile.ui.components.cards.EstablishmentCard
import com.example.blume_mobile.ui.components.searchbar.SearchBar
import com.example.blume_mobile.ui.states.FeedScreenUiState
import com.example.blume_mobile.ui.theme.Gray100
import com.example.blume_mobile.ui.theme.Gray700
import com.example.blume_mobile.ui.theme.Green50
import com.example.blume_mobile.ui.theme.Violet50
import com.example.blume_mobile.ui.theme.Violet500
import com.example.blume_mobile.ui.theme.Yellow50
import com.example.blume_mobile.ui.theme.poppins
import com.example.blume_mobile.ui.viewModels.FeedScreenViewModel


@Composable
fun FeedScreen(viewModel: FeedScreenViewModel) {
    val state by viewModel.uiState.collectAsState()

    FeedScreen(state = state)
}

@Composable
fun FeedScreen(state: FeedScreenUiState) {
    val establishments = state.establishments
    val products = state.bestProducts
    val services = state.bestServices
    val bestEstablishment = state.bestEstablishments
    val searchedText = state.searchedText
    val searchedEstablishment = state.searchedBestEstablishments
    val sampleEstabs = sampleEstablishments

    Log.i("teste api", "resultado na tela $establishments")
    Log.i("teste api", "resultado sampels na tela $sampleEstabs")
    Log.i("teste api", "resultado na tela $services")
    Log.i("teste api", "resultado na tela $products")

    LazyColumn(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.95f)
            .background(Gray100),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(30.dp),
        contentPadding = PaddingValues(top = 50.dp, bottom = 100.dp)
    ) {
        item {
            Row(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.1f),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TitleBlume()
            }
        }

        item {
            SearchBar(value = searchedText, handleChange = state.onSearch)
        }
        if (searchedText.isBlank()) {


            item {
                Banner(
                    "Teste",
                    painterResource(id = R.drawable.messy_bun_cuate),
                    Violet500,
                    "andamento"
                )
            }

            item {
                Column(
                    Modifier
                        .fillMaxWidth(0.9f)
                        .fillMaxHeight(0.28f),
                    verticalArrangement = Arrangement.spacedBy(30.dp)
                ) {
                    Text(
                        "Categorias populares: ",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontFamily = poppins,
                            color = Gray700
                        )
                    )

                    Row(
                        Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.7f),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        CategoryCard("Cabelos", Violet50)
                        CategoryCard("Unhas", Green50)
                        CategoryCard("Barba", Yellow50)
                    }
                }
            }

            item {
                Column(
                    Modifier
                        .fillMaxWidth(0.9f)
                        .fillMaxHeight(0.4f),
                    verticalArrangement = Arrangement.spacedBy(30.dp)
                ) {
                    Text(
                        "Lugares bem avaliados: ",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontFamily = poppins,
                            color = Gray700
                        )
                    )

                    LazyRow(
                        Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.7f),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        contentPadding = PaddingValues(horizontal = 2.dp)
                    ) {
                        if (bestEstablishment.isNotEmpty()) {
                            items(bestEstablishment) { e ->
                                RatedCard(
                                    title = e.name,
                                    category = e.description,
                                    profile = e.imgUrl
                                )
                            }
                        }
                    }
                }
            }

            item {
                Column(
                    Modifier
                        .fillMaxWidth(0.9f)
                        .fillMaxHeight(0.4f),
                    verticalArrangement = Arrangement.spacedBy(30.dp)
                ) {
                    Text(
                        "Produtos bem avaliados: ",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontFamily = poppins,
                            color = Gray700
                        )
                    )

                    LazyRow(
                        Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.7f),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        contentPadding = PaddingValues(horizontal = 2.dp)
                    ) {
                        if (products.isNotEmpty()) {
                            items(products) { p ->
                                RatedCard(title = p.name, category = p.brand, profile = p.imgUrl)
                            }
                        }
                    }
                }
            }

            item {
                Column(
                    Modifier
                        .fillMaxWidth(0.9f)
                        .fillMaxHeight(0.4f),
                    verticalArrangement = Arrangement.spacedBy(30.dp)
                ) {
                    Text(
                        "Serviços bem avaliados: ",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontFamily = poppins,
                            color = Gray700
                        )
                    )

                    LazyRow(
                        Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.7f),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                        contentPadding = PaddingValues(horizontal = 2.dp)
                    ) {
                        if (services.isNotEmpty()) {
                            items(services) { s ->
                                RatedCard(
                                    title = s.specification,
                                    category = s.serviceType.serviceCategory.name,
                                    profile = s.imgUrl
                                )
                            }
                        }
                    }
                }
            }

            item {
                Column(
                    Modifier
                        .fillMaxWidth(0.9f)
                        .fillMaxHeight(),
                ) {
                    Text(
                        "Estabelecimentos: ",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontFamily = poppins,
                            color = Gray700
                        )
                    )

                }
            }

            if (establishments.isNotEmpty()) {
                items(establishments) { e ->
                    EstablishmentCard(e.name, e.description, e.media!!, e.imgUrl)
                }
            }
        } else {
                if(searchedEstablishment.isNotEmpty()){
                    items(searchedEstablishment) { e ->
                        BestRated(name = e.name, categories = sampleCategories, profile = e.imgUrl!!)
                    }
                }
        }
    }
}

@Preview()
@Composable
fun FeedPreview() {
    FeedScreen(FeedScreenUiState())
}