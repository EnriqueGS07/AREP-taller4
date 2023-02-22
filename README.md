# TALLER DE ARQUITECTURAS DE SERVIDORES DE APLICACIONES, META PROTOCOLOS DE OBJETOS, PATRÓN IOC, REFLEXIÓN
- Para este taller se consttryo un servidor Web (tipo Apache) en Java. El servidor es capaz de entregar páginas html e imágenes tipo PNG. Igualmente el servidor provee un framework IoC para la construcción de aplicaciones web a partir de POJOS. Usando el servidor se construyo una aplicación Web de ejemplo. El servidor debe atender múltiples solicitudes no concurrentes.

## Iniciando
### Prerrequisitos
- GIT
- Meaven
- Compilador de codigo java
### Instalando
Abrimos la consola en la ruta que deseamos tener el proyecto
Clonamos el repositorio 
Y entramos a la carpeta raiz del proyecto
```
git clone https://github.com/EnriqueGS07/Arep-taller4.git
cd /Arep-taller4
```
Verificamos que la aplicación compile correctamente con el siguiente comando
```
mvn package
```


### Construcción:
- Anotaciones java
- Intefaces
- [Maven](https://maven.apache.org/) - Dependency Management
### Docuementacion
- Podemos encontrar la documentacion en el html que se encuentra en la carpetaPodemos encontrar la documentación del proyecto en la ruta 
```
/apidocs/index.html

```

### Arquitectura de la aplicación
- Para este taller se hizo uso de anotaciones @Component y @RequestMapping, el @Component esta en las clases las cuales se escanearan por el HTTP server y guardara en una coleccion llave-valor las respuestas que debe dar el servidor web.


### Versionamiento
- Version 1.0.0
### Autores
- Enrique González Suárez


### Ejecuar
Para ejecutar el servidor web escribimos el comando
```
mvn clean package exec:java -D"exec.mainClass"="edu.escuelaing.arep.app.Main"
```
