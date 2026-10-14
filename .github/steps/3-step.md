# Paso 3: Físicas 2D, Gravedad y Rebote ⚡

¡Excelente! Ya tenemos geometría y máscaras de colisión. Ahora daremos vida a los objetos con un **motor de físicas por integración de Euler**.

---

### 🧠 ¿Cómo funciona la física en un bucle de juego?
En cada fotograma, recibimos el tiempo transcurrido en milisegundos (`dtMs`). Convertimos esto a segundos (`d = dtMs / 1000.0`):
1. **Posición:** Se suma la velocidad escalada por el tiempo:
   `obj.x += obj.vx * d`
   `obj.y += obj.vy * d`
2. **Gravedad:** Si el objeto tiene masa (`mass > 0`) y está en el aire (`y > 0`), la velocidad vertical disminuye:
   `obj.vy -= obj.mass * d`
3. **Límites y Rebote:** Si el objeto choca contra el suelo (`y < floor`), se limita la posición al suelo y se invierte la velocidad vertical multiplicada por el coeficiente de restitución:
   `obj.vy *= -obj.bounce`
4. **Fricción:** Al deslizarse sobre el suelo:
   `obj.vx *= (1.0 - obj.friction)`

---

### 🎯 Tu Misión en este Paso

1. Abre el archivo:
   `app/shared/src/commonMain/kotlin/io/github/kevinah95/l07_activity/core/Game.kt`

2. Revisa el método `updatePhysics(dtMs: Double)`.
   Asegúrate de que los cálculos de integración de velocidad, aceleración gravitacional y rebote en límites estén implementados según los TODOs.

---

### 🧪 Validación Local
Ejecuta la prueba unitaria del Paso 3:

```bash
cd app
./gradlew :shared:jvmTest --tests "*Step3PhysicsTest*"
```

---

### 🚀 Para avanzar
Haz un commit y push a la rama `main`:
```bash
git add .
git commit -m "paso-3: físicas 2D y gravedad"
git push origin main
```
El bot verificará tu solución y desbloqueará el **Paso 4**.
