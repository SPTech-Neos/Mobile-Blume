package com.example.blume_mobile.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.paint
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.blume_mobile.R
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
                        .paint(
                            // Replace with your image id
                            painterResource(id = R.mipmap.subtract),
                            contentScale = ContentScale.FillBounds
                        )
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.15f),
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

                    CustomButton("Próximo", 200, {})
                    CancelButton(text = "Cancelar", 40)
                }
            }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun RegisterPreview(){
    Register(modifier = Modifier)
}