package io.github.kevinah95.l07_activity.core

import io.github.kevinah95.l07_activity.entities.createSpell
import kotlin.math.abs

data class Stage(
    var width: Double = 400.0,
    var height: Double = 200.0,
    var floor: Double = 0.0,
    var ceiling: Double = 200.0
)

data class SpellState(
    var targetAngle: Double = 0.5,
    var basePower: Double = 380.0,
    var maxCasts: Int = 3,
    var casts: Int = 3,
    var castRechargeRate: Double = 1000.0,
    var castRechargeTimer: Double = 0.0
)

class Game : GameSession {
    val stage: Stage = Stage()
    val objects: MutableList<GameObject> = mutableListOf()
    lateinit var player: GameObject
    val spell: SpellState = SpellState()

    override fun spawn(gameObject: GameObject, x: Double, y: Double) {
        gameObject.x = x
        gameObject.y = y
        gameObject.gameSession = this
        objects.add(gameObject)
    }

    override fun despawn(gameObject: GameObject) {
        objects.remove(gameObject)
    }

    fun update(dtMs: Double) {
        updateSpells(dtMs)
        updatePhysics(dtMs)
    }

    private fun updateSpells(dtMs: Double) {
        if (spell.casts < spell.maxCasts) {
            spell.castRechargeTimer += dtMs
            if (spell.castRechargeTimer >= spell.castRechargeRate) {
                spell.casts += 1
                spell.castRechargeTimer = 0.0
            }
        }
    }

    fun updatePhysics(dtMs: Double) {
        val d = dtMs / 1000.0
        val currentObjects = objects.toList()

        for (obj in currentObjects) {
            // Paso 3.1: integrar posición según velocidad
            obj.x += obj.vx * d
            obj.y += obj.vy * d

            // Paso 3.2: gravedad hacia abajo si tiene masa y está en el aire
            if (obj.mass > 0 && obj.y > 0) {
                obj.vy -= obj.mass * d
            }

            // Paso 3.3: restricción contra el suelo y techo (rebote y fricción)
            val lower = stage.floor
            val upper = stage.ceiling - obj.spriteHeight

            if (obj.y < lower || obj.y > upper) {
                obj.y = clamp(obj.y, lower, upper)
                if (abs(obj.vy) >= 10.0 || obj.despawnOnBounce) {
                    obj.onBounce()
                }
                obj.vy *= -obj.bounce
            }

            if (obj.y == lower || obj.y == upper) {
                obj.vx *= (1.0 - obj.friction)
            }

            if (obj.x < 0.0 || obj.x > stage.width) {
                if (obj.isTagged(Tags.SPELL)) {
                    despawn(obj)
                }
            }
        }

        // Fase 2: colisiones entre objetos usando AABB y canCollideWith()
        for (obj in currentObjects) {
            for (target in currentObjects) {
                if (obj.canCollideWith(target) && obj.bounds().overlaps(target.bounds())) {
                    obj.onCollision(target)
                }
            }
        }
    }

    fun damage(target: GameObject, amount: Int, dealer: GameObject? = null) {
        val dmg = Damage(amount, dealer)
        target.hp = clamp(target.hp - dmg.amount, 0, target.maxHp)
        if (target.hp <= 0) {
            die(target)
        }
    }

    fun die(target: GameObject) {
        despawn(target)
    }

    // TODO Paso 4.2: completar la lógica de disparo
    fun castSpell(): Boolean {
        return false
    }
}