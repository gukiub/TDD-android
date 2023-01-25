package com.br.gustavo.myfirstunittest

class Engine (
    val cc: Int,
    val horsePower: Int,
    var temperature: Int = 15,
    var isTurnedOn: Boolean = false
    ) {
    fun turnOn(){
        isTurnedOn = true
        temperature = 95
    }

    fun turnOff() {
        isTurnedOn = false
        temperature = 15
    }
}