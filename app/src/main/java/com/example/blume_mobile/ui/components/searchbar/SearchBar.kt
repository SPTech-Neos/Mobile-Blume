package com.example.blume_mobile.ui.components.searchbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.blume_mobile.ui.theme.Gray200
import com.example.blume_mobile.ui.theme.Gray500
import com.example.blume_mobile.ui.theme.Gray700
import com.example.blume_mobile.ui.theme.poppins

@Composable
fun SearchBar(
    value: String,
    handleChange: (String) -> Unit
){
    OutlinedTextField(
        value = value,
        onValueChange = {handleChange(it)},
        Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 16.dp, end = 16.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Gray200,
            focusedTextColor = Gray700,
            focusedLabelColor = Gray200,
            cursorColor = Color(150, 154, 255),
            unfocusedBorderColor = Gray200,
            unfocusedTextColor = Gray500,
            unfocusedContainerColor = Gray200,
            focusedContainerColor = Gray200

        ),
        shape = RoundedCornerShape( 100),
        trailingIcon = {
            Icon(Icons.Default.Search, contentDescription = "Icone de buscar", tint = Gray500)
        },
        placeholder = {
            Text(text = "Pesquisar...", style = TextStyle(
                color = Gray500,
                fontFamily = poppins
            ))
        }
    )
}