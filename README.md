# Aprende + (Aprende Kotlin) - Kotlin Jetpack Compose
<center>
  <img src="./app/src/main/play_store_512.png" width="300"/>
</center>

Esta aplicación es un proyecto educativo desarrollado en **Kotlin** usando **Jetpack Compose**. Su objetivo es enseñar conceptos básicos y avanzados de Kotlin y Compose mediante ejemplos interactivos. La app incluye:

* **Saludo dinámico**: Permite ingresar un nombre y mostrarlo en pantalla.
* **Calculadora simple**: Suma dos números ingresados por el usuario.
* **Serie de Fibonacci recursiva**: Calcula la serie de Fibonacci usando recursión.
* **Mapa interactivo**: Muestra la ubicación de **Unitec Ecatepec** usando Google Maps.

La navegación entre estas secciones se realiza mediante un **menú lateral (Drawer)** dinámico.

---

## Capturas (Carrusel)


<div style="display: flex; overflow-x: auto; gap: 8px;">
  <img src="./screenshot/1.png" alt="Saludo" width="300"/>
  <img src="./screenshot/2.png" alt="Menú dinámico" width="300"/>
  <img src="./screenshot/3.png" alt="Calculadora" width="300"/>
  <img src="./screenshot/4.png" alt="Calculadora de Fibonacci" width="300"/>
  <img src="./screenshot/5.png" alt="Mapa" width="300"/>
</div>

---

## Tecnologías utilizadas

* Kotlin
* Jetpack Compose
* Material3
* AndroidX
* Google Maps Compose (`com.google.maps.android:maps-compose`)
* ViewModel (`lifecycle-viewmodel-compose`)

---

## Instalación y ejecución

### 1. Clonar el repositorio

```bash
git clone https://github.com/josprox/Aprende-Kotlin-Basico.git
cd pruebas-app
```

### 2. Abrir en Android Studio

* Abre **Android Studio (Arctic Fox o superior)**.
* Selecciona **Open an existing project** y busca la carpeta del repositorio.
* Asegúrate de que las dependencias se sincronicen (`Sync Project with Gradle Files`).

### 3. Configurar la API Key de Google Maps

1. Ve a [Google Cloud Console](https://console.cloud.google.com/).
2. Crea un proyecto y habilita **Maps SDK for Android**.
3. Genera una **API Key**.
4. Crea el archivo `res/values/google_maps.xml`:

```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <string name="googleplay_maps" translatable="false">TU_API_KEY</string>
</resources>
```

*(Opcional: para mayor seguridad, puedes usar **dotenv** y cargar la key desde un archivo `.env`)*

### 4. Ejecutar la app

* Conecta un dispositivo o usa un emulador con Google Play Services.
* Ejecuta la app desde Android Studio (`Shift + F10`).

---

## Uso de la app

1. Abre el **menú lateral** y selecciona la sección deseada:

   * **Saludo**: Ingresa un nombre y presiona "Mostrar saludo".
   * **Calculadora**: Ingresa dos números y presiona "Sumar".
   * **Fibonacci**: Ingresa la cantidad de términos y presiona "Calcular".
   * **Mapa Unitec**: Visualiza la ubicación de Unitec Ecatepec con marcador.

2. Todas las pantallas usan **State** y **ViewModel** para mantener los datos mientras navegas entre secciones.

---

## Estructura del proyecto

```
app/
├─ src/main/java/com/josprox/pruebas/
│  ├─ MainActivity.kt
│  ├─ ui/screens/
│  │  ├─ HomeScreen.kt (menú lateral + Scaffold)
│  │  ├─ exercises/
│  │  │  ├─ Saludo.kt
│  │  │  ├─ Calculadora.kt
│  │  │  ├─ PantallaFibonacci.kt
│  │  │  └─ PantallaMaps.kt
│  ├─ ui/routes/
│  │  └─ AppRoute.kt (gestión de rutas y título de cada pantalla)
│  └─ ui/viewmodel/
│     └─ FibonacciViewModel.kt
```

---

## Buenas prácticas

* Separación de lógica y UI: la lógica de cálculo de Fibonacci se maneja en **ViewModel**.
* Rutas centralizadas: todas las pantallas se registran en `AppRoute` para facilidad de navegación.
* Estado de Compose: se utiliza `remember` y `mutableStateOf` para mantener los valores dinámicos.
* Google Maps: se maneja con `rememberCameraPositionState` y `rememberUpdatedMarkerState`.

---

## Personalización

* Puedes añadir nuevas pantallas creando un nuevo objeto que implemente `AppRoute` y agregándolo a `AppRoute.allRoutes`.
* Para agregar más funcionalidades en la calculadora o Fibonacci, modifica los ViewModels o pantallas correspondientes.

---

## Contribuciones

1. Haz un fork del repositorio.
2. Crea una rama: `git checkout -b feature/nueva-pantalla`.
3. Realiza los cambios y haz commit.
4. Abre un Pull Request.

