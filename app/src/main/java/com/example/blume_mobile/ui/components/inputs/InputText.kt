package com.example.blume_mobile.ui.components.inputs

import androidx.compose.runtime.Composable


@Composable
fun InputText(textValue: String, qtdCaracteres: Int, type: String, label: String, placeholder: String, onValueChange: (String) -> Unit = {}){
    Input(
        textValue,
        type,
        label,
        placeholder,
        qtdCaracteres,
    )
}