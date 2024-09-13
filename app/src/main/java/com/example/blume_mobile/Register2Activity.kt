package com.example.blume_mobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.blume_mobile.components.navigation.BottomNav
import com.example.blume_mobile.screens.RegisterOpcional
import com.example.blume_mobile.ui.theme.BlumeMobileTheme

class Register2Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BlumeMobileTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RegisterOpcionalScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun RegisterOpcionalScreen(modifier: Modifier) {
    RegisterOpcional()
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Register2Preview() {
    BlumeMobileTheme {
        RegisterOpcionalScreen(Modifier)
    }
}