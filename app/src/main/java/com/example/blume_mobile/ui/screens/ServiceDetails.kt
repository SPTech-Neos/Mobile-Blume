package com.example.blume_mobile.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DatePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.blume_mobile.R
import com.example.blume_mobile.data.sampleCategories
import com.example.blume_mobile.models.service.Service
import com.example.blume_mobile.ui.components.buttons.CustomButton
import com.example.blume_mobile.ui.components.cards.BestRated
import com.example.blume_mobile.ui.components.datePicker.ScheduleDtePicker
import com.example.blume_mobile.ui.components.timePicker.ScheduleTimePicker
import com.example.blume_mobile.ui.components.titles.TitleBlume
import com.example.blume_mobile.ui.theme.Gray100
import com.example.blume_mobile.ui.theme.Gray500
import com.example.blume_mobile.ui.theme.Gray700
import com.example.blume_mobile.ui.theme.Violet50
import com.example.blume_mobile.ui.theme.Violet500
import com.example.blume_mobile.ui.theme.poppins
import com.example.blume_mobile.ui.viewModels.ServiceDetailsViewModel
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ServiceDetails(
    service: Service,
    navController: NavController,
    viewModel: ServiceDetailsViewModel
) {
    var showModal by remember {
        mutableStateOf(false)
    }

    var showEmployees by remember {
        mutableStateOf(true)
    }

    var showDateTime by remember {
        mutableStateOf(false)
    }

    var selectedEmployee by remember {
        mutableStateOf(0)
    }

    val currentTime = Calendar.getInstance()

    val timePickerState = rememberTimePickerState(
        initialHour = currentTime.get(Calendar.HOUR_OF_DAY),
        initialMinute = currentTime.get(Calendar.MINUTE),
        is24Hour = true,
    )

    val state by viewModel.uiState.collectAsState()
    Log.i("select e", "${selectedEmployee}")

    Column(
        Modifier
            .fillMaxSize(),
        Arrangement.Center,
        Alignment.CenterHorizontally
    ) {
        Column(
            Modifier
                .fillMaxSize(0.92f)
                .padding(top = 6.dp)
        ) {
            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(38.dp)
                        .clip(CircleShape)
                        .background(Violet500), contentAlignment = Alignment.Center
                ) {
                    Image(
                        modifier = Modifier,
                        painter = painterResource(id = R.drawable.arrow),
                        contentDescription = "Retornar página"
                    )
                }
                Spacer(modifier = Modifier.width(77.dp))
                TitleBlume()
            }

            Column(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(top = 50.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                if (service.imgUrl != null) {
                    AsyncImage(
                        modifier = Modifier
                            .size(
                                width = 300.dp,
                                height = 200.dp
                            )
                            .clip(RoundedCornerShape(10.dp)),
                        model = service.imgUrl,
                        contentDescription = "Imagem de perfil do estabelecimento",
                        placeholder = painterResource(R.drawable.photo_placeholder),
                        contentScale = ContentScale.Crop,
                    )
                } else {
                    Image(
                        modifier = Modifier
                            .size(
                                width = 200.dp,
                                height = 400.dp
                            )
                            .clip(CircleShape),
                        painter = painterResource(id = R.drawable.photo_placeholder),
                        contentDescription = "Imagem padrão quando não há escolha do usuário"
                    )
                }

                Column(
                    Modifier.fillMaxWidth(0.8f),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = service.specification, style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = poppins,
                            fontWeight = FontWeight.W700,
                            color = Gray700,
                            textAlign = TextAlign.Center
                        )
                    )

                    Text(
                        text = "R$${service.price}", style = TextStyle(
                            fontSize = 16.sp,
                            fontFamily = poppins,
                            fontWeight = FontWeight.W400,
                            color = Gray700,
                            textAlign = TextAlign.Center
                        )
                    )
                }

                Column(
                    Modifier.fillMaxWidth(0.8f),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Informações do produto: ", style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = poppins,
                            fontWeight = FontWeight.W700,
                            color = Gray700,
                            textAlign = TextAlign.Center
                        )
                    )

                    Row(
                        Modifier.fillMaxWidth(0.8f)
                    ) {
                        Text(
                            text = "Tipo: ", style = TextStyle(
                                fontSize = 16.sp,
                                fontFamily = poppins,
                                fontWeight = FontWeight.W700,
                                color = Gray700,
                                textAlign = TextAlign.Center
                            )
                        )

                        Text(
                            text = service.serviceType.name, style = TextStyle(
                                fontSize = 16.sp,
                                fontFamily = poppins,
                                fontWeight = FontWeight.W400,
                                color = Gray700,
                                textAlign = TextAlign.Center
                            )
                        )
                    }

                    Row(
                        Modifier.fillMaxWidth(0.8f)
                    ) {
                        Text(
                            text = "Categoria: ", style = TextStyle(
                                fontSize = 16.sp,
                                fontFamily = poppins,
                                fontWeight = FontWeight.W700,
                                color = Gray700,
                                textAlign = TextAlign.Center
                            )
                        )

                        Text(
                            text = service.serviceType.serviceCategory.name, style = TextStyle(
                                fontSize = 16.sp,
                                fontFamily = poppins,
                                fontWeight = FontWeight.W400,
                                color = Gray700,
                                textAlign = TextAlign.Center
                            )
                        )
                    }
                }

                Surface(
                    shape = RoundedCornerShape(8.dp),
                ) {
                    Row(
                        Modifier
                            .fillMaxWidth(0.9f)
                            .height(80.dp)
                            .background(Violet50)
                            .padding(horizontal = 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Spacer(modifier = Modifier.width(20.dp))
                        Column(
                            Modifier.fillMaxWidth(0.5f),
                            verticalArrangement = Arrangement.spacedBy(10.dp),
                            horizontalAlignment = Alignment.Start
                        ) {
                            Text(
                                text = service.specification, style = TextStyle(
                                    fontSize = 14.sp,
                                    fontFamily = poppins,
                                    fontWeight = FontWeight.W700,
                                    color = Gray700,
                                    textAlign = TextAlign.Center
                                )
                            )

                            Text(
                                text = "R$${service.price}", style = TextStyle(
                                    fontSize = 12.sp,
                                    fontFamily = poppins,
                                    fontWeight = FontWeight.W400,
                                    color = Gray700,
                                    textAlign = TextAlign.Center
                                )
                            )
                        }

                        CustomButton("Comprar", 300) {
                            showModal = true
                        }
                    }

                }

            }
        }
    }

    if (showModal) {


        service.id?.let { viewModel.getEmployeesByService(it) }
        if (state.employeeServices.isNotEmpty()) {
            Column(
                Modifier
                    .fillMaxSize()
                    .background(Gray500.copy(alpha = 0.5f)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                if (showEmployees) {
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        shadowElevation = 3.dp
                    ) {
                        Column(
                            Modifier
                                .size(width = 300.dp, height = 540.dp)
                                .background(Gray100)
                                .padding(20.dp)
                        ) {
                            Row(
                                Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 10.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(35.dp)
                                        .clip(CircleShape)
                                        .background(Violet500)
                                        .clickable(true) {
                                            showModal = false
                                        }, contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        modifier = Modifier,
                                        painter = painterResource(id = R.drawable.arrow),
                                        contentDescription = "Retornar página"
                                    )
                                }
                                Spacer(modifier = Modifier.width(23.dp))
                                Text(
                                    text = "AGENDAR SERVIÇO", style = TextStyle(
                                        fontSize = 15.sp,
                                        fontFamily = poppins,
                                        fontWeight = FontWeight.W700,
                                        color = Gray700,
                                        textAlign = TextAlign.Center
                                    )
                                )

                            }

                            Text(
                                text = "Escolha o profissional que vai realizar o serviço: ",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontFamily = poppins,
                                    fontWeight = FontWeight.W400,
                                    color = Gray700,
                                    textAlign = TextAlign.Center
                                )
                            )

                            LazyVerticalGrid(
                                columns = GridCells.Fixed(2),
                                verticalArrangement = Arrangement.spacedBy(16.dp),
                                horizontalArrangement = Arrangement.spacedBy(16.dp),
                                contentPadding = PaddingValues(vertical = 10.dp),
                                modifier = Modifier.padding(
                                    bottom = 20.dp,
                                    start = 20.dp,
                                    end = 20.dp
                                )
                            ) {
                                items(state.employeeServices) { e ->
                                    BestRated(
                                        name = e.employee.name,
                                        categories = sampleCategories,
                                        profile = e.employee.imgUrl,
                                        badges = false,
                                    ) {
                                        showEmployees = !showEmployees
                                        showDateTime = !showDateTime
                                        selectedEmployee = e.employee.id
                                    }
                                }

                            }

                        }
                    }
                } else if (showDateTime) {
                    Surface(
                        shape = RoundedCornerShape(8.dp),
                        shadowElevation = 3.dp
                    ) {
                        Column(
                            Modifier
                                .size(width = 300.dp, height = 540.dp)
                                .background(Gray100)
                                .padding(20.dp)
                        ) {
                            Row(
                                Modifier
                                    .fillMaxWidth()
                                    .padding(bottom = 10.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Box(
                                    modifier = Modifier
                                        .size(35.dp)
                                        .clip(CircleShape)
                                        .background(Violet500)
                                        .clickable(true) {
                                            showModal = false
                                        }, contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        modifier = Modifier,
                                        painter = painterResource(id = R.drawable.arrow),
                                        contentDescription = "Retornar página"
                                    )
                                }
                                Spacer(modifier = Modifier.width(23.dp))
                                Text(
                                    text = "AGENDAR SERVIÇO", style = TextStyle(
                                        fontSize = 15.sp,
                                        fontFamily = poppins,
                                        fontWeight = FontWeight.W700,
                                        color = Gray700,
                                        textAlign = TextAlign.Center
                                    )
                                )

                            }

                            Text(
                                text = "Escolha a data e a hora que será realizado o seu serviço:: ",
                                style = TextStyle(
                                    fontSize = 12.sp,
                                    fontFamily = poppins,
                                    fontWeight = FontWeight.W400,
                                    color = Gray700,
                                    textAlign = TextAlign.Center
                                )
                            )

                            Column(
                                Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                                ScheduleTimePicker(timePickerState)
                            }

                            Column(
                                Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                                ScheduleDtePicker()
                            }
                        }
                    }

                }
            }

        }
    }

}