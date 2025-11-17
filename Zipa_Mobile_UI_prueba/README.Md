<div style="display: flex; justify-content: center; align-items: center;">
  <img src="assets/Logo.png" alt="Mi logo" style="width:150px; margin-right:20px;">
</div>

# Zipa: Tienda de productos y servicios para mascotas (PetShop)
## Equipo 2D
- Diego Humberto Lavado González
- Fabián Alejandro Torres Ramos
- Juan Camilo Daza Gutiérrez
- Santiago Alfonso Pineda Ceballos
- Victor Manuel Torres Alonso


## 1. Descarga del repositorio

Clona el proyecto desde GitHub:

``` bash
git clone https://github.com/<usuario>/docker-android.git
```

## 2. Configuración inicial

Asegúrate de tener instalados: - Docker y Docker Compose - Android
Studio (si deseas conectar una app Android) - SDK Platform Tools

## 3. Despliegue del entorno Docker

Dentro del proyecto, ejecuta:

``` bash
docker compose up --build
```

Esto levantará: - La API backend\
- El emulador Android dentro de Docker\
- Puertos expuestos listos para conectar con Android Studio

## 4. Conexión con Android Studio

1.  Abre tu proyecto en Android Studio.\
2.  Ve a **Settings \> Build, Execution, Deployment \> Debugger**.\
3.  Añade un dispositivo remoto usando la IP del contenedor o
    `localhost` si estás haciendo port-forward.\
4.  Ejecuta tu app y verifica conexión con la API usando los endpoints
    expuestos.

## 5. Uso del entorno

-   Puedes consumir la API desde tu app Android (por ejemplo
    `http://10.0.2.2:8080/api/profile` dentro del emulador).
-   Monitorea contenedores:

``` bash
docker compose ps
```

-   Ver logs:

``` bash
docker compose logs -f
```

## 6. Apagado del entorno

``` bash
docker compose down
```
