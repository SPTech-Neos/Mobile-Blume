package com.example.blume_mobile.ui.screens

import android.app.appsearch.SearchResult
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

import com.example.blume_mobile.R
import com.example.blume_mobile.data.sampleCategories
import com.example.blume_mobile.data.sampleEstablishments
import com.example.blume_mobile.data.sampleServices
import com.example.blume_mobile.models.di.UserSession
import com.example.blume_mobile.models.establishment.Establishment
import com.example.blume_mobile.models.product.Product
import com.example.blume_mobile.models.service.Service
import com.example.blume_mobile.ui.activties.Feed
import com.example.blume_mobile.ui.activties.Orders
import com.example.blume_mobile.ui.activties.Search
import com.example.blume_mobile.ui.badge.CategoryBadge
import com.example.blume_mobile.ui.components.titles.TitleBlume
import com.example.blume_mobile.ui.components.banner.Banner
import com.example.blume_mobile.ui.components.cards.BestRated
import com.example.blume_mobile.ui.components.cards.CategoryCard
import com.example.blume_mobile.ui.components.cards.EstablishmentCard
import com.example.blume_mobile.ui.components.cards.EstablishmentRatedCard
import com.example.blume_mobile.ui.components.cards.ServiceRatedCard
import com.example.blume_mobile.ui.components.cards.ProductRatedCard
import com.example.blume_mobile.ui.components.searchbar.SearchBar
import com.example.blume_mobile.ui.states.FeedScreenUiState
import com.example.blume_mobile.ui.theme.Gray100
import com.example.blume_mobile.ui.theme.Gray700
import com.example.blume_mobile.ui.theme.Green50
import com.example.blume_mobile.ui.theme.Violet50
import com.example.blume_mobile.ui.theme.Violet500
import com.example.blume_mobile.ui.theme.Yellow50
import com.example.blume_mobile.ui.theme.poppins
import com.example.blume_mobile.ui.viewModels.FeedScreenViewModel
import com.example.blume_mobile.ui.viewModels.ProfileScreenViewModel
import com.google.gson.Gson


//@Composable
//fun Navigation(){
//    val navController = rememberNavController()
//
//    NavHost(
//        modifier = Modifier,
//        navController = navController,
//        startDestination = "feed",
//
//    ){
//        composable("feed"){
//            Feed(navController = navController)
//        }
//
//        composable(route = "service_details?service={service}", arguments = listOf(
//            navArgument(
//                name = "service"
//            ){
//                type = NavType.StringType
//                defaultValue = ""
//            }
//        )){
//            val serviceJson = it.arguments?.getString("service")
//            val serviceObj = Gson().fromJson(serviceJson, Service::class.java)
//            ServiceDetails(service = serviceObj, navController = navController)
//        }
//
//
//
//    }
//}


@Composable
fun FeedScreen(viewModel: FeedScreenViewModel = FeedScreenViewModel(), navController: NavController) {
    val state by viewModel.uiState.collectAsState()

    FeedScreen(state = state, navController = navController)
}

@Composable
fun FeedScreen(state: FeedScreenUiState, navController: NavController) {
    val establishments = state.establishments
    val services = state.services
    val products = state.bestProducts
    val bestEstablishment = state.bestEstablishments
    val searchedText = state.searchedText
    val searchedEstablishments = state.searchedBestEstablishments
    val searchedServices = state.searchedBestServices
    val searchedProducts = state.searchedBestProducts

    Log.i("teste api", "resultado na tela $establishments")
    Log.i("teste api", "resultado na tela $services")
    Log.i("teste api", "resultado na tela $products")
    Log.i("teste api", "resultado na tela $searchedServices")


    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Gray100)
            .padding(top = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(30.dp),
    ) {

        Row(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.1f),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TitleBlume()
        }

        SearchBar(value = searchedText, handleChange = state.onSearch)
        if (searchedText.isBlank()) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(20.dp),
                contentPadding = PaddingValues(vertical = 10.dp),
            ){

                item {
                    Banner(
                        "Teste",
                        painterResource(id = R.drawable.messy_bun_cuate),
                        Violet500,
                        "andamento"
                    )
                }

                item {
                    Column(
                        Modifier
                            .fillMaxWidth(0.9f)
                            .fillMaxHeight(0.28f),
                        verticalArrangement = Arrangement.spacedBy(30.dp)
                    ) {
                        Text(
                            "Categorias populares: ",
                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                fontFamily = poppins,
                                color = Gray700
                            )
                        )

                        Row(
                            Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(0.7f),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceAround
                        ) {
                            CategoryCard("Cabelos", Violet50)
                            CategoryCard("Unhas", Green50)
                            CategoryCard("Barba", Yellow50)
                        }
                    }
                }

                item {
                    Column(
                        Modifier
                            .fillMaxWidth(0.9f)
                            .fillMaxHeight(0.4f),
                        verticalArrangement = Arrangement.spacedBy(30.dp)
                    ) {
                        Text(
                            "Lugares bem avaliados: ",
                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                fontFamily = poppins,
                                color = Gray700
                            )
                        )

                        LazyRow(
                            Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(0.7f),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            contentPadding = PaddingValues(horizontal = 2.dp)
                        ) {
                            if (bestEstablishment.isNotEmpty()) {
                                items(bestEstablishment) { e ->
                                    EstablishmentRatedCard(
                                        navController = navController,
                                        establishment = e
                                    )
                                }
                            }
                        }
                    }
                }

                item {
                    Column(
                        Modifier
                            .fillMaxWidth(0.9f)
                            .fillMaxHeight(0.4f),
                        verticalArrangement = Arrangement.spacedBy(30.dp)
                    ) {
                        Text(
                            "Produtos bem avaliados: ",
                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                fontFamily = poppins,
                                color = Gray700
                            )
                        )

                        LazyRow(
                            Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(0.7f),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            contentPadding = PaddingValues(horizontal = 2.dp)
                        ) {
                            if (products.isNotEmpty()) {
                                items(products) { p ->
                                    ProductRatedCard(
                                        navController = navController,
                                        product = p
                                    )
                                }
                            }
                        }
                    }
                }

                item {
                    Column(
                        Modifier
                            .fillMaxWidth(0.9f)
                            .fillMaxHeight(0.4f),
                        verticalArrangement = Arrangement.spacedBy(30.dp)
                    ) {
                        Text(
                            "Serviços bem avaliados: ",
                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                fontFamily = poppins,
                                color = Gray700
                            )
                        )

                        LazyRow(
                            Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(0.7f),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            contentPadding = PaddingValues(horizontal = 2.dp)
                        ) {
                            if (services.isNotEmpty()) {
                                items(services) { s ->
                                    ServiceRatedCard(
                                        navController = navController,
                                        service = s
                                    )
                                }
                            }
                        }
                    }
                }

                item {
                    Column(
                        Modifier
                            .fillMaxWidth(0.9f)
                            .fillMaxHeight(),
                    ) {
                        Text(
                            "Estabelecimentos: ",
                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                fontFamily = poppins,
                                color = Gray700
                            )
                        )

                    }
                }

                Log.i("teste establishments", "resultado na tela $establishments")


                if (establishments.isNotEmpty()) {
                    items(establishments) { e ->
                        EstablishmentCard(e.name, e.description, e.media!!, e.imgUrl)
                    }
                }
            }
        } else {
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(30.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CategoryBadge(
                    name = "Estabelecimentos",
                    width = 100,
                    height = 30,
                    clickable = true,
                    state.onClickFilter,
                    state.filtered
                )
                CategoryBadge(
                    name = "Serviços",
                    width = 100,
                    height = 30,
                    clickable = true,
                    state.onClickFilter,
                    state.filtered
                )
                CategoryBadge(
                    name = "Produtos",
                    width = 100,
                    height = 30,
                    clickable = true,
                    state.onClickFilter,
                    state.filtered
                )
            }

            if (searchedEstablishments.isNotEmpty()) {
                if (state.filtered == "Estabelecimentos") {
                    SearchResultEstablishments(establishments = searchedEstablishments)
                }
            }

            if(searchedServices.isNotEmpty()){
                if(state.filtered == "Serviços"){
                    SearchResultServices(services = searchedServices)
                }
            }

            if(searchedProducts.isNotEmpty()){
                if(state.filtered == "Produtos"){
                    SearchResultProducts(products = searchedProducts)
                }
            }
        }
    }
}


@Preview()
@Composable
fun FeedPreview() {
    FeedScreen(FeedScreenUiState(), rememberNavController())
}