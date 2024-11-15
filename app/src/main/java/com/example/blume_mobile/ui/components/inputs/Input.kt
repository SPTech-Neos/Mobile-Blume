package com.example.blume_mobile.ui.components.inputs

import androidx.compose.foundation.clickable

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.blume_mobile.R
import com.example.blume_mobile.ui.masks.PlaceholderTransformation
import com.example.blume_mobile.ui.theme.Gray500
import com.example.blume_mobile.ui.theme.Gray700
import com.example.blume_mobile.ui.theme.josefin
import com.example.blume_mobile.ui.theme.poppins


fun validTextError(text: String, qtdCaracteres: Int): Boolean {
    return text.isNotBlank() && text.length < qtdCaracteres
}

@Composable
fun Input(
    text: String,
    type: String,
    label: String,
    placeholder: String,
    qtdCaracteres: Int,
    onChange: (String) -> Unit = {}
) {

    var showPassword by remember { mutableStateOf(false) }
    var isError by remember {
        mutableStateOf(false)
    }
    var errorMessage by remember {
        mutableStateOf("")
    }

    if (validTextError(text, qtdCaracteres)) {
        isError = true
        errorMessage = "Digite no mínimo $qtdCaracteres caracteres"

    } else {
        isError = false
        errorMessage = ""
    }

    if (type.lowercase() == "senha") {
        if (isError) {
            errorMessage += ", sua senha deve conter também 1 letra maiúscula, 1 número e um caracter especial"
        }
    }


    OutlinedTextField(
            modifier = Modifier,
        value = text,
        onValueChange = { onChange(it) },
        maxLines = 1,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color(150, 154, 255),
            focusedTextColor = Color(150, 154, 255),
            focusedLabelColor = Color(150, 154, 255),
            cursorColor = Color(150, 154, 255),
            errorTextColor = Color.Red,
            unfocusedTextColor = Gray500,


            ),
        placeholder = {
            Text(
                modifier = Modifier,
                text = placeholder,
                style = TextStyle(
                    fontSize = 12.sp,
                    color = Color.Red,
                    fontFamily = poppins
                ),
            )
        },
        shape = RoundedCornerShape(12.dp),
        label = {
            Text(
                modifier = Modifier,
                text = label,
                fontFamily = josefin,
                fontWeight = FontWeight.Light,
                fontSize = 12.sp,
                color = Gray700
            )
        },
        trailingIcon = {
            if(type.lowercase() == "senha"){
                if (showPassword) {
                    IconButton(onClick = { showPassword = false }) {
                        Icon(
                            painterResource(id = R.drawable.showpassword),
                            contentDescription = "hide_password",
                            tint = Gray700
                        )
                    }
                } else {
                    IconButton(
                        onClick = { showPassword = true }) {
                        Icon(
                            painterResource(id = R.drawable.hidepassword),
                            contentDescription = "hide_password",
                            tint = Gray700
                        )
                    }
                }
            }
        },
        visualTransformation =
        if (text.isEmpty()) PlaceholderTransformation(placeholder) else
            if (!showPassword && type.lowercase() == "senha") {
                PasswordVisualTransformation()

            } else {
                VisualTransformation.None
            },
        supportingText = {
            Text(text = errorMessage, style = TextStyle(color = Color.Red))
        },
        isError = isError,
    )
}

@Composable
@Preview
fun InputPreview() {
    Input("Kevin", "Teste", "Senha", "Ex: Kevin Rodrigues da Silva", 8, {})
}