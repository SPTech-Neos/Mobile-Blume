package com.example.blume_mobile.ui.components.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.example.blume_mobile.R
import com.example.blume_mobile.models.NavigationBottomItem

@Composable
fun BottomNav(){

    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }


    val navItens = listOf(
        NavigationBottomItem(
            title = "Home",
            selectedIcon = painterResource(id = R.drawable.home_selected),
            unselectedIcon = painterResource(id = R.drawable.home),
            hasNews = false
        ),

        NavigationBottomItem(
            title = "Pesquisar",
            selectedIcon = painterResource(id = R.drawable.search_selected),
            unselectedIcon = painterResource(id = R.drawable.search),
            hasNews = false
        ),

        NavigationBottomItem(
            title = "Pedidos",
            selectedIcon = painterResource(id = R.drawable.order_selected),
            unselectedIcon = painterResource(id = R.drawable.orders),
            hasNews = false
        ),

        NavigationBottomItem(
            title = "Perfil",
            selectedIcon = painterResource(id = R.drawable.profile_selected),
            unselectedIcon = painterResource(id = R.drawable.profile),
            hasNews = false
        )
    )

    Box(
        Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            Modifier
                .size(
                    width = 95.dp,
                    height = 48.dp
                )
                .zIndex(1f)
                .offset(0.dp, -67.dp)
                .paint(
                    painterResource(
                        id = R.drawable.halfmoon,

                    ),
                    contentScale = ContentScale.FillBounds
                    )
        ) {
            Box(
                Modifier
                    .size(
                        80.dp
                    )
                    .offset(10.dp, 18.dp)
                    .paint(
                        // Replace with your image id
                        painterResource(
                            id = R.drawable.circles
                        ),
                        contentScale = ContentScale.FillHeight

                    )
            ) {}

        }

        NavigationBar(
            containerColor = Color(250, 250, 250),

            modifier = Modifier
                .clip(shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
        ) {

            navItens.forEachIndexed { index, n ->
                NavigationBarItem(
                    modifier = Modifier,
                    colors = NavigationBarItemDefaults.colors(
                        indicatorColor = Color(250, 250, 250),
                        selectedIconColor = Color(150, 154, 255)
                    ),
                    selected = selectedItemIndex == index,
                    onClick = { selectedItemIndex = index },
                    icon = {
                        if (selectedItemIndex == index) {
                            Icon(
                                painter = n.selectedIcon!!,
                                contentDescription = n.title
                            )
                        } else {
                            Icon(
                                painter = n.unselectedIcon!!,
                                contentDescription = n.title
                            )
                        }
                    }
                )
            }
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PreviewNav(){
    BottomNav()
}