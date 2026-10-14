package io.github.kevinah95.l07_activity

import io.github.kevinah95.l07_activity.core.Game
import io.github.kevinah95.l07_activity.core.GameObject
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class Step3PhysicsTest {

    @Test
    fun testPositionIntegrationWithVelocity() {
        val game = Game()
        val obj = GameObject().apply {
            x = 0.0
            y = 100.0
            vx = 50.0 // 50 px por segundo
            vy = 20.0
        }
        game.spawn(obj)

        // Simulamos 1000 ms (1 segundo)
        game.updatePhysics(1000.0)

        assertEquals(50.0, obj.x, 0.1, "La posición X debe integrarse con vx * dt")
        assertEquals(120.0, obj.y, 0.1, "La posición Y debe integrarse con vy * dt")
    }

    @Test
    fun testGravityAccelerationDecreasesVerticalVelocity() {
        val game = Game()
        val obj = GameObject().apply {
            x = 50.0
            y = 100.0
            vx = 0.0
            vy = 0.0
            mass = 200.0 // Gravedad 200 px/s^2
        }
        game.spawn(obj)

        // 500 ms (medio segundo)
        game.updatePhysics(500.0)

        assertTrue(
            obj.vy < 0.0,
            "La gravedad debe reducir la velocidad vertical (vy negativa al caer)"
        )
        assertEquals(-100.0, obj.vy, 0.5, "vy debe reducirse por mass * dt")
    }

    @Test
    fun testFloorBounceAndFriction() {
        val game = Game()
        val obj = GameObject().apply {
            x = 50.0
            y = 0.0
            vx = 100.0
            vy = -50.0
            bounce = 0.5
            friction = 0.2
        }
        game.spawn(obj)

        game.updatePhysics(16.0)

        assertTrue(obj.y >= game.stage.floor, "El objeto no debe descender más allá del suelo")
        assertTrue(obj.vx < 100.0, "La fricción en el suelo debe desacelerar la velocidad horizontal vx")
    }
}
