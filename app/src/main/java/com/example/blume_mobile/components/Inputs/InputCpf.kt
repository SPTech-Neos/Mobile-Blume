package com.example.blume_mobile.components.Inputs

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import com.example.blume_mobile.utils.mask.CpfMask

@Composable
fun InputCpf(textValue: String, placeholder: String, label: String){
    var text by remember {
        mutableStateOf(textValue)
    }

    var isError by remember {
        mutableStateOf(false)
    }
    var errorMessage by remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        modifier = Modifier,
        value = text,
        onValueChange = {
            if(it.isDigitsOnly()) {
                isError = false
                if (it.length < 12) {
                    text = it
                }
            }
        },
        maxLines = 1,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color(150, 154, 255),
            focusedTextColor = Color(150, 154, 255),
            focusedLabelColor = Color(150, 154, 255),

            ),
        placeholder = {
            Text(
                modifier = Modifier,
                text = placeholder,
                style = TextStyle(
                    fontSize = 12.sp,
                    color = Color.Gray
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
                color = Color.Black
            ),
        )
        },
        visualTransformation = CpfMask(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        supportingText = {
            Text(text = errorMessage, style = TextStyle(color = Color.Red))
        },  
        isError = isError,
    )

}