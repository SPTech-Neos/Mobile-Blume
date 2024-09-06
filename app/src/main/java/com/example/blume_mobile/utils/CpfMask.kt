package com.example.blume_mobile.utils

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

object CpfOffSetMap : OffsetMapping {
    override fun originalToTransformed(offset: Int): Int {
        return when {
            offset > 9 -> offset + 3
            offset > 5 -> offset + 2
            offset > 2 -> offset + 1
            else -> offset
        }

    }

    override fun transformedToOriginal(offset: Int): Int {
        return when {
            offset > 9 -> offset - 4
            offset > 5 -> offset - 2
            offset > 2 -> offset - 1
            else -> offset
        }
    }
}

class CpfMask : VisualTransformation{
    override fun filter(text: AnnotatedString): TransformedText {

        // mapeia trazendo valor e indice
        val cpf = text.text.mapIndexed { i, c ->
            // mapeia quando o indice é um dos indices especificados, senao só retorna o valor inputado
            when(i){
                2 -> "$c."
                5 -> "$c."
                8 -> "$c-"
                else -> c
            }

        }.joinToString(separator = "") // naturalmente junta os caracteres da string mapeada colocando , e espaço caso não tenha parametros
        // separados vazio impede esse comportamento

        return TransformedText(AnnotatedString(cpf), CpfOffSetMap) // valor, deslocamento (o deslocamento padrão Identity é o mais usado, poreém nesse caso é necessário um totalmente custom)
    }
}