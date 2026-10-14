# Paso 1: Máscaras de Bits (Bitmasks) y Filtrado de Colisiones 🏷️

¡Bienvenido a la **Práctica 07**! En esta práctica aprenderás a construir el motor de físicas, colisiones y proyectiles para nuestro juego de Norman.

---

### 🧠 ¿Por qué usamos Bitmasks en videojuegos?
En lugar de tener múltiples booleanos (`isPlayer`, `isEnemy`, `isCorpse`) o cadenas de texto, los motores de videojuegos de alto rendimiento utilizan **máscaras de bits**:
- Cada categoría ocupa una posición binaria: `1 shl 0` (1), `1 shl 1` (2), `1 shl 2` (4), `1 shl 3` (8)...
- Podemos combinar etiquetas con `or`: `val tags = Tags.PLAYER or Tags.UNDEAD`
- Y verificar si una entidad coincide con una máscara con `and`: `(collisionMask and target.tags) != 0`

---

### 🎯 Tu Misión en este Paso

1. Abre el archivo:
   `app/shared/src/commonMain/kotlin/io/github/kevinah95/l07_activity/core/Tags.kt`
   Verifica que los valores de cada etiqueta usen el desplazamiento a nivel de bits `1 shl N`.

2. Abre el archivo:
   `app/shared/src/commonMain/kotlin/io/github/kevinah95/l07_activity/core/GameObject.kt`
   Revisa la función `canCollideWith(target: GameObject)` y asegúrate de que:
   - Un objeto nunca colisione consigo mismo (`this !== target`).
   - La máscara `collisionMask` coincida con las etiquetas del objetivo: `(collisionMask and target.tags) != 0`.

---

### 🧪 Validación Local
Ejecuta la prueba unitaria del Paso 1 en tu terminal:

```bash
cd app
./gradlew :shared:jvmTest --tests "*Step1TagsTest*"
```
*(O desde la raíz con Taskfile: `task test`)*

---

### 🚀 Para avanzar
Haz un commit y push a la rama `main`:
```bash
git add .
git commit -m "paso-1: máscaras de bits y filtrado de colisiones"
git push origin main
```
El bot verificará tu solución y publicará el **Paso 2** en este issue.
