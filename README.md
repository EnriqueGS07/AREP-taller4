# TALLER MICROFRAMEWORKS WEB
Para este ejercicio se construyo servidor web para soportar una funcionalidad similar a la de Spark. La aplicaciójn permite el registro de servicios get y post usando funciones lambda. Se Implementaron funciones que le permiten configurar el directorio de los archivos estáticos, y otra que permita cambiar el tipo de la respuesta a "application/json". Todo esto se construyo unicamente con el API de java, sin frameworks.

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
git clone https://github.com/EnriqueGS07/AREP-taller3.git
cd /AREP-taller3
```
Verificamos que la aplicación compile correctamente con el siguiente comando
```
mvn package
```


### Construcción:
- La aplicación implementa funciones lamnda para poder realizar metodos get y post, se usa una interfaz funcional llamada RouteHandler la cual permite retornar la respuesta la cual la interprestara el navegador, se relizo una clase spark2 la cual usa la clase HTTPserver para poder hacer las peticiones al servidor
- [Maven](https://maven.apache.org/) - Dependency Management
Podemos encontrar la documentación del proyecto en la ruta 
```
/target/site/apidocts
```



### Versionamiento
- Version 1.0.0
### Autores
- Enrique González Suárez
### Ejecutar
Para ejecutar el servidor web escribimos el comando
```
mvn clean package exec:java -D"exec.mainClass"="edu.escuelaing.arep.app.Main"
```

