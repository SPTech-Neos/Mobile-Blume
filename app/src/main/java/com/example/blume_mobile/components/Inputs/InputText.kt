package com.example.blume_mobile.components.Inputs

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.Placeholder


@Composable
fun InputText(textValue: String, qtdCaracteres: Int, type: String, label: String, placeholder: String){
    Input(
        textValue,
        type,
        label,
        placeholder,
        qtdCaracteres,
    )
}