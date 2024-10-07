package com.example.blume_mobile.ui.components.cards
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.blume_mobile.R
import com.example.blume_mobile.ui.theme.Gray700
import com.example.blume_mobile.ui.theme.Violet50
import com.example.blume_mobile.ui.theme.Green50
import com.example.blume_mobile.ui.theme.poppins

@Composable
fun ChooseProfileClient(onClick: () -> Unit){
    Box(
        Modifier.size(150.dp).clickable(enabled = true){
            onClick()
        },
        contentAlignment = Alignment.Center,

    ){

        Box(modifier = Modifier
            .size(150.dp)
            .clip(RoundedCornerShape(10))
            .background(Violet50)
            ,
            contentAlignment = Alignment.BottomCenter
        ){}

        Box(
            modifier = Modifier
                .size(
                    width = 120.dp,
                    height = 120.dp
                )
                .offset(0.dp, (-30).dp)
                .zIndex(1f)
                .paint(
                    // Replace with your image id
                    painterResource(id = R.drawable.icon_client_choose),
                    contentScale = ContentScale.FillBounds,

                    )
        ){}
        Column(
            Modifier
                .fillMaxWidth(0.8f)
                .fillMaxHeight(0.9f)
                .padding(10.dp)
            ,
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally

        ){
            Text("Cliente", style = TextStyle(
                fontFamily = poppins,
                fontWeight = FontWeight.SemiBold),
                color = Gray700
            )
        }
    }
}

@Composable
fun ChooseProfileEmployee(onClick : () -> Unit ){
    Box(
        Modifier.size(150.dp).clickable(enabled = true){
            onClick()
        },
        contentAlignment = Alignment.Center
    ){

        Box(modifier = Modifier
            .size(150.dp)
            .clip(RoundedCornerShape(10))
            .background(Green50)
            ,
            contentAlignment = Alignment.BottomCenter
        ){}

        Box(
            modifier = Modifier
                .size(
                    width = 120.dp,
                    height = 120.dp
                )
                .offset(0.dp, (-30).dp)
                .zIndex(1f)
                .paint(
                    painterResource(id = R.drawable.employee_choose),
                    contentScale = ContentScale.FillBounds,
                )
        ){}
        Column(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.9f)
                .padding(10.dp)
            ,
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally

        ){
            Text("Estabelecimento", style = TextStyle(
                fontFamily = poppins,
                fontWeight = FontWeight.SemiBold,
                color = Gray700
            ))
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ChoosePreview(){
    Row(
        Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
    ){
        ChooseProfileClient(){}
        ChooseProfileEmployee(){}
    }
}