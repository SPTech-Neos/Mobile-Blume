package com.example.blume_mobile.ui.screens

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.blume_mobile.R
import com.example.blume_mobile.ui.activties.LoginActivity
import com.example.blume_mobile.ui.activties.RegisterActivity
import com.example.blume_mobile.ui.components.buttons.CancelButton
import com.example.blume_mobile.ui.components.buttons.CustomButton
import com.example.blume_mobile.ui.components.inputs.InputText
import com.example.blume_mobile.ui.components.titles.Title
import com.example.blume_mobile.ui.theme.BlumeMobileTheme
import com.example.blume_mobile.ui.theme.Gray100

@Composable
fun RegisterOpcional(){
    val cep by remember { mutableStateOf("") }
    val logradouro by remember { mutableStateOf("") }
    val numero by remember { mutableStateOf("") }
    val complemento by remember { mutableStateOf("") }
    val estado by remember { mutableStateOf("") }
    val contexto = LocalContext.current


    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Gray100)
        ,
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Column(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.95f)
            ,
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Column(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.15f)
                ,
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Title(text = "Cadastro")
                Text("OPCIONAL",
                    style = TextStyle(
                        fontSize = 15.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                    ),
                )

            }

            Spacer(modifier = Modifier.fillMaxWidth(0.2f))
            Row(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.15f)
                ,
            ){

            }

            InputText(
                textValue = cep,
                5,
                "Text",
                "CEP",
                "00000-000"
            )

            InputText(
                textValue = logradouro,
                5,
                "Text",
                "Logradouro",
                "Ex: Rua Coração de Maçã",
            )

            InputText(
                textValue = numero,
                8,
                "Text",
                "Número",
                "Ex: 211"
            )

            InputText(
                textValue = complemento,
                8,
                "Text",
                "Complemento",
                "ex: Bloco C"
            )

            InputText(
                textValue = estado,
                8,
                "Text",
                "Estado",
                "Ex: SP"
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .paint(
                        // Replace with your image id
                        painterResource(id = R.mipmap.subtractreverse),
                        contentScale = ContentScale.FillBounds,
                        alignment = Alignment.TopEnd
                    )

            ){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CustomButton("Cadastrar", 200) {
                        val nextScreen = Intent(contexto, LoginActivity::class.java)

                        contexto.startActivity(nextScreen)
                    }
                    CancelButton(text = "Voltar", 25) {
                        val nextScreen = Intent(contexto, RegisterActivity::class.java)

                        contexto.startActivity(nextScreen)
                    }
                }
            }

        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegisterOpPreview() {
    BlumeMobileTheme {
        RegisterOpcional()
    }
}