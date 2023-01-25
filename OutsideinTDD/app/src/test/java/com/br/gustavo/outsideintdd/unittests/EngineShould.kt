package com.br.gustavo.outsideintdd.unittests

import com.br.gustavo.outsideintdd.Engine
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Test

class EngineShould {

    private val engine = Engine()

    @Test
    fun turnOn() = runTest {
        engine.turnOn()

        assertTrue(engine.isTurnedOn)
    }

    @Test
    fun riseTheTemperatureGraduallyWhenItTurnsOn() = runTest {
        val flow = engine.turnOn()
        val actual = flow.toList()


        assertEquals(listOf(25, 50, 95), actual)
    }
}