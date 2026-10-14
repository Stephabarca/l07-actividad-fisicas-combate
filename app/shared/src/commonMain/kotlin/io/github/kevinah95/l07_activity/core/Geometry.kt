package io.github.kevinah95.l07_activity.core

import kotlin.math.cos
import kotlin.math.sin

data class Point2D(val x: Double, val y: Double)

data class Rect2D(
    val x: Double,
    val y: Double,
    val width: Double,
    val height: Double
) {
    /**
     * Detección de colisión entre dos rectángulos alineados con los ejes (AABB).
     */
    fun overlaps(other: Rect2D): Boolean {
        return this.x < other.x + other.width &&
                this.x + this.width > other.x &&
                this.y < other.y + other.height &&
                this.y + this.height > other.y
    }
}

/**
 * Convierte un ángulo en radianes a un vector de dirección 2D normalizado (cos, sin).
 */
fun vectorFromAngle(radians: Double): Point2D {
    return Point2D(cos(radians), sin(radians))
}

fun clamp(value: Double, min: Double, max: Double): Double =
    if (value < min) min else if (value > max) max else value

fun clamp(value: Int, min: Int, max: Int): Int =
    if (value < min) min else if (value > max) max else value