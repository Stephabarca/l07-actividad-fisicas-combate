package io.github.kevinah95.l07_activity.entities

import io.github.kevinah95.l07_activity.core.*

/**
 * Fábrica de entidades del juego.
 * Cada entidad es un [GameObject] configurado con sus tags, físicas y callbacks.
 */

fun createPlayer(): GameObject {
    return GameObject().apply {
        x = 20.0
        y = 0.0
        spriteName = "norman_idle"
        spriteWidth = 48
        spriteHeight = 45
        tags = Tags.PLAYER or Tags.UNDEAD
        collisionMask = Tags.LIVING
        hp = 5
        maxHp = 5
    }
}

fun createSpell(): GameObject {
    return GameObject().apply {
        spriteName = "spell_skull"
        spriteWidth = 24
        spriteHeight = 24
        tags = Tags.SPELL
        collisionMask = Tags.LIVING
        mass = 100.0
        friction = 0.1
        despawnOnCollision = true
        despawnOnBounce = true
        onCollisionAction = { target ->
            (gameSession as? Game)?.damage(target, 1, this)
        }
    }
}

fun createVillager(): GameObject {
    return GameObject().apply {
        x = 350.0
        y = 0.0
        spriteName = "villager"
        spriteWidth = 42
        spriteHeight = 45
        tags = Tags.LIVING or Tags.MOBILE
        collisionMask = Tags.PLAYER or Tags.SPELL
        hp = 2
        maxHp = 2
    }
}