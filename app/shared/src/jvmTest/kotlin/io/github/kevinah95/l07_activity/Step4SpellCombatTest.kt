package io.github.kevinah95.l07_activity

import io.github.kevinah95.l07_activity.core.Game
import io.github.kevinah95.l07_activity.core.Tags
import io.github.kevinah95.l07_activity.entities.createPlayer
import io.github.kevinah95.l07_activity.entities.createSpell
import io.github.kevinah95.l07_activity.entities.createVillager
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Step4SpellCombatTest {

    @Test
    fun testCreateSpellConfiguration() {
        val spell = createSpell()
        assertEquals(Tags.SPELL, spell.tags, "El hechizo debe tener tags = Tags.SPELL")
        assertEquals(Tags.LIVING, spell.collisionMask, "El hechizo debe tener collisionMask = Tags.LIVING")
        assertTrue(spell.mass > 0, "El hechizo debe tener masa para curva parabólica")
        assertTrue(spell.despawnOnCollision, "El hechizo debe desaparecer tras impactar")
    }

    @Test
    fun testCastSpellConsumesCastAndSpawnsProjectile() {
        val game = Game()
        val player = createPlayer()
        game.player = player
        game.spawn(player, 50.0, 50.0)

        assertEquals(3, game.spell.casts)
        val success = game.castSpell()

        assertTrue(success, "castSpell debe retornar true si hay cargas disponibles")
        assertEquals(2, game.spell.casts, "Debe descontar 1 carga de hechizo")

        val spellInGame = game.objects.firstOrNull { it.isTagged(Tags.SPELL) }
        assertTrue(spellInGame != null, "El proyectil debe ser añadido a la lista de objetos de la partida")
        assertTrue(spellInGame.vx != 0.0 || spellInGame.vy != 0.0, "El proyectil debe tener velocidad inicial")
    }

    @Test
    fun testSpellDamagesVillagerOnCollision() {
        val game = Game()
        val player = createPlayer()
        game.player = player
        game.spawn(player, 10.0, 50.0)

        val villager = createVillager()
        game.spawn(villager, 100.0, 50.0)
        assertEquals(2, villager.hp)

        // Spawn a spell right overlapping with the villager
        val spell = createSpell()
        game.spawn(spell, 100.0, 50.0)

        // Simulamos 1 frame de física para detectar la colisión
        game.updatePhysics(16.0)

        // El aldeano debe haber recibido daño
        assertTrue(villager.hp < 2, "La colisión con el proyectil debe reducir los HP del enemigo")
    }
}
