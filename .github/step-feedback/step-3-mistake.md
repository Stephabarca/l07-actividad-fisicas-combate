<img src="https://octodex.github.com/images/spidertocat.png" align="right" height="100px" alt="Spidertocat indicando error" />

### ⚠️ Las pruebas no pasaron en el Paso 3 (Físicas 2D y Gravedad)

La prueba unitaria `Step3PhysicsTest` no superó todas las verificaciones.

> 🔍 **Pistas para encontrar el error en `updatePhysics`:**
> - **Integración de posición:** Verifica que la velocidad se multiplique por el tiempo transcurrido en segundos (`d = dtMs / 1000.0`): `obj.x += obj.vx * d` y `obj.y += obj.vy * d`.
> - **Gravedad:** Si el objeto tiene masa y está en el aire, la aceleración gravitacional debe **reducir** la velocidad vertical: `obj.vy -= obj.mass * d` *(asegúrate de restar, no sumar)*.
> - **Rebote en el suelo:** Al tocar el suelo, la velocidad vertical debe invertirse y amortiguarse con su coeficiente: `obj.vy *= -obj.bounce`.

💡 Puedes ver el reporte detallado ejecutando la prueba localmente:
```bash
cd app
./gradlew :shared:jvmTest --tests "*Step3PhysicsTest*"
```

¡Revisa el código en `Game.kt`, corrige el detalle y vuelve a subir tus cambios con `git push`! 🧐
