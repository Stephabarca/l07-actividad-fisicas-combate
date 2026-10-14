<img src="https://octodex.github.com/images/spidertocat.png" align="right" height="100px" alt="Spidertocat indicando error" />

### ⚠️ Las pruebas no pasaron en el Paso 2 (Geometría y Detección AABB)

La prueba unitaria `Step2GeometryTest` no superó todas las verificaciones.

> 🔍 **Pistas para encontrar el error en `Geometry.kt`:**
> - En `intersects(a: Rect, b: Rect)`: Dos rectángulos **no** colisionan si uno está totalmente a la izquierda, derecha, arriba o abajo del otro:
>   - `!(aRight < bLeft || aLeft > bRight || aTop < bBottom || aBottom > bTop)`.
> - Recuerda calcular los límites correctamente:
>   - `left = r.x`, `right = r.x + r.width`, `bottom = r.y`, `top = r.y + r.height`.
> - En `pointInRect`: Comprueba que `px` esté entre `left` y `right`, y que `py` esté entre `bottom` y `top`.

💡 Puedes ver el reporte detallado ejecutando la prueba localmente:
```bash
cd app
./gradlew :shared:jvmTest --tests "*Step2GeometryTest*"
```

¡Revisa `Geometry.kt`, corrige el cálculo y vuelve a subir tus cambios con `git push`! 🧐
