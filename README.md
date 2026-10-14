<h1 align="center">Práctica 07: Físicas 2D, Proyectiles y Combate 💀</h1>
<h3 align="center">Bitmasks · Geometría AABB · Físicas por Integración · Proyectiles Balísticos</h3>

<p align="center">
  <a href="https://github.com/new?template_owner=kevinah95&template_name=l07-actividad-fisicas-combate&owner=%40me&name=l07-actividad-fisicas-combate&description=Mi+ejercicio+de+fisicas+y+combate&visibility=public">
    <img src="https://img.shields.io/badge/Copiar%20ejercicio-%232ea44f?style=for-the-badge&logo=github&logoColor=white" alt="Copiar ejercicio"/>
  </a>
</p>

---

## Bienvenido 👋

En esta práctica aprenderás a construir el motor de físicas, colisiones y combate balístico para **Norman The Necromancer**, partiendo de la base de sprites y renderizado de la Lección 06.

> **¿Para quién es este ejercicio?**
> Estudiantes que cursaron la Lección 06 de KorGE y quieren construir motores de física 2D en Kotlin Multiplatform.

---

## Lo que aprenderás y construirás

| # | Concepto | Lo que harás |
|---|---|---|
| 1 | **Máscaras de Bits (Tags)** | Filtrar colisiones con operadores a nivel de bits (`or`, `and`, `1 shl N`) |
| 2 | **Geometría AABB** | Calcular colisión rectangular entre cajas y vectores de apuntado angular |
| 3 | **Físicas 2D y Gravedad** | Implementar la integración de Euler con masa, rebotes y fricción de suelo |
| 4 | **Hechizos Balísticos** | Crear proyectiles dinámicos que se disparan en parábola y dañan a los enemigos |

---

## Prerrequisitos

Antes de comenzar necesitas:
- [ ] Conocimiento de Kotlin y la Lección 06 (Sprites y Bitmaps en KorGE)
- [ ] [Android Studio](https://developer.android.com/studio) o IntelliJ IDEA con JDK 17+
- [ ] [Task](https://taskfile.dev/) (opcional, pero recomendado)

---

## Cómo empezar

1. Haz clic en **"Copiar ejercicio"** arriba para crear tu propio repositorio desde esta plantilla.
2. Espera unos segundos a que GitHub Actions cree el **issue del ejercicio** automáticamente.
3. Sigue las instrucciones paso a paso detalladas en ese issue.
4. Cada vez que hagas un `push` a la rama `main`, el flujo de trabajo verificará tu solución y desbloqueará el siguiente paso.

---

## Estructura del proyecto

```
l07-actividad-fisicas-combate/
├── README.md
├── Taskfile.yml                               ← Comandos rápidos (task test, task desktop)
├── .github/
│   ├── steps/                                 ← Instrucciones de cada paso
│   └── workflows/                             ← Automatización con GitHub Skills
└── app/                                       ← Proyecto Gradle KMP
    ├── build.gradle.kts
    ├── settings.gradle.kts
    ├── desktopApp/                            ← Ejecutable de escritorio
    └── shared/
        └── src/
            ├── commonMain/kotlin/.../
            │   ├── core/
            │   │   ├── Tags.kt                ← Paso 1: Máscaras de bits
            │   │   ├── Geometry.kt            ← Paso 2: AABB y vectores
            │   │   └── Game.kt                ← Paso 3: Físicas y bucle
            │   └── entities/
            │       └── Entities.kt            ← Paso 4: Proyectil y Hechizo
            └── jvmTest/kotlin/.../            ← Pruebas unitarias de validación
```

---

## Comandos Útiles

```bash
# Ejecutar todas las pruebas de validación
task test
# o directamente con Gradle:
cd app && ./gradlew :shared:jvmTest

# Ejecutar la demo interactiva en Desktop (JVM)
task desktop
# o con Gradle:
cd app && ./gradlew :desktopApp:run
```
