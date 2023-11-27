# Evaluación Java

En la carpeta docs se adjunta el enunciado para el reto de creación de API de consulta de precios de una empresa retail dedicada al comercio electrónico.

## Solución

Para dar solución a la prueba, se consideraron los siguientes pasos:

1. Análisis de requerimiento, considerando los requisitos funcionales y no funcionales solicitados para poder definir el alcance y entregables.

###2. Diseñar a alto nivel la arquitectura de desarrollo y para ello se consideró###

**Arquitectura Hexagonal**: Para poder centrarnos en el dominio y mantener una estructura extensible donde si más adelante se presenta un cambio en la entrada o salida (adaptadores) será muy fácil de mantener.

**Principios SOLID**: Para mantener una única responsabilidad en las clases, y como se mencionó el ser abierto para la extensión (por ejemplo un nuevo repositorios, bd, inputs, puertos) pero cerrado para modificación (dominio, application), y el principio de inversión de dependencia donde los módulos de alto nivel no dependen del módulo de bajo nivel, permitiendo así el desacoplamiento.

**Patrones de Diseño en Arquitectura Hexagonal**: Se mencionará los más usados en la implementación´
*Patrón de Estrategia, como en el caso donde diferentes implementaciones de los puertos pueden ser intercambiados sin afectar al núcleo de la aplicación. 
*Patrón de Repositorio, se utilizó en la persistencia donde los detalles de bases de datos se manejan fuera del dominio de la aplicación.
*Patrón de Fábrica y Patrón de Adaptador, fue útil para crear adaptadores específicos según los procesos de entrada  (http) y salida (BD H2)
*Inyección de dependencias, útil para las pruebas unitarias e integrales.

**DDD**: Se tuvo como base el énfasis en el modelado y diseño del dominio del negocio, identificando contextos y entidades relacionadas al sistema de comercio electrónico y el precio (precio, marca, producto)así como el desacoplamiento de los adaptadores que rodean al dominio así como la capa infraestructura en DDD.

![Image](/docs/images/ArquitecturaHexagonalProject.jpg)

**TDD**: Según la especificación se requería un caso de prueba de consulta de precios, a partir de ello se inició el desarrollo con las pruebas atómicas e integrales para cumplir con este alcance.

![Image](/docs/images/JUnitTest.jpg)

**API First y Estándar OpenAPI**: Se contempló estándares en las respuestas del API REST, manejando excepciones a través de ControllerAdvice, documentación swagger de los campos y data ejemplo.

![Image](/docs/images/Excepciones.jpg)

**Clean Code**: Manejando estándares y usando herramientas de Clean Code como Sonarqube logrando el 0% de Issues:

![Image](/docs/images/Sonarqube.jpg)

** Test Unitarios y de Integración**: Se realizó el test unitario a la mayoría de clases priorizando el dominio y en las pruebas de integración se enfocó en simular el flujo desde la solicitud web hacia la persistencia en una BD H2, para la visualización de cobertura se empleó JaCoCo


![Image](/docs/images/JaCoCo.jpg)

###3. Para la implementación se consideraron las siguientes capas principales según la arquitectura hexagonal###:
- 	/domain (clases, excepciones)
- 	/application (casos de uso, servicio)
- 	/ports (interfaces in/out)
- 	/adapter (implementaciones)
- 	/test

###4. Se aplicó el enfoque API First para iniciar con el diseño de las APIS y luego la codificación y se usó una herramienta de generación de código para que a partir del diseño de APIs genere las clases en el lenguaje Java con la funcionalidad dada en el siguiente link
https://editor.swagger.io/

	![Image](/docs/images/APIFirst.jpg)

###5. Se aplicó el enfoque de TDD para resolver los 5 casos de prueba solicitados.

Las pruebas se realizaron a través de JUnit, Postman, Swagger. Se adjunta en la carpeta docs, el archivo Collection para las pruebas Postman.

### JUnit:

![Image](/docs/images/JUnitTestNew.jpg)

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
- Mockito
- JaCoCo
- Sonarqube
- Postman
- Open API
- Principios SOLID
- Arquitectura Hexagonal
