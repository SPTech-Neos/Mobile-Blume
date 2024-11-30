package com.example.blume_mobile.ui.components.timePicker

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TimeInput
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerColors
import androidx.compose.material3.TimePickerLayoutType
import androidx.compose.material3.TimePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.blume_mobile.ui.theme.Gray100
import com.example.blume_mobile.ui.theme.Gray500
import com.example.blume_mobile.ui.theme.Gray700
import com.example.blume_mobile.ui.theme.Violet300
import com.example.blume_mobile.ui.theme.Violet50
import com.example.blume_mobile.ui.theme.Violet500
import java.util.Calendar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScheduleTimePicker(
    state: TimePickerState
) {

    Column {
        TimeInput(
            state = state,
            colors = TimePickerColors(
                clockDialSelectedContentColor = Violet300,
                clockDialColor = Gray100,
                containerColor = Gray100,
                clockDialUnselectedContentColor = Gray500,
                selectorColor = Violet50,
                timeSelectorSelectedContentColor = Gray100,
                timeSelectorSelectedContainerColor = Violet50,
                timeSelectorUnselectedContentColor = Gray100,
                timeSelectorUnselectedContainerColor = Gray500,
                periodSelectorBorderColor = Gray500,
                periodSelectorSelectedContentColor = Gray500,
                periodSelectorSelectedContainerColor = Gray500,
                periodSelectorUnselectedContentColor = Gray500,
                periodSelectorUnselectedContainerColor = Gray500,
            )
        )
    }
}