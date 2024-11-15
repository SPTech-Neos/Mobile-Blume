package com.example.blume_mobile.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.blume_mobile.ui.components.titles.Title
import com.example.blume_mobile.ui.components.titles.TitleBlume
import com.example.blume_mobile.ui.states.OrderScreenUiState
import com.example.blume_mobile.ui.theme.Gray100
import com.example.blume_mobile.ui.theme.Gray700
import com.example.blume_mobile.ui.theme.poppins
import com.example.blume_mobile.ui.viewModels.OrderScreenViewModel

@Composable
fun OrderScreen(viewModel: OrderScreenViewModel) {
    val state by viewModel.uiState.collectAsState()
    OrderScreen(state = state)
}

@Composable
fun OrderScreen(state: OrderScreenUiState) {
    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Gray100),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f),
            verticalArrangement = Arrangement.spacedBy(25.dp, alignment = Alignment.Top),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TitleBlume()
            Text(
                "PEDIDOS",
                style = TextStyle(
                    fontFamily = poppins,
                    fontWeight = FontWeight.Bold,
                    color = Gray700,
                    fontSize = 24.sp
                )
            )
        }
    }
}