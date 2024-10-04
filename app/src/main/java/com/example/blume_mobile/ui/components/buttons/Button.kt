package com.example.blume_mobile.ui.components.buttons

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun CustomButton(text: String, width: Int, onClick: ()-> Unit){
    Button(
        modifier = Modifier
            .width(width.dp),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color(150, 154, 255)),
        shape = RoundedCornerShape(20)
    ){
        Text(
            text = text.uppercase(),
            style = TextStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
}
