package com.example.blume_mobile.components.Inputs

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.toLowerCase

fun validTextError(text: String, qtdCaracteres: Int): Boolean{
    if(text.isNotBlank() && text.length < qtdCaracteres){
        return true
    }

    return false
}

@Composable
fun Input(textValue: String, label: String, placeholder: String, qtdCaracteres: Int){
    var showText by remember {
        mutableStateOf(true)
    }
    var text by remember {
        mutableStateOf(textValue)
    }
    var isError by remember {
        mutableStateOf(false)
    }
    var errorMessage by remember {
        mutableStateOf("")
    }

    
    if(validTextError(text, qtdCaracteres)){
        isError = true
        errorMessage = "Digite no mínimo $qtdCaracteres caracteres"

        if(label.lowercase() == "senha" || label.lowercase() == "confirmar senha") {
            showText = false
            errorMessage += ", sua senha deve conter também 1 letra maiúscula, 1 número e um " +
                    "caracter especial"
        }

    }else{
        isError = false
        errorMessage = ""
    }

    OutlinedTextField(
        modifier = Modifier,
        value = text,
        onValueChange = { text = it },
        maxLines = 1,
        colors = OutlinedTextFieldDefaults.colors(
          focusedBorderColor = Color(150, 154, 255),
          focusedTextColor = Color(150, 154, 255),
          focusedLabelColor = Color(150, 154, 255),

        ),
        placeholder = {Text(
            modifier = Modifier,
            text = placeholder,
            style = TextStyle(
                fontSize = 12.sp,
                color = Color.Gray
            ),
        )},
        shape = RoundedCornerShape(10.dp),
        label = {Text(
            modifier = Modifier,
            text = label,
            style = TextStyle(
                fontSize = 12.sp,
                color = Color.Black
            ),
        )},
        trailingIcon = {
            if(!showText){
                Icon(
                    Icons.Default.Lock,
                    contentDescription = "",
                    tint = Color.Black,
                    modifier = Modifier.clickable { showText = true }
                )
            }
        },
        visualTransformation = if(showText) VisualTransformation.None else PasswordVisualTransformation(),
        supportingText = {
            Text(text = errorMessage, style = TextStyle(color = Color.Red))
        },
        isError = isError
    )
}

@Composable
@Preview
fun InputPreview(){
    Input("Kevin", "Teste", "Ex: Kevin Rodrigues da Silva", 8)
}