package com.example.blume_mobile.ui.activties

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.blume_mobile.ui.components.navigation.BottomNav
import com.example.blume_mobile.ui.screens.FeedScreen
import com.example.blume_mobile.ui.theme.BlumeMobileTheme
import com.example.blume_mobile.ui.viewModels.FeedScreenViewModel
import kotlinx.coroutines.DelicateCoroutinesApi


class FeedActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BlumeMobileTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                    ) { innerPadding ->
                        val viewModel by viewModels<FeedScreenViewModel>()
                        Feed(
                            viewModel = viewModel,
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Feed(viewModel: FeedScreenViewModel = FeedScreenViewModel(), modifier: Modifier = Modifier) {
    FeedScreen(viewModel)
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview3() {

}
