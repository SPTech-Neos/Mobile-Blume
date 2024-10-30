package com.example.blume_mobile.ui.activties

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.blume_mobile.ui.components.navigation.BottomNav
import com.example.blume_mobile.ui.screens.SearchScreen
import com.example.blume_mobile.ui.theme.BlumeMobileTheme
import com.example.blume_mobile.ui.theme.Gray100
import com.example.blume_mobile.ui.theme.Gray700

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            BlumeMobileTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Gray100
                ){
                    Main()
                }
            }
        }
    }
}

@Composable
fun Navigation(navController: NavHostController){
    NavHost(
        modifier = Modifier,
        navController = navController,
        startDestination = "feed"
    ){
        composable("feed"){
            Feed()
        }

        composable("search"){
            Search()
        }

    }
}


@Composable
fun Main(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNav(nav = navController)},
        content = {padding ->
            Box(
                modifier = Modifier.padding(padding)
            ){
                Navigation(navController = navController)
            }
        },
        containerColor = Gray100
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewMain() {
    BlumeMobileTheme {
        Main()
    }
}

