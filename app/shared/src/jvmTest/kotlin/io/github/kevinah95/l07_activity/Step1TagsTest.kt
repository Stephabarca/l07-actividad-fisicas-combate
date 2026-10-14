package io.github.kevinah95.l07_activity

import io.github.kevinah95.l07_activity.core.GameObject
import io.github.kevinah95.l07_activity.core.Tags
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Step1TagsTest {

    @Test
    fun testBitmaskValues() {
        assertEquals(1, Tags.CORPSE, "Tags.CORPSE debe ser 1 shl 0 (1)")
        assertEquals(2, Tags.LIVING, "Tags.LIVING debe ser 1 shl 1 (2)")
        assertEquals(4, Tags.SPELL, "Tags.SPELL debe ser 1 shl 2 (4)")
        assertEquals(8, Tags.MOBILE, "Tags.MOBILE debe ser 1 shl 3 (8)")
        assertEquals(16, Tags.PLAYER, "Tags.PLAYER debe ser 1 shl 4 (16)")
        assertEquals(32, Tags.UNDEAD, "Tags.UNDEAD debe ser 1 shl 5 (32)")
    }

    @Test
    fun testCanCollideWithSelfReturnsFalse() {
        val player = GameObject().apply {
            tags = Tags.PLAYER
            collisionMask = Tags.LIVING or Tags.PLAYER
        }
        assertFalse(
            player.canCollideWith(player),
            "Un objeto NUNCA debe colisionar consigo mismo (this !== target)"
        )
    }

    @Test
    fun testCanCollideWithMatchingMask() {
        val spell = GameObject().apply {
            tags = Tags.SPELL
            collisionMask = Tags.LIVING
        }
        val enemy = GameObject().apply {
            tags = Tags.LIVING or Tags.MOBILE
        }
        val friendly = GameObject().apply {
            tags = Tags.UNDEAD
        }

        assertTrue(
            spell.canCollideWith(enemy),
            "El hechizo debe colisionar con una entidad viva (collisionMask: LIVING, tags: LIVING)"
        )
        assertFalse(
            spell.canCollideWith(friendly),
            "El hechizo NO debe colisionar con aliados sin la etiqueta LIVING"
        )
    }
}
