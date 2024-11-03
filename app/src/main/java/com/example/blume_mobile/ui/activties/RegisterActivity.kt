package com.example.blume_mobile.ui.activties

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.blume_mobile.ui.screens.Register
import com.example.blume_mobile.ui.theme.BlumeMobileTheme
import com.example.blume_mobile.ui.viewModels.RegisterScreenViewModel

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BlumeMobileTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val viewModel by viewModels<RegisterScreenViewModel>()
                    RegisterScreen(
                        modifier = Modifier.padding(innerPadding),
                        viewModel = viewModel
                    )
                }
            }
        }
    }
}

@Composable
fun RegisterScreen(modifier: Modifier = Modifier, viewModel: RegisterScreenViewModel){

    Register(viewModel)
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegisterScreenPreview() {
    BlumeMobileTheme {
        RegisterScreen(viewModel = RegisterScreenViewModel())
    }
}