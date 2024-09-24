package com.example.blume_mobile.utils.masks

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

object PhoneOffSetMap : OffsetMapping {
    override fun originalToTransformed(offset: Int): Int {
        return when {
            offset > 6 -> offset + 4
            offset > 1 -> offset + 3
            offset > 0 -> offset + 1
            else -> offset
        }

    }

    override fun transformedToOriginal(offset: Int): Int {
       return when {
           offset >= 11 -> offset - 4
           offset >= 5 -> offset - 3
           offset == 4 -> offset - 2
           offset >= 2 -> offset - 1
           else -> offset

       }
    }
}

class PhoneMask : VisualTransformation{
    override fun filter(text: AnnotatedString): TransformedText {

        // mapeia trazendo valor e indice
        val phone = text.text.mapIndexed { i, c ->
            // mapeia quando o indice é um dos indices especificados, senao só retorna o valor inputado
            when(i){
                0 -> "($c"
                1 -> "$c) "
                6 -> "$c-"
                else -> c
            }

        }.joinToString(separator = "") // naturalmente junta os caracteres da string mapeada colocando , e espaço caso não tenha parametros
        // separados vazio impede esse comportamento

        return TransformedText(AnnotatedString(phone), PhoneOffSetMap) // valor, deslocamento (o deslocamento padrão Identity é o mais usado, poreém nesse caso é necessário um totalmente custom)
    }
}