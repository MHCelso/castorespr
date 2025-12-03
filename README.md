# Práctica

## Requerimientos previos

**Esta practica fue preparada para ser ejecutada en entornos preferentemente Debian/Linux**

**Si tienes windows se recomienda el uso de Windows Subsystem for Linux (WSL2)**

#### 1. Docker instalado.
#### 2. Docker Compose (docker-compose) instalado.
#### 3. JAVA Openjdk Version 17 (JDK y JRE) instalados.
#### 3. Maven instalado.

> Despues de clonar este repositorio abre la carpeta app **/castorespr/app**

> En la ubicación **/castorespr/app/** Debe existir un archivo **docker-compose.yml** enseguida debes ejecutar los siguientes comandos
> #### 1.- mvn clean install
> #### 2.- mvn clean package
> #### 3.- Docker-compose up -d --build --remove-orphans
> #### 4.- ir a http://localhost:8080

> Usuario **ADMINISTRADOR** username=**lmaria** passw=**12345**

> Usuario **ALMACENISTA** username=**gcarlos** passw=**12345**

> **MySQL Server** username=**admin** passw=**password**

```
NOTA: Esperar almenos un minuto en lo que se monta la aplicacion.

Existe un contenedor MySQL Server para el uso de la bd (La data se carga en automatico)
y otro contenedor unicamente para servir la app que es el .jar generado en el directio /castorespr/app/target/
despues de haber ejecutado los comandos: 
mvn clean install
mvn clean package
```

> Respuestas del test: [/castorespr/app/scripts/README.md](https://github.com/MHCelso/castorespr/blob/main/app/scripts/README.md)

> Datos SQL: [/castorespr/app/scripts/initdb.sql]( https://github.com/MHCelso/castorespr/blob/main/app/scripts/initdb.sql)

> Demostracion [video-practica](https://drive.google.com/file/d/1ZT0Ef1RoVpS2xY3oZNsn5YxWsy5HbC8o/view?usp=drive_link)
