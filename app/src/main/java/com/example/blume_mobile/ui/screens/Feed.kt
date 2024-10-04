package com.example.blume_mobile.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.blume_mobile.R
import com.example.blume_mobile.ui.components.titles.TitleBlume
import com.example.blume_mobile.ui.components.banner.Banner
import com.example.blume_mobile.ui.components.cards.CategoryCard
import com.example.blume_mobile.ui.components.cards.EntityCard
import com.example.blume_mobile.ui.states.FeedScreenUiState
import com.example.blume_mobile.ui.theme.Green50
import com.example.blume_mobile.ui.theme.Violet50
import com.example.blume_mobile.ui.theme.Violet500
import com.example.blume_mobile.ui.theme.Yellow50
import com.example.blume_mobile.ui.theme.poppins
import com.example.blume_mobile.ui.viewModels.FeedScreenViewModel


@Composable
fun FeedScreen(viewModel: FeedScreenViewModel){
    val state by viewModel.uiState.collectAsState()

    FeedScreen(state = state)
}

@Composable
fun FeedScreen(state: FeedScreenUiState){
    val nomeEstab = state.establishments

    Log.i("teste api", "resultado na tela $nomeEstab")

    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color(250, 250, 250))
        ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.1f)
            ,
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            TitleBlume()
        }

        Banner(
            "Teste",
            painterResource(id = R.drawable.messy_bun_cuate),
            Violet500,
            "andamento"
        )

        Column(
            Modifier
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.28f)
            ,
            verticalArrangement = Arrangement.SpaceAround
        ){
            Text("Categorias populares: ",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontFamily = poppins
                )
            )

            Row(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.7f)
                ,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ){
                CategoryCard("Cabelos", Violet50)
                CategoryCard("Unhas", Green50)
                CategoryCard("Barba", Yellow50)
            }
        }

        Column(
            Modifier
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.4f)
            ,
            verticalArrangement = Arrangement.SpaceAround
        ){
            Text("Lugares bem avaliados: ",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontFamily = poppins
                )
            )

            Row(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.7f)
                ,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ){
                if(nomeEstab.isNotEmpty()){
                    EntityCard(nomeEstab[0].name, "Categoria")
                }
                EntityCard("Nome salão", "Categoria")
            }
        }

        Column(
            Modifier
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.4f)
            ,
            verticalArrangement = Arrangement.SpaceAround
        ){
            Text("Estabelecimentos: ",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontFamily = poppins
                )
            )

            Row(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.8f)
                ,
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ){
                Row(
                    Modifier
                        .fillMaxWidth(0.98f)
                        .fillMaxHeight()
                        .background(Color(250, 250, 250))
                        .shadow(
                            elevation = 2.dp,
                            shape = RoundedCornerShape(2.dp)
                        ),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ){
                    Box(
                        Modifier
                            .size(40.dp)
                            .clip(RoundedCornerShape(100.dp))
                    ){
                        Box(
                            Modifier
                                .size(50.dp)
                                .background(Color.Gray)
                                .clip(RoundedCornerShape(100.dp))
                        ){
                        }
                    }

                    Text("Nome estabelecimento", style = TextStyle(
                        fontFamily = poppins,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 12.sp

                        )
                    )

                    Text("Categoria", style = TextStyle(
                        fontFamily = poppins,
                        fontWeight = FontWeight.Light,
                        fontSize = 12.sp

                        )
                    )

                    Icon(Icons.Rounded.Star, contentDescription = "Avaliação")
                }

            }
        }

    }
}

@Preview()
@Composable
fun FeedPreview(){
    FeedScreen(FeedScreenUiState())
}