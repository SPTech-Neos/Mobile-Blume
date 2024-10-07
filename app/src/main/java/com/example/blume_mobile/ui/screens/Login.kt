package com.example.blume_mobile.ui.screens

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.blume_mobile.R
import com.example.blume_mobile.ui.components.buttons.CustomButton
import com.example.blume_mobile.ui.components.inputs.InputEmail
import com.example.blume_mobile.ui.components.inputs.InputText
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.example.blume_mobile.ui.activties.ChooseRegisterActivity
import com.example.blume_mobile.ui.activties.FeedActivity
import com.example.blume_mobile.ui.components.titles.TitleBlume
import com.example.blume_mobile.ui.states.LoginScreenUiState
import com.example.blume_mobile.ui.theme.Gray700
import com.example.blume_mobile.ui.theme.poppins
import com.example.blume_mobile.ui.viewModels.LoginScreenViewModel

@Composable
fun LoginScreen(viewModel: LoginScreenViewModel){

    val state by viewModel.uiState.collectAsState()
    LoginScreen(state = state)
}

@Composable
fun LoginScreen(state: LoginScreenUiState = LoginScreenUiState()){

    val email = state.email
    val password = state.password
    val contexto = LocalContext.current
    

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color(250, 250, 250))
            .imePadding()
        ,
        verticalArrangement = Arrangement.SpaceAround
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.3f)
            ,
            horizontalArrangement = Arrangement.spacedBy(20.dp, alignment = Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically

        ){
            Column(
                Modifier.heightIn(100.dp, 150.dp),
                verticalArrangement = Arrangement.Bottom
            ){
                Image(painter = painterResource(R.drawable.logopart1), contentDescription = "Figura geométrica da logo")
            }
            TitleBlume()
            Column(
                Modifier
                    .heightIn(100.dp, 150.dp)
                ,
            ){
                Image(painter = painterResource(R.drawable.logopart2), contentDescription = "Figura geométrica da logo")
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(30.dp)
            ,
            verticalArrangement = Arrangement.Top,
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                Text(
                    "Entre na sua conta:",
                    color = Gray700,
                    fontSize = 20.sp,
                    fontFamily = poppins,
                )
            }

            Spacer(modifier = Modifier.height(40.dp))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                InputEmail(text = email, placeholder = "example@email.com", label = "Email", state.onEmailChange)
                InputText(textValue = password, 8, "senha", "Senha", "********", state.onPasswordChange)
                CustomButton("Entrar", 280){
                    val nextScreen = Intent(contexto, FeedActivity::class.java)

                    contexto.startActivity(nextScreen)
                }

                Spacer(modifier = Modifier.height(120.dp))
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text("Não tem conta ainda?", color = Gray700)
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
    LoginScreen(LoginScreenUiState())
}