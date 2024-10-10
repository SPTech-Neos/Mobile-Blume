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
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.blume_mobile.R
import com.example.blume_mobile.ui.activties.LoginActivity
import com.example.blume_mobile.ui.activties.RegisterActivity
import com.example.blume_mobile.ui.components.buttons.CancelButton
import com.example.blume_mobile.ui.components.buttons.CustomButton
import com.example.blume_mobile.ui.components.inputs.InputText
import com.example.blume_mobile.ui.components.stepper.Stepper
import com.example.blume_mobile.ui.components.titles.Title
import com.example.blume_mobile.ui.photoPicker.PhotoSelector
import com.example.blume_mobile.ui.states.RegisterScreenUiState
import com.example.blume_mobile.ui.theme.BlumeMobileTheme
import com.example.blume_mobile.ui.theme.Gray100
import com.example.blume_mobile.ui.theme.poppins
import com.example.blume_mobile.ui.viewModels.RegisterScreenViewModel

@Composable
fun RegisterOpcional(viewModel: RegisterScreenViewModel){
    val state by viewModel.uiState.collectAsState()

    RegisterOpcional(state = state)
}

@Composable
fun RegisterOpcional(state: RegisterScreenUiState){
    val cep = state.postalCode
    val publicPlace = state.publicPlace
    val number = state.number
    val complement = state.complement
    val countryState = state.countryState
    val url = state.url
    val contexto = LocalContext.current


    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Gray100)
        ,
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Column(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight()
            ,
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Column(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.32f)
                    .padding(top = 30.dp)
                ,
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Title(text = "Cadastro")
                Stepper(position = 2)
                PhotoSelector(url, state.onUrlChange)
                Text("OPCIONAL",
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = Color.Black,
                        fontFamily = poppins,
                        fontWeight = FontWeight.Bold,
                    ),
                )

            }

            InputText(
                textValue = cep,
                5,
                "Text",
                "CEP",
                "00000-000",
                state.onPostalCodeChange
            )

            InputText(
                textValue = publicPlace,
                5,
                "Text",
                "Logradouro",
                "Ex: Rua Coração de Maçã",
                state.onPublicPlaceChange
            )

            InputText(
                textValue = number,
                8,
                "Text",
                "Número",
                "Ex: 211",
                state.onNumberChange
            )

            InputText(
                textValue = complement,
                8,
                "Text",
                "Complemento",
                "ex: Bloco C",
                state.onComplementChange
            )

            InputText(
                textValue = countryState,
                8,
                "Text",
                "Estado",
                "Ex: SP",
                state.onCountryStateChange
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .paint(
                        // Replace with your image id
                        painterResource(id = R.drawable.arch_bottom),
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
        RegisterOpcional(RegisterScreenViewModel())
    }
}