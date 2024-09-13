package com.example.blume_mobile.screens

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.blume_mobile.R
import com.example.blume_mobile.components.Buttons.CustomButton
import com.example.blume_mobile.components.Inputs.InputEmail
import com.example.blume_mobile.components.Inputs.InputText
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.example.blume_mobile.ChooseRegisterActivity
import com.example.blume_mobile.FeedActivity
import com.example.blume_mobile.activties.RegisterActivity

@Composable
fun Login(){

    var email by remember{ mutableStateOf("") }
    var senha by remember{ mutableStateOf("") }
    val contexto = LocalContext.current
    

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color(250, 250, 250))
        ,
        verticalArrangement = Arrangement.SpaceAround
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f)
            ,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ){
            Image(
                painter = painterResource(
                    id = R.mipmap.blumelogotipo
                ),
                contentDescription = "Logo Blume",
                modifier = Modifier.size(240.dp)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(60.dp)
            ,
            verticalArrangement = Arrangement.Top,
        ) {
            Text("Entre na sua conta:")
            Spacer(modifier = Modifier.height(40.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                InputEmail(textValue = email, placeholder = "example@email.com", label = "Email")
                InputText(textValue = senha, 8, "senha", "Senha", "sS3nh@a1")
                CustomButton("Entrar", 400){
                    val nextScreen = Intent(contexto, FeedActivity::class.java)

                    contexto.startActivity(nextScreen)
                }

                Spacer(modifier = Modifier.height(120.dp))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text("Não tem conta ainda?")
                    Text(" Crie uma conta!",
                        Modifier.clickable(enabled = true) {
                            val nextScreen = Intent(contexto, ChooseRegisterActivity::class.java)

                            contexto.startActivity(nextScreen)
                        },
                        style = TextStyle(
                            color = Color(150, 154, 250),
                            fontSize = 15.sp
                        )
                    )

                }
            }

        }

    }

}

@Preview
@Composable
fun LoginPreview(){
    Login()
}