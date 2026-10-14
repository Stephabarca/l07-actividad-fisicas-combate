# Paso 4: Hechizos Balísticos y Sistema de Daño 🔮

¡Último paso! Ahora conectaremos todo: crearemos la entidad del proyectil de hechizo, permitiremos que Norman dispare proyectiles balísticos con ángulo dinámico y aplicaremos daño al colisionar con los aldeanos.

---

### 🧠 ¿Cómo se compone el disparo en Norman?
1. **El Proyectil (`createSpell()`):** Es un `GameObject` configurado con etiqueta `Tags.SPELL`, máscara `Tags.LIVING`, masa para curva parabólica (`mass = 100.0`), y un callback `onCollisionAction` que llama a `gameSession.damage(target, 1, this)`.
2. **El Disparo (`castSpell()`):** 
   - Verifica si Norman tiene cargas (`spell.casts > 0`).
   - Consume 1 carga.
   - Calcula el vector de dirección con `vectorFromAngle(spell.targetAngle)`.
   - Asigna velocidades `vx = dir.x * power` y `vy = dir.y * power`.
   - Spawnea el hechizo en el centro de Norman.

---

### 🎯 Tu Misión en este Paso

1. Abre el archivo:
   `app/shared/src/commonMain/kotlin/io/github/kevinah95/l07_activity/entities/Entities.kt`
   Revisa `createSpell()` y verifica la configuración de etiquetas, masa y el callback de colisión que inflige daño.

2. Abre el archivo:
   `app/shared/src/commonMain/kotlin/io/github/kevinah95/l07_activity/core/Game.kt`
   Revisa el método `castSpell()` para asegurar que decrementa los casts y lanza el proyectil en la dirección de `spell.targetAngle`.

---

### 🧪 Validación Local
Ejecuta la prueba unitaria del Paso 4:

```bash
cd app
./gradlew :shared:jvmTest --tests "*Step4SpellCombatTest*"
```

Para verificar todas las pruebas de la práctica juntas:
```bash
cd app
./gradlew :shared:jvmTest
```

---

### 🚀 Para finalizar
Haz un commit y push a la rama `main`:
```bash
git add .
git commit -m "paso-4: proyectil balístico y daño de hechizo"
git push origin main
```
El bot verificará tu solución, publicará la conclusión final y cerrará el issue con honores.
