package com.example.blume_mobile.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.blume_mobile.ui.components.cards.CategoryCard
import com.example.blume_mobile.ui.components.searchbar.SearchBar
import com.example.blume_mobile.ui.components.titles.TitleBlume
import com.example.blume_mobile.ui.states.SearchScreenUiState
import com.example.blume_mobile.ui.theme.Gray100
import com.example.blume_mobile.ui.theme.Green50
import com.example.blume_mobile.ui.theme.Violet300
import com.example.blume_mobile.ui.theme.Yellow50
import com.example.blume_mobile.ui.viewModels.SearchScreenViewModel

@Composable
fun SearchScreen(
    viewModel: SearchScreenViewModel
){
    val state by viewModel.uiState.collectAsState()
    SearchScreen(state = state)
}


@Composable
fun SearchScreen(
    state: SearchScreenUiState
){
    val searchedText = state.searchedText

    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Gray100)
            .padding(top = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(30.dp),
    ) {

        Row(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.1f),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TitleBlume()
        }

        SearchBar(value = searchedText, handleChange = state.onSearch)
        
        LazyHorizontalGrid(
            rows = GridCells.Fixed(3),
            contentPadding = PaddingValues(horizontal = 30.dp),
            horizontalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            items(12){ index ->
                if(index % 3 == 0){
                    CategoryCard(title = index.toString(), color = Violet300)
                }else if(index % 3 == 1){
                    CategoryCard(title = index.toString(), color = Green50)
                }else {
                    CategoryCard(title = index.toString(), color = Yellow50)
                }

            }

        }
    }
}