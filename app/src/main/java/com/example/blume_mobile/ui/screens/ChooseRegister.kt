package com.example.blume_mobile.ui.screens

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.blume_mobile.R
import com.example.blume_mobile.ui.activties.RegisterActivity
import com.example.blume_mobile.ui.components.cards.ChooseProfileClient
import com.example.blume_mobile.ui.components.cards.ChooseProfileEmployee
import com.example.blume_mobile.ui.theme.Gray100
import com.example.blume_mobile.ui.theme.poppins
import org.w3c.dom.Text

@Composable
fun ChooseRegister(){
    val contexto = LocalContext.current


    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(top = 30.dp)
            .background(Gray100)
        ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Column(
            Modifier
                .fillMaxHeight(0.55f)
                .fillMaxWidth()
            ,
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Column(
                Modifier
                    .fillMaxWidth(0.7f)
                    .fillMaxHeight(0.3f)
                ,
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(
                    stringResource(R.string.choose_register_title),
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        textAlign = TextAlign.Center,
                        fontFamily = poppins
                    )
                )
                Text(
                    stringResource(R.string.choose_register_text),
                    style = TextStyle(
                        textAlign = TextAlign.Center,
                        fontFamily = poppins
                    )
                )
            }


            Row(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
                ,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ){

                ChooseProfileClient(){
                    val nextScreen = Intent(contexto, RegisterActivity::class.java)

                    contexto.startActivity(nextScreen)
                }

                ChooseProfileEmployee(

                ){

                }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewChooseRegister(){
    ChooseRegister()
}