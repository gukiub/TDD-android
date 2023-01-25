package com.br.gustavo.outsideintdd.unittests

import com.br.gustavo.outsideintdd.Car
import com.br.gustavo.outsideintdd.Engine
import com.br.gustavo.outsideintdd.utils.MainCoroutineScopeRule
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

class CarShould {

    private val engine: Engine = mock()
    private val car : Car

    init {
        runTest {
            whenever(engine.turnOn()).thenReturn(flow {
                delay(2000)
                emit(25)
                delay(2000)
                emit(50)
                delay(2000)
                emit(95)
            })
        }
        car = Car(engine, 5.0)
    }

    @get:Rule
    var coroutineTestRule = MainCoroutineScopeRule()

    @Test
    fun looseFuelWhenItTurnsOn() = runTest {
        car.turnOn()

        assertEquals(4.5, car.fuel)
    }

    @Test
    fun turnOnItsEngine() = runTest {
        car.turnOn()

        verify(engine, times(1)).turnOn()
    }

}

