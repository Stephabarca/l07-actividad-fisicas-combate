# Paso 2: Geometría y Detección de Colisiones AABB 📐

¡Gran trabajo con las máscaras de bits! Ahora que podemos filtrar quién colisiona con quién, necesitamos la matemática para saber **cuándo sus áreas físicas se tocan en el espacio 2D**.

---

### 🧠 ¿Qué es una colisión AABB?
**AABB** significa *Axis-Aligned Bounding Box* (Caja delimitadora alineada con los ejes). Dos rectángulos alineados no rotados colisionan si y solo si se solapan simultáneamente en el eje X y en el eje Y:
```
this.x < other.x + other.width &&
this.x + this.width > other.x &&
this.y < other.y + other.height &&
this.y + this.height > other.y
```

Además, para apuntar nuestros hechizos, necesitamos convertir un ángulo en radianes a un vector unitario de dirección usando trigonometría:
- `x = cos(radians)`
- `y = sin(radians)`

---

### 🎯 Tu Misión en este Paso

1. Abre el archivo:
   `app/shared/src/commonMain/kotlin/io/github/kevinah95/l07_activity/core/Geometry.kt`

2. Implementa o verifica la función `overlaps(other: Rect2D)` en la clase `Rect2D`.

3. Revisa la función auxiliar `vectorFromAngle(radians: Double)` y comprueba que retorna un `Point2D` con `(cos(radians), sin(radians))`.

---

### 🧪 Validación Local
Ejecuta la prueba unitaria del Paso 2:

```bash
cd app
./gradlew :shared:jvmTest --tests "*Step2GeometryTest*"
```

---

### 🚀 Para avanzar
Haz un commit y push a la rama `main`:
```bash
git add .
git commit -m "paso-2: geometría y colisión AABB"
git push origin main
```
El bot verificará tu solución y desbloqueará el **Paso 3**.
