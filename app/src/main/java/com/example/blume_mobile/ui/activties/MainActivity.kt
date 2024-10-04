package com.example.blume_mobile.ui.activties

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.blume_mobile.ui.theme.BlumeMobileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            BlumeMobileTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Main(
                        modifier = Modifier.padding(innerPadding),
                    )
                }
            }
        }
    }
}


@Composable
fun Main(modifier: Modifier = Modifier) {

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewMain() {
    BlumeMobileTheme {
        Main()
    }
}

