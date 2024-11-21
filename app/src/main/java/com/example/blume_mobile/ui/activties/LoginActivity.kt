package com.example.blume_mobile.ui.activties

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.blume_mobile.models.di.UserSession
import com.example.blume_mobile.ui.screens.LoginScreen
import com.example.blume_mobile.ui.theme.BlumeMobileTheme
import com.example.blume_mobile.ui.viewModels.LoginScreenViewModel
import org.koin.android.ext.android.inject

class LoginActivity : ComponentActivity() {
    private val userSession: UserSession by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BlumeMobileTheme {

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val viewModel:LoginScreenViewModel  by viewModels()
                    LoginScreen(
                        modifier = Modifier.padding(innerPadding),
                        viewModel = viewModel,
                        userSession = userSession
                    )
                }
            }
        }
    }
}

@Composable
fun LoginScreen(modifier: Modifier, viewModel: LoginScreenViewModel, userSession: UserSession) {
    LoginScreen(viewModel = viewModel, userSession = userSession)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    BlumeMobileTheme {
        LoginScreen(Modifier, LoginScreenViewModel(), UserSession())
    }
}