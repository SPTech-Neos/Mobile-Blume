package com.example.blume_mobile.ui.screens


import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.blume_mobile.R
import com.example.blume_mobile.ui.activties.ChooseRegisterActivity
import com.example.blume_mobile.ui.activties.LoginActivity
import com.example.blume_mobile.ui.activties.Register2Activity
import com.example.blume_mobile.ui.components.buttons.CancelButton
import com.example.blume_mobile.ui.components.buttons.CustomButton
import com.example.blume_mobile.ui.components.inputs.InputCpf
import com.example.blume_mobile.ui.components.inputs.InputEmail
import com.example.blume_mobile.ui.components.inputs.InputPhone
import com.example.blume_mobile.ui.components.inputs.InputText
import com.example.blume_mobile.ui.components.titles.Title
import com.example.blume_mobile.ui.states.RegisterScreenUiState
import com.example.blume_mobile.ui.theme.Gray100
import com.example.blume_mobile.ui.viewModels.RegisterScreenViewModel

@Composable
fun Register(viewModel: RegisterScreenViewModel){
    val state by viewModel.uiState.collectAsState()

    Register(state = state)
}

@Composable
fun Register(state: RegisterScreenUiState) {

    val nome = state.name
    val email = state.email
    val senha = state.password
    val confirmarSenha = state.confirmPassword
    val cpf = state.cpf
    val telefone = state.phone
    val contexto = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(Gray100)
            ,
        verticalArrangement = Arrangement.Top
    ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .imePadding()
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(100.dp, 150.dp)
                        .paint(
                            painterResource(id = R.drawable.arch_top),
                            contentScale = ContentScale.FillBounds
                        )
                ) {

                    Column(
                        modifier = Modifier
                            .padding(top = 40.dp)
                            .fillMaxWidth()
                            .heightIn(100.dp, 150.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Title(text = "CADASTRO")
                    }
                }
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally,
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
                        modifier = Modifier.fillMaxHeight(0.95f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Bottom
                    ){

                        InputText(
                            textValue = nome,
                            5,
                            "Text",
                            "Nome completo",
                            "Ex: Kevin Rodrigues da Silva" ,
                            state.onNameChange
                        )

                        InputEmail(
                            text = email,
                            "Ex: example@email.com",
                            "Email",
                            state.onEmailChange
                        )


                        InputText(
                            textValue = senha,
                            8,
                            "Senha",
                            "Senha",
                            "Ex: sS3nh@a1",
                            state.onPasswordChange
                        )


                        InputText(
                            textValue = confirmarSenha,
                            8,
                            "Senha",
                            "Confirmar senha",
                            "Ex: sS3nh@a1",
                            state.onConfirmPasswordChange
                        )

                        InputCpf(
                            text = cpf,
                            "Ex: 000.000.000-00",
                            "CPF",
                            state.onCpfChange
                        )

                        InputPhone(
                            text = telefone,
                            "Ex: (11) 93335-7637",
                            "Telefone",
                            state.onPhoneChange
                        )

                        CustomButton("Próximo", 200){
                            val nextScreen = Intent(contexto, Register2Activity::class.java)

                            contexto.startActivity(nextScreen)
                        }
                        CancelButton(text = "Cancelar", 40){
                            val previous = Intent(contexto, ChooseRegisterActivity::class.java)

                            contexto.startActivity(previous)
                        }
                    }


                }
            }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun RegisterPreview(){
    Register(state = RegisterScreenUiState())
}