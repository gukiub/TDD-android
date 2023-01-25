package com.br.gustavo.outsideintdd

import android.util.Log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class Engine(
    var temperature: Int = 15,
    var isTurnedOn: Boolean = false
) {
    suspend fun turnOn(): Flow<Int> {
        isTurnedOn = true

        return flow {
            Log.d("COURSE", "Engine has turned on")

            delay(2000)
            temperature = 25
            emit(temperature)

            delay(2000)
            temperature = 50
            emit(temperature)

            delay(2000)
            temperature = 95
            emit(temperature)
        }
    }
}