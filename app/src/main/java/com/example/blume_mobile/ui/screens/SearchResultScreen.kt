package com.example.blume_mobile.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.blume_mobile.models.Establishment
import com.example.blume_mobile.models.Product
import com.example.blume_mobile.models.Service

@Composable
fun SearchResultScreen(
    establishments : List<Establishment> = emptyList(),
    products: List<Product> = emptyList(),
    services: List<Service> = emptyList()
){
    Text("Teste")
}