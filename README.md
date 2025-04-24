## Practica Castores


#### 1. Se debe contar con Docker Instalado y docker-compose.
#### 2. Instalacion de Openjdk Version 17.
#### 3. Instalacion de maven.

### Ejecutar en tu entorno posicionado en la raiz del proyecto esta enseguida -> /app/ Debe existir un archivo Dockerfile y uno docker-compose.yml
#### 1.- mvn clean install
#### 2.- mvn clean package
#### 3.- Docker-compose up -d --build --remove-orphans
#### 4.- ir a http://localhost:8080
#### ADMINISTRADOR username=lmaria passw=12345 
#### ALMACENISTA username=gcarlos passw=12345
#### MySQL username=admin passw=password

NOTA: Esperar almenos un minuto en lo que se monta la aplicacion.
Existe un contenedor MySQL Server para el uso de la bd (La data se carga en automatico no necesariamente se deben correr los scripts)
Y otro unicamente para servir la app = el .jar
