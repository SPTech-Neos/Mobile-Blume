package com.example.blume_mobile.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.blume_mobile.R
import com.example.blume_mobile.ui.components.titles.TitleBlume
import com.example.blume_mobile.ui.components.banner.Banner
import com.example.blume_mobile.ui.components.cards.CategoryCard
import com.example.blume_mobile.ui.components.cards.EntityCard
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
    val nomeEstab = state.establishments
    val text = state.searchedText

    Log.i("teste api", "resultado na tela $nomeEstab")

    LazyColumn(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.95f)
            .background(Gray100)
        ,
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
            SearchBar(value = text, handleChange = state.onSearch)
        }

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

                Row(
                    Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.7f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    if (nomeEstab.isNotEmpty()) {
                        EntityCard(nomeEstab[0].name, "Categoria")
                    }
                    EntityCard("Nome salão", "Categoria")
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

        items(2) {
            EstablishmentCard()
        }
    }
}

@Preview()
@Composable
fun FeedPreview() {
    FeedScreen(FeedScreenUiState())
}