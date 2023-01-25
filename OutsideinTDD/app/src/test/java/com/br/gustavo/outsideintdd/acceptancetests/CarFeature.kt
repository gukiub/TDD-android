package com.br.gustavo.outsideintdd.acceptancetests


import com.br.gustavo.outsideintdd.Car
import com.br.gustavo.outsideintdd.Engine
import com.br.gustavo.outsideintdd.utils.MainCoroutineScopeRule
import junit.framework.TestCase
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

class CarFeature {

    private val engine = Engine()
    private val car = Car(engine, 6.0)

    @get:Rule
    var coroutineTestRule = MainCoroutineScopeRule()

    @Test
    fun carIsLoosingFuelWhenItTurnsOn() = runTest {

        car.turnOn()
        assertEquals(5.5, car.fuel)
    }

    @Test
    fun carIsTurningOnItsEngineAndIncreasesTheTemperatureGradually() = runTest {
        car.turnOn()

        coroutineTestRule.advanceTimeBy(2000)
        assertEquals(25, car.engine.temperature)

        coroutineTestRule.advanceTimeBy(2000)
        assertEquals(50, car.engine.temperature)

        coroutineTestRule.advanceTimeBy(2000)
        assertEquals(95, car.engine.temperature)

        assertTrue(car.engine.isTurnedOn)
    }

}