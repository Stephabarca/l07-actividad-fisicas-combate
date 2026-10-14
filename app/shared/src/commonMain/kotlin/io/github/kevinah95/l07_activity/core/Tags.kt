package io.github.kevinah95.l07_activity.core

/**
 * Máscaras de bits (Bitmasks) para identificar categorías de objetos y filtrar colisiones eficientemente.
 *
 * Cada etiqueta ocupa un bit individual (1 shl N) permitiendo combinar múltiples
 * categorías con el operador OR binario (`or`) y consultar con AND binario (`and`).
 */
object Tags {
    const val NONE: Int = 0

    const val CORPSE: Int = 1 shl 0  // 1
    const val LIVING: Int = 1 shl 1  // 2
    const val SPELL: Int  = 1 shl 2  // 4
    const val MOBILE: Int = 1 shl 3  // 8
    const val PLAYER: Int = 1 shl 4  // 16
    const val UNDEAD: Int = 1 shl 5  // 32
}