package io.github.kevinah95.l07_activity

import io.github.kevinah95.l07_activity.core.*
import io.github.kevinah95.l07_activity.entities.*
import korlibs.event.Key
import korlibs.image.bitmap.Bitmap
import korlibs.image.bitmap.Bitmap32
import korlibs.image.bitmap.sliceWithSize
import korlibs.image.color.Colors
import korlibs.image.format.readBitmap
import korlibs.io.file.std.resourcesVfs
import korlibs.korge.Korge
import korlibs.korge.input.keys
import korlibs.korge.input.mouse
import korlibs.korge.view.*
import korlibs.math.geom.ScaleMode
import korlibs.math.geom.Size
import korlibs.render.GameWindow
import korlibs.time.*
import kotlin.math.atan2

suspend fun launchCombatDemo() {
    Korge(
        virtualSize = Size(800, 600),
        windowSize = Size(800, 600),
        title = "Práctica 07: Físicas 2D, Proyectiles y Combate",
        backgroundColor = Colors["#1e1e2e"],
        quality = GameWindow.Quality.QUALITY,
        scaleMode = ScaleMode.SHOW_ALL
    ) {
        val bitmap: Bitmap = try {
            resourcesVfs["sprites.png"].readBitmap()
        } catch (_: Throwable) {
            Bitmap32(160, 80)
        }

        val normanSlice = bitmap.sliceWithSize(16, 18, 16, 15)
        val villagerSlice = bitmap.sliceWithSize(32, 18, 14, 15)
        val spellSlice = bitmap.sliceWithSize(11, 33, 8, 8)

        val game = Game()
        val player = createPlayer()
        game.player = player
        game.spawn(player, 60.0, 0.0)

        // Spawneamos 3 aldeanos objetivo distribuidos en la arena
        val v1 = createVillager()
        game.spawn(v1, 320.0, 0.0)
        val v2 = createVillager()
        game.spawn(v2, 460.0, 0.0)
        val v3 = createVillager()
        game.spawn(v3, 600.0, 0.0)

        // UI Header
        solidRect(800.0, 60.0, Colors["#181825"])
        text("PRÁCTICA 07: FÍSICAS Y SISTEMA DE COMBATE", textSize = 20.0, color = Colors["#f9e2af"]) {
            xy(20.0, 15.0)
        }

        // Arena
        val arena = solidRect(760.0, 420.0, Colors["#11111b"]) {
            xy(20.0, 80.0)
        }
        game.stage.width = 760.0
        game.stage.height = 420.0
        game.stage.floor = 0.0
        game.stage.ceiling = 420.0

        // Contenedor dinámico de sprites
        val objectsContainer = container()

        // UI Footer con datos
        solidRect(760.0, 75.0, Colors["#181825"]) {
            xy(20.0, 510.0)
        }
        val infoText = text("", textSize = 14.0, color = Colors["#cdd6f4"]) {
            xy(35.0, 520.0)
        }
        val controlsText = text("Controles: [Click Izquierdo / Espacio] Disparar  |  [Mueve el ratón] Apuntar ángulo", textSize = 12.0, color = Colors["#89b4fa"]) {
            xy(35.0, 550.0)
        }

        // Eventos de entrada
        mouse {
            onMove {
                val mx = it.currentPosGlobal.x - arena.x
                val my = (arena.y + arena.height) - it.currentPosGlobal.y
                val px = player.x + player.spriteWidth / 2.0
                val py = player.y + player.spriteHeight / 2.0
                game.spell.targetAngle = atan2(my - py, mx - px)
            }
            down {
                val mx = it.currentPosGlobal.x - arena.x
                val my = (arena.y + arena.height) - it.currentPosGlobal.y
                val px = player.x + player.spriteWidth / 2.0
                val py = player.y + player.spriteHeight / 2.0
                game.spell.targetAngle = atan2(my - py, mx - px)
                game.castSpell()
            }
        }

        keys {
            down(Key.SPACE) {
                game.castSpell()
            }
        }

        // Bucle principal de actualización (60 FPS)
        addUpdater { dt ->
            game.update(dt.milliseconds)

            // Renderizar entidades
            objectsContainer.removeChildren()
            for (obj in game.objects.toList()) {
                val slice = when (obj.tags) {
                    Tags.SPELL -> spellSlice
                    Tags.PLAYER or Tags.UNDEAD -> normanSlice
                    else -> villagerSlice
                }

                val screenX = arena.x + obj.x
                val screenY = (arena.y + arena.height) - obj.y - obj.spriteHeight

                objectsContainer.image(slice) {
                    xy(screenX, screenY)
                    scale(3.0)
                }
            }

            val livingCount = game.objects.count { it.isTagged(Tags.LIVING) }
            val status = if (livingCount == 0) " | 🏆 ¡TODOS LOS ENEMIGOS DERROTADOS!" else ""
            infoText.text = "Cargas de Hechizo: ${game.spell.casts}/${game.spell.maxCasts}  |  Enemigos Vivos: $livingCount  |  Ángulo: ${(game.spell.targetAngle * 180 / 3.14159).toInt()}°$status"
        }
    }
}
