# API de Productos

## Descripción

API REST desarrollada para la gestión de productos mediante operaciones CRUD
(Create, Read, Update y Delete).

La aplicación permite registrar, consultar, actualizar y eliminar productos,
además de realizar una consulta personalizada por categoría.

## Contexto

Este proyecto fue desarrollado como parte de la Actividad Colaborativa #2,
con el propósito de implementar una API REST utilizando Spring Boot,
JPA e Hibernate, incorporando persistencia de datos mediante una base de
datos H2.

## Autor

José Arboleda

## Tecnologías utilizadas

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- H2 Database
- Maven
- Thunder Client
- Git y GitHub

## Estructura del proyecto

```text
src/main/java/com/medcontrol/api_productos/
├── controller/
│   └── ProductoController.java
├── dto/
│   └── ProductoDTO.java
├── entity/
│   └── Producto.java
└── repository/
    └── ProductoRepository.java