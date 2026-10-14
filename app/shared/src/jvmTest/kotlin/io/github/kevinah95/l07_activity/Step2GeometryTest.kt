package io.github.kevinah95.l07_activity

import io.github.kevinah95.l07_activity.core.Rect2D
import io.github.kevinah95.l07_activity.core.vectorFromAngle
import kotlin.math.PI
import kotlin.math.abs
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Step2GeometryTest {

    @Test
    fun testRect2DOverlaps() {
        val r1 = Rect2D(x = 10.0, y = 10.0, width = 20.0, height = 20.0)
        val r2 = Rect2D(x = 25.0, y = 25.0, width = 20.0, height = 20.0) // Se solapa
        val r3 = Rect2D(x = 100.0, y = 100.0, width = 20.0, height = 20.0) // Lejos

        assertTrue(r1.overlaps(r2), "r1 y r2 deben solaparse")
        assertTrue(r2.overlaps(r1), "La colisión debe ser simétrica")
        assertFalse(r1.overlaps(r3), "r1 y r3 están separados y no deben solaparse")
    }

    @Test
    fun testVectorFromAngle() {
        val right = vectorFromAngle(0.0)
        assertTrue(abs(right.x - 1.0) < 0.001 && abs(right.y - 0.0) < 0.001, "Ángulo 0 debe apuntar a (1, 0)")

        val up = vectorFromAngle(PI / 2.0)
        assertTrue(abs(up.x - 0.0) < 0.001 && abs(up.y - 1.0) < 0.001, "Ángulo PI/2 debe apuntar a (0, 1)")
    }
}
