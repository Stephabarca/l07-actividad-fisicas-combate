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
     *
     * TODO Paso 2.1: Dos cajas colisionan si y solo si se solapan en ambos ejes X e Y:
     * - this.x < other.x + other.width
     * - this.x + this.width > other.x
     * - this.y < other.y + other.height
     * - this.y + this.height > other.y
     */
    fun overlaps(other: Rect2D): Boolean {
        // TODO: Implementar la condición AABB
        return false
    }
}

/**
 * Convierte un ángulo en radianes a un vector de dirección 2D normalizado (cos, sin).
 *
 * TODO Paso 2.2: Retorna un Point2D con x = cos(radians) e y = sin(radians).
 */
fun vectorFromAngle(radians: Double): Point2D {
    // TODO: Retornar Point2D con cos(radians) y sin(radians)
    return Point2D(0.0, 0.0)
}

fun clamp(value: Double, min: Double, max: Double): Double =
    if (value < min) min else if (value > max) max else value

fun clamp(value: Int, min: Int, max: Int): Int =
    if (value < min) min else if (value > max) max else value
