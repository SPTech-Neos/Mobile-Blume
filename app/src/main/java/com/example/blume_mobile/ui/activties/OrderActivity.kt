package com.example.blume_mobile.ui.activties

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.blume_mobile.models.di.UserSession
import com.example.blume_mobile.ui.screens.OrderScreen
import com.example.blume_mobile.ui.theme.BlumeMobileTheme
import com.example.blume_mobile.ui.viewModels.FeedScreenViewModel
import com.example.blume_mobile.ui.viewModels.OrderScreenViewModel

class OrderActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BlumeMobileTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val viewModel by viewModels<OrderScreenViewModel>()
                    Orders(
                        viewModel = viewModel,
                        modifier = Modifier.padding(innerPadding),
                        userSession = UserSession()
                    )
                }
            }
        }
    }
}

@Composable
fun Orders(viewModel: OrderScreenViewModel = OrderScreenViewModel(), modifier: Modifier = Modifier, userSession: UserSession) {
    OrderScreen(viewModel, userSession)
}

@Preview(showBackground = true)
@Composable
fun OrdersPreview() {
    BlumeMobileTheme {
        Orders(OrderScreenViewModel(), Modifier, UserSession())
    }
}