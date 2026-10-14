<img src="https://octodex.github.com/images/spidertocat.png" align="right" height="100px" alt="Spidertocat indicando error" />

### ⚠️ Las pruebas no pasaron en el Paso 4 (Hechizos y Sistema de Combate)

La prueba unitaria `Step4SpellCombatTest` no superó todas las verificaciones.

> 🔍 **Pistas para encontrar el error:**
> - En `Spell`: Al invocar `castSpell`, comprueba que el proyectil tenga las etiquetas correctas (`Tags.SPELL` o `Tags.ENEMY_SPELL`), la máscara apropiada y el daño configurado (`damage = spell.damage`).
> - En `Game.kt` (`handleCombat`): Al colisionar un proyectil con un personaje objetivo:
>   - Debe restar la vida del objetivo: `target.hp -= spell.damage`.
>   - Si `target.hp <= 0`, marca `target.isAlive = false`.
>   - El proyectil debe consumirse: `spell.isAlive = false`.

💡 Puedes ver el reporte detallado ejecutando la prueba localmente:
```bash
cd app
./gradlew :shared:jvmTest --tests "*Step4SpellCombatTest*"
```

¡Revisa `Entities.kt` y `Game.kt`, corrige la lógica de combate y vuelve a subir tus cambios con `git push`! 🧐
