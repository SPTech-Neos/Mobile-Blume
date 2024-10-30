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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.blume_mobile.ui.screens.SearchScreen
import com.example.blume_mobile.ui.theme.BlumeMobileTheme
import com.example.blume_mobile.ui.viewModels.FeedScreenViewModel
import com.example.blume_mobile.ui.viewModels.SearchScreenViewModel

class SearchActivity : ComponentActivity() {
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
                        val viewModel by viewModels<SearchScreenViewModel>()
                        Search(
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
fun Search(viewModel: SearchScreenViewModel = SearchScreenViewModel(), modifier: Modifier = Modifier) {
    SearchScreen(viewModel = viewModel)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    BlumeMobileTheme {
        Search(viewModel = SearchScreenViewModel(), modifier = Modifier)
    }
}