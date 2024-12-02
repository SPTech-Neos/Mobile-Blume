package com.example.blume_mobile.models.di

import android.provider.ContactsContract.CommonDataKinds.Phone

data class UserSession(
    var id: Int = 0,
    val token: String = "",
    var email: String = "",
    val phone: Phone? = null
)
