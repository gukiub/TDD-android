package com.gustavo.pokedex

import android.app.Application
import androidx.lifecycle.DefaultLifecycleObserver
import com.gustavo.pokedex.network.services
import okhttp3.logging.HttpLoggingInterceptor

class PokemonApplication: Application(), DefaultLifecycleObserver {

//    private fun startKoin() {
//        startKoin {
//            androidLogger(HttpLoggingInterceptor.Level.NONE)
//        }
}