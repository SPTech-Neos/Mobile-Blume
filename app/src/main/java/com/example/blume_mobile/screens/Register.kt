package com.example.blume_mobile.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.blume_mobile.components.Inputs.InputPassword
import com.example.blume_mobile.components.Inputs.InputText

@Composable
fun Register(){


    var nome by remember { mutableStateOf("") }
    var sobrenome by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceEvenly
    ){
        InputText(textValue = nome, 5, "Nome completo", "Ex: Kevin Rodrigues da Silva")

        InputText(textValue = nome, 8, "Senha", "Ex: sS3nh@a1")

        InputText(textValue = nome, 5, "Nome completo", "Ex: Kevin Rodrigues da Silva")
    }
}