package com.example.blume_mobile.ui.photoPicker

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.blume_mobile.R
import com.example.blume_mobile.ui.theme.Gray100
import com.example.blume_mobile.ui.theme.Gray700
import com.example.blume_mobile.ui.theme.Violet300
import com.example.blume_mobile.ui.theme.poppins

@Composable
fun ImagePreview(
    url: Uri? = null
) {
    if (url == null) {
        Image(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape),
            painter = painterResource(id = R.drawable.photo_placeholder),
            contentDescription = "Imagem padrão quando não há escolha do usuário"
        )
    }else{
        AsyncImage(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape),
            model = url,
            contentDescription = "Imagem escolhida pelo usuário",
            placeholder = painterResource(id = R.drawable.photo_placeholder),
            contentScale = ContentScale.Crop
        )
    }

}

@Composable
fun UploadPicker(onClick: () -> Unit = {}) {
    Row(
        Modifier
            .width(150.dp)
            .height(40.dp)
            .clip(RoundedCornerShape(15.dp))
            .border(shape = RoundedCornerShape(15.dp), color = Violet300, width = 2.dp)
            .background(Gray100)
            .clickable(enabled = true){
                onClick()
            }
            ,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            Modifier
                .size(
                    height = 40.dp,
                    width = 50.dp
                )
                .clip(RoundedCornerShape(topStart = 20.dp, bottomStart = 20.dp))
                .background(Violet300),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.upload),
                contentDescription = "Simbolo de seta para cima",
                Modifier.size(30.dp)
            )
        }
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Text(
                "Selecionar", style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontFamily = poppins,
                    fontSize = 14.sp,
                    color = Gray700
                )
            )
        }

    }
}

@Composable
fun PhotoSelector(urlState: Uri?, onUrlChange:(Uri) -> Unit = {}) {
    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
        //When the user has selected a photo, its URL is returned here
        onUrlChange(uri!!)
    }

    Row(
        Modifier
            .fillMaxWidth()
            .height(80.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            Modifier.fillMaxWidth(0.3f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            ImagePreview(urlState)
            Text(
                "Foto de Perfil", style = TextStyle(
                    color = Gray700,
                    fontFamily = poppins,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp
                )
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            if (urlState == null) {
                Text(
                    "nenhum arquivo selecionado", style = TextStyle(
                        fontFamily = poppins,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp,
                        color = Gray700
                    )
                )
            }
            UploadPicker(){
                launcher.launch(
                    PickVisualMediaRequest(
                        mediaType = ActivityResultContracts.PickVisualMedia.ImageOnly
                    )
                )
            }
        }

    }
}

@Preview
@Composable
fun PhotoPickerPreview() {
    PhotoSelector(null)
}