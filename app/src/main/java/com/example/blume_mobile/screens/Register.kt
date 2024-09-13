package com.example.blume_mobile.screens


import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.blume_mobile.Register2Activity
import com.example.blume_mobile.components.Buttons.CancelButton
import com.example.blume_mobile.components.Buttons.CustomButton
import com.example.blume_mobile.components.Inputs.InputCpf
import com.example.blume_mobile.components.Inputs.InputEmail
import com.example.blume_mobile.components.Inputs.InputPhone
import com.example.blume_mobile.components.Inputs.InputText
import com.example.blume_mobile.components.Titles.Title

@Composable
fun Register(modifier: Modifier) {

    var nome by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var confirmarSenha by remember { mutableStateOf("") }
    var cpf by remember { mutableStateOf("") }
    var telefone by remember { mutableStateOf("") }
    val contexto = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Top
    ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth()
                        .fillMaxHeight(0.2f)
                        .paint(
                            painterResource(id = R.drawable.arch_top),
                            contentScale = ContentScale.FillBounds
                        )
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(),
                        verticalArrangement = Arrangement.Bottom,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Title(text = "CADASTRO")
                    }
                }
                Column(
                    modifier = Modifier.fillMaxHeight(0.93f),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Bottom
                ){
                    Text(
                        text = "OBRIGATÓRIO",
                        style = TextStyle(
                            fontSize = 15.sp,
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                        ),
                    )
                    Column(
                        modifier = Modifier.fillMaxHeight(0.83f),
                        verticalArrangement = Arrangement.Center
                    ){

                        InputText(
                            textValue = nome,
                            5,
                            "Text",
                            "Nome completo",
                            "Ex: Kevin Rodrigues da Silva"
                        )

                        InputEmail(
                            textValue = email,
                            "Ex: example@email.com",
                            "Email",
                        )

                        InputText(
                            textValue = senha,
                            8,
                            "Senha",
                            "Senha",
                            "Ex: sS3nh@a1"
                        )

                        InputText(
                            textValue = confirmarSenha,
                            8,
                            "Senha",
                            "Confirmar senha",
                            "Ex: sS3nh@a1"
                        )

                        InputCpf(
                            textValue = cpf,
                            "Ex: 000.000.000-00",
                            "CPF"
                        )

                        InputPhone(
                            textValue = telefone,
                            "Ex: (11) 93335-7637",
                            "Telefone",
                        )
                    }

                    CustomButton("Próximo", 200){
                        val nextScreen = Intent(contexto, Register2Activity::class.java)

                        contexto.startActivity(nextScreen)
                    }
                    CancelButton(text = "Cancelar", 40){}

                }
            }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun RegisterPreview(){
    Register(modifier = Modifier)
}