package com.example.blume_mobile.ui.screens

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.blume_mobile.data.sampleCategories
import com.example.blume_mobile.models.Establishment
import com.example.blume_mobile.models.Product
import com.example.blume_mobile.models.Service
import com.example.blume_mobile.ui.badge.CategoryBadge
import com.example.blume_mobile.ui.components.cards.BestRated
import com.example.blume_mobile.ui.components.searchbar.SearchBar
import com.example.blume_mobile.ui.components.titles.TitleBlume
import com.example.blume_mobile.ui.states.FeedScreenUiState
import com.example.blume_mobile.ui.theme.Gray100
import com.example.blume_mobile.ui.theme.Gray700
import com.example.blume_mobile.ui.theme.poppins

@Composable
fun SearchResultEstablishments(
    establishments: List<Establishment> = emptyList(),

) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(vertical = 10.dp),
        modifier = Modifier.padding(bottom = 70.dp, start = 20.dp, end = 20.dp)
    ) {
        establishments.forEachIndexed { index, e ->
            if (index == 0) {
                item(span = { GridItemSpan(maxLineSpan) }) {
                    Text(
                        text = "MELHOR RESULTADO: ",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontFamily = poppins,
                            fontSize = 16.sp,
                            color = Gray700,
                            textAlign = TextAlign.Center
                        )
                    )
                }

                item(span = { GridItemSpan(maxLineSpan) }) {
                    Box(
                        Modifier
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        BestRated(
                            name = e.name,
                            categories = sampleCategories,
                            profile = e.imgUrl!!
                        )
                    }

                }

                item(span = { GridItemSpan(maxLineSpan) }) {
                    Text(
                        text = "OUTROS RESULTADOS: ",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontFamily = poppins,
                            fontSize = 16.sp,
                            color = Gray700,
                            textAlign = TextAlign.Center
                        )
                    )
                }
            } else {
                item(span = { GridItemSpan(1) }) {
                    BestRated(
                        name = e.name,
                        categories = sampleCategories,
                        profile = e.imgUrl!!
                    )
                }
            }


        }
        item { Spacer(modifier = Modifier.height(20.dp)) }

    }
}

@Composable
fun SearchResultServices(
    services: List<Service> = emptyList(),
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(vertical = 10.dp),
        modifier = Modifier.padding(bottom = 70.dp, start = 20.dp, end = 20.dp)
    ) {
        services.forEachIndexed { index, s ->
            if (index == 0) {
                item(span = { GridItemSpan(maxLineSpan) }) {
                    Text(
                        text = "MELHOR RESULTADO: ",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontFamily = poppins,
                            fontSize = 16.sp,
                            color = Gray700,
                            textAlign = TextAlign.Center
                        )
                    )
                }

                item(span = { GridItemSpan(maxLineSpan) }) {
                    Box(
                        Modifier
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        BestRated(
                            name = s.specification,
                            categories = sampleCategories,
                            profile = s.imgUrl!!
                        )
                    }

                }

                item(span = { GridItemSpan(maxLineSpan) }) {
                    Text(
                        text = "OUTROS RESULTADOS: ",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontFamily = poppins,
                            fontSize = 16.sp,
                            color = Gray700,
                            textAlign = TextAlign.Center
                        )
                    )
                }
            } else {
                item(span = { GridItemSpan(1) }) {
                    BestRated(
                        name = s.specification,
                        categories = sampleCategories,
                        profile = s.imgUrl!!
                    )
                }
            }


        }
        item { Spacer(modifier = Modifier.height(20.dp)) }

    }
}