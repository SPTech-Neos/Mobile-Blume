package com.example.blume_mobile.ui.components.inputs

import android.util.Patterns
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.blume_mobile.ui.masks.PlaceholderTransformation
import com.example.blume_mobile.ui.theme.Gray100
import com.example.blume_mobile.ui.theme.Gray500
import com.example.blume_mobile.ui.theme.Gray700
import com.example.blume_mobile.ui.theme.josefin

fun validEmail(email: String): Boolean {
    return false
}

@Composable
fun InputEmail(
    text: String,
    placeholder: String,
    label: String,
    onChangeValue: (String) -> Unit = {}
) {
    var isError by remember {
        mutableStateOf(false)
    }
    var errorMessage by remember {
        mutableStateOf("")
    }

    if (text.isNotEmpty() && !Patterns.EMAIL_ADDRESS.matcher(text).matches()) {
        isError = true
        errorMessage = "Insira um email válido!"
    } else {
        isError = false
        errorMessage = ""
    }

    OutlinedTextField(
        modifier = Modifier,
        value = text,
        onValueChange = { onChangeValue(it) },
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
                    color = Gray700
                ),
            )
        },
        shape = RoundedCornerShape(12.dp),
        label = {
            Text(
                modifier = Modifier,
                text = label,
                style = TextStyle(
                    fontSize = 12.sp,
                    color = Gray700,
                    fontFamily = josefin
                ),
            )
        },
        visualTransformation = if (text.isEmpty())
            PlaceholderTransformation("example@email.com")
        else VisualTransformation.None,
        supportingText = {
            Text(text = errorMessage, style = TextStyle(color = Color.Red))
        },
        isError = isError,
    )
}