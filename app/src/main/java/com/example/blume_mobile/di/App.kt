package com.example.blume_mobile.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin
class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidContext(this@App)
            // aqui estamos dizendo para o Koin usar o módulo que criamos
            modules(userModel)
            // modules(moduloXYZ)
            // poderiamos ter mais de um módulo, se necessário
        }
    }
}