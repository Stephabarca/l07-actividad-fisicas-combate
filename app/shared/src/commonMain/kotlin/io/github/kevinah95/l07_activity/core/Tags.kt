package io.github.kevinah95.l07_activity.core

/**
 * Máscaras de bits (Bitmasks) para identificar categorías de objetos y filtrar colisiones eficientemente.
 *
 * Cada etiqueta ocupa un bit individual (1 shl N) permitiendo combinar múltiples
 * categorías con el operador OR binario (`or`) y consultar con AND binario (`and`).
 */
object Tags {
    const val NONE: Int = 0

    // TODO Paso 1.1: Define las constantes de máscaras de bits desplazando 1 hacia la izquierda (1 shl N):
    // - CORPSE: 1 shl 0 (1)
    // - LIVING: 1 shl 1 (2)
    // - SPELL:  1 shl 2 (4)
    // - MOBILE: 1 shl 3 (8)
    // - PLAYER: 1 shl 4 (16)
    // - UNDEAD: 1 shl 5 (32)

    const val CORPSE: Int = 0
    const val LIVING: Int = 0
    const val SPELL: Int = 0
    const val MOBILE: Int = 0
    const val PLAYER: Int = 0
    const val UNDEAD: Int = 0
}
