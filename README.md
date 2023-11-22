# Test Java

En la carpeta docs se adjunta el enunciado para el reto de creación de API de consulta de precios de una empresa retail dedicada al comercio electrónico.

## Solución

Para dar solución al test, se consideraron los siguientes pasos:

1. Análisis de requerimiento, considerando los requisitos funcionales y no funcionales solicitados para poder definir el alcance y entregables.

2. Diseñar a alto nivel la arquitectura de desarrollo, y para ello se consideró un enfoque basado en Arquitectura Hexagonal, Principios SOLID, Patrones de Diseño, DDD, TDD, API First, estándar OpenAPI, Clean Code, Test Unitarios y de Integración.

![Image](/docs/images/ArquitecturaHexagonalProject.jpg)

3. Para la implementación se consideraron las siguientes capas principales según la arquitectura hexagonal:
- 	/dominio (clases, excepciones)
- 	/application (casos de uso, servicio)
- 	/ports (interfaces in/out)
- 	/adapter (implementaciones)

4. Para las pruebas:
- 	/test

5. Se aplicó el enfoque API First y se usó una herramientas de generación de código a partir del diseño de APIs con la funcionalidad dada en el siguiente link
https://editor.swagger.io/

	![Image](/docs/images/APIFirst.jpg)

6. Se aplicó el enfoque de TDD para tomar en cuenta los 5 casos de prueba solicitados.

7. Las pruebas se realizaron a través de JUnit, Postman, Swagger. Se adjunta en la carpeta docs, el archivo Collection para las pruebas Postman.

### JUnit:

![Image](/docs/images/JUnitTest.jpg)

 ### Swagger:

![Image](/docs/images/SwaggerTest.jpg)

 ### Postman:
 
![Image](/docs/images/PostmanTest.jpg)


**Url API**: http://localhost:8081/price/getByBrandAndProduct?applicationDate=applicationDate&productId=productId&brandId=brandId

**Ejemplo**: http://localhost:8081/price/getByBrandAndProduct?applicationDate=2020-06-14-10.00.00&productId=35455&brandId=1

**Acceso a swagger**:
http://localhost:8081/swagger.html

**Tecnologías y herramientas** :

- Java 17
- SpringBoot
- JPA
- H2
- MapStruct
- Maven
- Swagger
- JUnit
- Postman
- Open API
- Principios SOLID
- Arquitectura Hexagonal

