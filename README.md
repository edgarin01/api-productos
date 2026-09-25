# API de Productos

## Descripción

API REST desarrollada con Spring Boot para la gestión de productos y categorías mediante operaciones CRUD.

La aplicación permite registrar, consultar, actualizar y eliminar productos, consultar productos por categoría, consumir una API externa y realizar monitoreo básico mediante herramientas de observabilidad.

## Contexto

Este proyecto fue desarrollado como parte de la **Actividad Colaborativa #3: Integración y observabilidad de una API REST** de Lenguaje de Programación III.

El proyecto evoluciona una API REST desarrollada previamente, incorporando:

- Persistencia de datos mediante MySQL.
- Entidades relacionadas mediante JPA.
- Consumo de una API externa.
- Manejo de errores.
- Spring Boot Actuator.
- Métricas personalizadas.
- Prometheus.
- Logs de aplicación.
- Indicador de salud personalizado.

## Autor

José Arboleda

## Tecnologías utilizadas

- Java 17
- Spring Boot 4.1.1
- Spring Web MVC
- Spring Data JPA
- Hibernate
- MySQL 8
- Maven
- Spring Boot Actuator
- Micrometer
- Prometheus
- DummyJSON
- Git y GitHub
- Thunder Client / PowerShell

## Estructura del proyecto

```text
src/main/java/com/medcontrol/api_productos/

├── controller/
│   ├── CategoriaController.java
│   ├── ProductoController.java
│   └── ProductoExternoController.java
│
├── dto/
│   └── ProductoDTO.java
│
├── entity/
│   ├── Categoria.java
│   └── Producto.java
│
├── repository/
│   ├── CategoriaRepository.java
│   └── ProductoRepository.java
│
└── service/
    ├── EstadoApiHealthIndicator.java
    ├── MetricasService.java
    └── ProductoExternoService.java