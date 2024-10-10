package com.example.blume_mobile.ui.components.stepper

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.blume_mobile.ui.theme.Gray100
import com.example.blume_mobile.ui.theme.Violet300
import com.example.blume_mobile.ui.theme.inter

@Composable
fun StepperPosition(
    number: String,
    background: Color,
    textColor: Color
) {
    Box(
        modifier = Modifier
            .size(30.dp)
            .clip(CircleShape)
            .border(shape = CircleShape, color = Violet300, width = 2.dp)
            .background(background)
        ,
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = number,
            style = TextStyle(
                color = textColor,
                fontSize = 20.sp,
                fontFamily = inter,
                fontWeight = FontWeight.SemiBold
            )
        )
    }

}

@Composable
fun Stepper(
    position: Int = 1
) {
    val colorFull = Violet300
    val color = Gray100

    Row(
        Modifier
            .fillMaxWidth()
        ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        StepperPosition(number = "1", colorFull, color)
        Box(
            modifier = Modifier
                .width(85.dp)
                .height(2.dp)
                .background(Color(150, 154, 255))
        ){}
        StepperPosition(number = "2", if (position > 1) colorFull else color, if (position > 1) color else colorFull)
    }
}

@Preview
@Composable
fun StepperPreview() {
    Stepper()
}