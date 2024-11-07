# Prueba técnica Inditex 
[![Java](https://img.shields.io/badge/Java-007396?style=flat&logo=java&logoColor=white)](https://www.java.com/)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=flat&logo=spring-boot&logoColor=white)](https://spring.io/projects/spring-boot)
[![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=flat&logo=swagger&logoColor=white)](https://swagger.io/)
[![Mockito](https://img.shields.io/badge/Mockito-5D2F70?style=flat&logo=Mockito&logoColor=white)](https://site.mockito.org/)

## Tarea: Implementación de API REST para Consulta de Precios

### Descripción de la base de datos

En la base de datos de comercio electrónico de la compañía, disponemos de la tabla `PRICES` que refleja el precio final (PVP) y la tarifa que aplica a un producto de una cadena entre unas fechas determinadas. A continuación se muestra un ejemplo de la tabla `PRICES` con los campos relevantes:

| BRAND_ID | START_DATE              | END_DATE                | PRICE_LIST | PRODUCT_ID | PRIORITY | PRICE | CURR |
|----------|-------------------------|-------------------------|------------|------------|----------|-------|------|
| 1        | 2020-06-14-00.00.00     | 2020-12-31-23.59.59     | 1          | 35455      | 0        | 35.50 | EUR  |
| 1        | 2020-06-14-15.00.00     | 2020-06-14-18.30.00     | 2          | 35455      | 1        | 25.45 | EUR  |
| 1        | 2020-06-15-00.00.00     | 2020-06-15-11.00.00     | 3          | 35455      | 1        | 30.50 | EUR  |
| 1        | 2020-06-15-16.00.00     | 2020-12-31-23.59.59     | 4          | 35455      | 1        | 38.95 | EUR  |

#### Descripción de los campos:

- **BRAND_ID**: Foreign key que hace referencia a la cadena del grupo (1 = ZARA).
- **START_DATE** y **END_DATE**: Rango de fechas en el que aplica el precio de la tarifa indicada.
- **PRICE_LIST**: Identificador de la tarifa de precios aplicable.
- **PRODUCT_ID**: Identificador o código del producto.
- **PRIORITY**: Desambiguador para la aplicación de precios. Si dos tarifas coinciden en un rango de fechas, se aplica la de mayor prioridad (valor numérico más alto).
- **PRICE**: Precio final de venta.
- **CURR**: Código de la moneda (en este caso, EUR).

---

### Requerimientos

Se requiere construir una aplicación/servicio en **Spring Boot** que provea un endpoint REST de consulta para obtener el precio de un producto en una cadena durante un rango de fechas determinado. La aplicación debe permitir recibir los siguientes parámetros como entrada:

- **Fecha de aplicación**: La fecha y hora para la cual se desea consultar el precio.
- **Identificador de producto**: El código del producto.
- **Identificador de cadena**: El identificador de la marca (ej., 1 = ZARA).

#### Requisitos de implementación:

1. **Base de datos**:
   - Utilizar una base de datos **en memoria** (tipo **H2**).
   - Inicializar la base de datos con los datos de ejemplo de la tabla `PRICES` mencionada anteriormente.
   - Se puede cambiar el nombre de los campos y añadir otros nuevos si se considera necesario, así como elegir los tipos de datos adecuados.

2. **Endpoint REST**:
   - Implementar un servicio que reciba la fecha, el identificador del producto y el identificador de la cadena, y que devuelva el precio correspondiente para esa fecha y producto.
   - En caso de que haya múltiples tarifas válidas en el rango de fechas, se debe aplicar la de mayor prioridad.

3. **Pruebas**:
   Desarrollar pruebas para validar las siguientes peticiones al endpoint REST utilizando los datos de ejemplo de la tabla `PRICES`:

   - **Test 1**: Petición a las **10:00 del día 14** del producto **35455** para la marca **1 (ZARA)**.
   - **Test 2**: Petición a las **16:00 del día 14** del producto **35455** para la marca **1 (ZARA)**.
   - **Test 3**: Petición a las **21:00 del día 14** del producto **35455** para la marca **1 (ZARA)**.
   - **Test 4**: Petición a las **10:00 del día 15** del producto **35455** para la marca **1 (ZARA)**.
   - **Test 5**: Petición a las **21:00 del día 16** del producto **35455** para la marca **1 (ZARA)**.

---

### Criterios de evaluación:

- **Diseño y construcción del servicio**: La correcta implementación de la API REST y la base de datos.
- **Calidad de código**: Limpieza, modularidad, y legibilidad del código.
- **Resultados correctos en los test**: La precisión de las respuestas generadas por el endpoint en las pruebas mencionadas.

-------------------------------------------------------------------------------------------------------------------------------------
## Tecnologías Utilizadas

- **Spring Boot**: Framework para la creación de aplicaciones Java basadas en Spring.
- **Spring Data JPA**: Para la gestión de la base de datos.
- **H2 Database**: Base de datos en memoria.
- **Swagger/OpenAPI**: Para la documentación interactiva de la API.
- **JUnit y Mockito**: Para realizar pruebas unitarias y de integración.

## Estructura 

```bash
InditexPriceAPI
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── com
│   │   │   │   └── inditex
│   │   │   │       ├── application
│   │   │   │       │   ├── exception
│   │   │   │       │   │   └── PriceNotFoundException.java
│   │   │   │       │   ├── service
│   │   │   │       │   │   ├── PriceService.java
│   │   │   │       │   │   └── PriceServiceImpl.java
│   │   │   │       ├── domain
│   │   │   │       │   ├── model
│   │   │   │       │   │   └── Price.java
│   │   │   │       │   └── repository
│   │   │   │       │       └── PriceRepository.java
│   │   │   │       ├── infrastructure
│   │   │   │       │   └── config
│   │   │   │       │       ├── ApplicationConfig.java
│   │   │   │       │       ├── DatabaseConfig.java
│   │   │   │       │       └── SwaggerConfig.java
│   │   │   │       ├── web
│   │   │   │       │   ├── advice
│   │   │   │       │   │   └── GlobalExceptionHandler.java
│   │   │   │       │   ├── controller
│   │   │   │       │   │   └── PriceController.java
│   │   │   │       │   └── dto
│   │   │   │       │       └── PriceDTO.java
│   │   │   │       ├── InditexApplication.java
│   │   └── resources
│   │       ├── application.properties
│   │       ├── banner.txt
│   │       └── data.sql
└── README.md
```

## Características

- Endpoint REST para consultar el precio de un producto para una marca en un rango de fechas.
- La base de datos está inicializada con datos de ejemplo para simular consultas.
- Swagger UI para interactuar con la API de forma visual.

## Cómo Iniciar la Aplicación

1. Clona este repositorio en tu máquina local:

    ```bash
    git clone https://github.com/tu-usuario/inditex-price-api.git
    cd inditex-price-api
    ```

2. Asegúrate de tener **Java 17** o superior instalado en tu máquina. Para verificar, ejecuta:

    ```bash
    java -version
    ```
     2.1 Prueba test 
    ```bash
    ./mvnw test
    ```
3. Ejecuta el proyecto con Maven:

    ```bash
    ./mvnw spring-boot:run
    ```

4. La aplicación debería estar corriendo en [http://localhost:8081](http://localhost:8081).

## Usando la API con Swagger

Una vez que la aplicación esté en ejecución, puedes acceder a la documentación interactiva de Swagger en la siguiente URL:

[http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html)

### Ejemplo de Petición:

Para consultar el precio de un producto, utiliza el siguiente formato en la URL de la API:

```bash
GET http://localhost:8081/prices?productId=35455&brandId=1&date=2020-06-14-10:00:00

Respuesta esperada :
{
    "id": 1,
    "productId": 35455,
    "brandId": 1,
    "priceList": 1,
    "startDate": "2020-06-14-00:00:00",
    "endDate": "2020-12-31-23:59:59",
    "price": 35.50,
    "curr": "EUR"
}

```

