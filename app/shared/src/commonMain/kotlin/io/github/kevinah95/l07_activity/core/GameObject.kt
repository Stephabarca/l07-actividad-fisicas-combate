package io.github.kevinah95.l07_activity.core

interface GameSession {
    fun spawn(gameObject: GameObject, x: Double = gameObject.x, y: Double = gameObject.y)
    fun despawn(gameObject: GameObject)
}

open class GameObject {
    // Físicas y Posición
    var x: Double = 0.0
    var y: Double = 0.0
    var vx: Double = 0.0
    var vy: Double = 0.0
    var mass: Double = 0.0
    var bounce: Double = 0.0
    var friction: Double = 0.0

    // Render y Dimensiones
    var spriteName: String = ""
    var spriteWidth: Int = 16
    var spriteHeight: Int = 16

    // Lógica y Colisiones
    var tags: Int = 0
    var collisionMask: Int = 0
    var hp: Int = 0
    var maxHp: Int = 0
    var despawnOnCollision: Boolean = false
    var despawnOnBounce: Boolean = false
    var groupId: Int = 0

    // Callbacks
    var onCollisionAction: ((GameObject) -> Unit)? = null
    var onBounceAction: (() -> Unit)? = null

    var gameSession: GameSession? = null

    fun isTagged(mask: Int): Boolean = (tags and mask) != 0

    /**
     * Determina si este objeto debe evaluar colisión física con [target].
     *
     * TODO Paso 1.2: Un objeto puede colisionar con [target] si:
     * 1. No es el mismo objeto (this !== target).
     * 2. Su máscara de colisión coincide con las etiquetas del objetivo: (collisionMask and target.tags) != 0.
     */
    fun canCollideWith(target: GameObject): Boolean {
        // TODO: Reemplaza este false por la condición requerida
        return false
    }

    fun bounds(): Rect2D = Rect2D(x, y, spriteWidth.toDouble(), spriteHeight.toDouble())

    fun center(): Point2D = Point2D(x + spriteWidth / 2.0, y + spriteHeight / 2.0)

    open fun onCollision(target: GameObject) {
        onCollisionAction?.invoke(target)
        if (despawnOnCollision) {
            gameSession?.despawn(this)
        }
    }

    open fun onBounce() {
        onBounceAction?.invoke()
        if (despawnOnBounce) {
            gameSession?.despawn(this)
        }
    }
}
