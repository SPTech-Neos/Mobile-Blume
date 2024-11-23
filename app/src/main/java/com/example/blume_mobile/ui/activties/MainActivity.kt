package com.example.blume_mobile.ui.activties

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.blume_mobile.models.di.UserSession
import com.example.blume_mobile.models.establishment.Establishment
import com.example.blume_mobile.models.product.Product
import com.example.blume_mobile.models.service.Service
import com.example.blume_mobile.ui.components.navigation.BottomNav
import com.example.blume_mobile.ui.screens.EstablishmentDetails
import com.example.blume_mobile.ui.screens.ProductDetails
import com.example.blume_mobile.ui.screens.Profile
import com.example.blume_mobile.ui.screens.ServiceDetails
import com.example.blume_mobile.ui.theme.BlumeMobileTheme
import com.example.blume_mobile.ui.theme.Gray100
import com.example.blume_mobile.ui.viewModels.LoginScreenViewModel
import com.example.blume_mobile.ui.viewModels.ProfileScreenViewModel
import com.google.gson.Gson
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {
    private val userSession: UserSession by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            BlumeMobileTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Gray100
                ){
                val profileViewModel = ProfileScreenViewModel(userSession.id)

                    Main(userSession = userSession, profileVM = profileViewModel)
                }
            }
        }
    }
}

@Composable
fun Navigation(navController: NavHostController, userSession: UserSession, profileVM: ProfileScreenViewModel){
    NavHost(
        modifier = Modifier,
        navController = navController,
        startDestination = "feed"
    ){
        composable("feed"){
            Feed(navController = navController)
        }

        composable("search"){
            Search()
        }

        composable("orders"){
            Orders()
        }

        composable("profile"){
                Profile(userSession = userSession, viewModel = profileVM)
        }

        composable("feed"){
            Feed(navController = navController)
        }

        composable(route = "service_details?service={service}", arguments = listOf(
            navArgument(
                name = "service"
            ){
                type = NavType.StringType
                defaultValue = ""
            }
        )){
            val serviceJson = it.arguments?.getString("service")
            val serviceObj = Gson().fromJson(serviceJson, Service::class.java)
            ServiceDetails(service = serviceObj, navController = navController)
        }

        composable(route = "product_details?product={product}", arguments = listOf(
            navArgument(
                name = "product"
            ){
                type = NavType.StringType
                defaultValue = ""
            }
        )){
            val productJson = it.arguments?.getString("product")
            val productObj = Gson().fromJson(productJson, Product::class.java)
            ProductDetails(product = productObj)
        }

        composable(route = "establishment_details?establishment={establishment}", arguments = listOf(
            navArgument(
                name = "establishment"
            ){
                type = NavType.StringType
                defaultValue = ""
            }
        )){
            val establishmentJson = it.arguments?.getString("establishment")
            val establishmentObj = Gson().fromJson(establishmentJson, Establishment::class.java)
            EstablishmentDetails(establishment = establishmentObj)
        }



    }
}


@Composable
fun Main(modifier: Modifier = Modifier, userSession: UserSession, profileVM: ProfileScreenViewModel) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNav(nav = navController)},
        content = {padding ->
            Box(
                modifier = Modifier.padding(padding)
            ){
                Navigation(navController = navController, userSession, profileVM)
            }
        },
        containerColor = Gray100
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewMain() {
    BlumeMobileTheme {
        Main(userSession = UserSession(), profileVM = ProfileScreenViewModel())
    }
}

