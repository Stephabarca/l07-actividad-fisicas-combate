<img src="https://octodex.github.com/images/spidertocat.png" align="right" height="100px" alt="Spidertocat indicando error" />

### ⚠️ Las pruebas no pasaron en el Paso 1 (Máscaras de Bits y Tags)

La prueba unitaria `Step1TagsTest` no superó todas las verificaciones.

> 🔍 **Pistas para encontrar el error:**
> - En `Tags.kt`, revisa que cada constante use desplazamientos de bits: `1 shl 0`, `1 shl 1`, `1 shl 2`, etc.
> - En `GameObject.kt`, asegúrate de que `canCollideWith` verifique que `this !== target` y que `(collisionMask and target.tags) != 0`.

💡 Puedes ver el reporte detallado ejecutando la prueba localmente:
```bash
cd app
./gradlew :shared:jvmTest --tests "*Step1TagsTest*"
```

¡Corrige los archivos y vuelve a subir tus cambios con `git push`! 🧐
