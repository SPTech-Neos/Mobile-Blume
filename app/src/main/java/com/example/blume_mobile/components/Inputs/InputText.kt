package com.example.blume_mobile.components.Inputs

import androidx.compose.runtime.Composable


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